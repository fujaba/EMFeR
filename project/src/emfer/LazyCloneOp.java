package emfer;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Logger;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;

import emfer.ModelIsomorphismOp.CertInfo;
import emfer.reachability.ReachabilityFactory;
import emfer.reachability.ReachableState;


public class LazyCloneOp extends EContentAdapter
{
   private LinkedHashMap<EObject, EObject> origToCloneMap = new LinkedHashMap<EObject, EObject>();
   private LinkedHashMap<EObject, EObject> cloneToOrigMap = new LinkedHashMap<EObject, EObject>();
   
   public void reset()
   {
      origToCloneMap.clear();
      cloneToOrigMap.clear();
      changesList.clear();
   }

   
   public LinkedHashMap<EObject, EObject> getOrigToCloneMap()
   {
      return origToCloneMap;
   }
   
   public LinkedHashMap<EObject, EObject> getCloneToOrigMap()
   {
      return cloneToOrigMap;
   }
   
   public void aggregate(Set<EObject> dynNodes, ArrayList<Object> dynEdges, CertInfo staticCertInfo)
   {
      ArrayList<EObject> todo = new ArrayList<EObject>();
      todo.addAll(dynNodes);
      
      while (! todo.isEmpty())
      {
         EObject eObject = todo.remove(todo.size()-1);
         
         EClass eClass = eObject.eClass();
         
         for ( EStructuralFeature f : eClass.getEAllStructuralFeatures())
         {
            Object value = eObject.eGet(f);
            
            if (value instanceof EList)
            {
               for (Object elem : (EList) value)
               {
                  if (elem != null && elem instanceof EObject)
                  {
                     dynEdges.add(eObject);
                     dynEdges.add(f);
                     dynEdges.add(elem);

                     if (! dynNodes.contains(elem) 
                           && staticCertInfo.getNode2CertMap().get(elem) == null)
                     {
                        EObject e = (EObject) elem;
                        dynNodes.add(e);
                        todo.add(e);
                     }
                  }
               }
            }
            else if (value != null && value instanceof EObject)
            {
               dynEdges.add(eObject);
               dynEdges.add(f);
               dynEdges.add(value);
               
               if (! dynNodes.contains(value) 
                  && staticCertInfo.getNode2CertMap().get(value) == null)
               {
                  EObject e = (EObject) value;
                  dynNodes.add(e);
                  todo.add(e);
               }
            }
         }
         
         EObject eContainer = eObject.eContainer();
         
         if (eContainer != null)
         {
            dynEdges.add(eObject);
            dynEdges.add(null);
            dynEdges.add(eContainer);
         }
         
      }
   }
   

   
   public EObject clone(EObject orig, CertInfo staticCertInfo)
   {
      EObject clone = origToCloneMap.get(orig);

      if (clone != null)
      {
         // already done
         return clone;
      }

      LinkedList<EObject> climbTodo = new LinkedList<EObject>();
      LinkedList<EObject> cloneTodo = new LinkedList<EObject>();

      climbTodo.add(orig);
      cloneTodo.add(orig);
      
      Set<EObject> dynNodes = new LinkedHashSet<EObject>();
     
      
      ArrayList<Object> dynEdges = new ArrayList<Object>();
      
      // try to compute clone graph from first entry of origToCloneMap 
      if ( ! origToCloneMap.isEmpty())
      {
         orig = origToCloneMap.keySet().iterator().next();
         clone = origToCloneMap.get(orig);
         dynNodes.add(clone);
         aggregate(dynNodes, dynEdges, staticCertInfo);
      }
      else
      {
         dynNodes.add(orig);
         aggregate(dynNodes, dynEdges, staticCertInfo);
      }
      
      
      while ( ! climbTodo.isEmpty())
      {
         orig = climbTodo.pollFirst();

         // for any dyn edge that points to orig clone its src
         for (int i = 0; i < dynEdges.size(); i += 3)
         {
            EObject src = (EObject) dynEdges.get(i);
            EObject tgt = (EObject) dynEdges.get(i+2);
            
            if (tgt == orig)
            {
               Object srcOrig = cloneToOrigMap.get(src);
               Object srcClone = origToCloneMap.get(src);
               if (! cloneTodo.contains(src) && srcOrig == null && srcClone == null)
               {
                  climbTodo.add(src);
                  cloneTodo.add(src);
               }
            }
         }
      }
      
      for (EObject o : cloneTodo)
      {
         EClass eClass = o.eClass();
         
         // create clone
         clone = EcoreUtil.create(eClass);
         
         origToCloneMap.put(o, clone);
         cloneToOrigMap.put(clone, o);
      }
      
      
      for (EObject o : cloneTodo)
      {
         clone = origToCloneMap.get(o);
         
         Objects.requireNonNull(clone);
         
         EClass eClass = o.eClass();

         // copy properties
         for (EStructuralFeature prop : eClass.getEAllStructuralFeatures())
         {
            Object value = o.eGet(prop);

            Object neighborOrig = null;
            Object neighborClone = null;
            
            if (value != null && value instanceof EList)
            {
               // if our neighbor is currently cloned, we connect to that clone, only. 
               ArrayList<Object> list = new ArrayList<Object>(((EList)value).size());
               
               list.addAll((EList)value);
               
               EList cloneEList = (EList) clone.eGet(prop);
               
               for (Object neighbor : list)
               {
                  neighborClone = origToCloneMap.get(neighbor);
                  neighborOrig = cloneToOrigMap.get(neighbor);
                  
                  if (neighborOrig != null)
                  {
                     Logger.getGlobal().warning("x is about to be cloned, but points already to a clone. That should not happen");
                  }
                  else if (neighborClone == null)
                  {
                     // our clone should point to the neighbor
                     cloneEList.add(neighbor);
                  }
                  else
                  {
                     // our clone should point to the neighborClone
                     cloneEList.add(neighborClone);
                  }
               }
            }
            else
            {
               neighborClone = origToCloneMap.get(value);
               
               if (neighborClone == null)
               {
                  // our clone should point to the value
                  clone.eSet(prop, value);
               }
               else
               {
                  // our clone should point to the neighborClone
                  clone.eSet(prop, neighborClone);
               }
            }
         }
         
         // redirect incoming unidirectional edges
         for (int i = 0; i < dynEdges.size(); i += 3)
         {
            EObject src = (EObject) dynEdges.get(i);
            EStructuralFeature prop = (EStructuralFeature) dynEdges.get(i+1);
            EObject tgt = (EObject) dynEdges.get(i+2);
            
            if (tgt == o && prop != null)
            {
               // if source is a clone
               Object srcOrig = cloneToOrigMap.get(src);
               if (srcOrig != null)
               {
                  // src should point to clone
                  // in case of to-many remove old edge, first
                  Object value = src.eGet(prop);
                  
                  if (value instanceof Collection)
                  {
                     EList valueList = (EList) value;
                     valueList.remove(o);
                     
                     valueList.add(clone);
                  }
                  else
                  {
                     src.eSet(prop, clone);
                  }
               }
            }
         }
      }
      
      return clone;
   }
   
   

   public ArrayList<Notification> changesList = new ArrayList<Notification>();

   public boolean enableChangeRecording = false;
   
   @Override
   public void notifyChanged(Notification notification)
   {
      if (enableChangeRecording)
      {
         changesList.add(notification);
      }
   }
   
   public ReachableState transferChangesToClone(ReachableState current, Set<EObject> dynNodes, CertInfo staticCertInfo)
   {
      if (changesList.isEmpty())
      {
         return null;
      }
      
      
      Notification e;
      
      // undo changes to current graph
      for (int i = changesList.size() - 1; i >= 0; i--)
      {
         e = changesList.get(i);
         
         EObject source = (EObject) e.getNotifier();
         
         EStructuralFeature prop = (EStructuralFeature) e.getFeature();
         Object newValue = e.getNewValue();
         Object oldValue = e.getOldValue();
         
         Object value = source.eGet(prop); //.creator.getValue(source, prop);
         
         if (value instanceof Collection)
         {
            if (newValue != null)
            {
               // newValue has been added to container, for undo, remove it 
               ((EList) value).remove(newValue);
            }
            else
            {
               ((EList) value).add(oldValue);
            }
         }
         else
         {
            source.eSet(prop, oldValue);
         }
      }

      // prepare clone graph
      this.clone(current.getRoot(), staticCertInfo);
      EObject newGraphRoot = origToCloneMap.get(current.getRoot());
      
      ReachableState newReachableState = ReachabilityFactory.eINSTANCE.createReachableState();
      newReachableState.setRoot(newGraphRoot);
      
      
      // apply changes to clone graph
      for (int i = 0; i < changesList.size(); i++)
      {
         e = changesList.get(i);
         
         EObject source = (EObject) e.getNotifier();
         
         clone(source, staticCertInfo);
      }

      for (int i = 0; i < changesList.size(); i++)
      {
         e = changesList.get(i);
         
         EObject source = (EObject) e.getNotifier();
         
         EStructuralFeature prop = (EStructuralFeature) e.getFeature();
         Object newValue = e.getNewValue();
         Object oldValue = e.getOldValue();
         
         EObject sourceClone = getOrigToCloneMap().get(source);
         
         Objects.requireNonNull(sourceClone);
         
         Object newValueClone = getOrigToCloneMap().get(newValue);
         if (newValueClone == null)
         {
            newValueClone = newValue;
         }
         
         Object oldValueClone = getOrigToCloneMap().get(oldValue);
         if (oldValueClone == null)
         {
            oldValueClone = oldValue;
         }
         
         
         Object value = sourceClone.eGet(prop);
         
         if (value instanceof Collection)
         {
            if (newValue == null)
            {
               // newValue has been removed from collection,
               ((EList)value).remove(oldValueClone);
            }
            else
            {
               ((EList)value).add(newValueClone);
            }
         }
         else
         {
            sourceClone.eSet(prop, newValueClone);
         }
      }
      
      return newReachableState;
   }

}
