package emfer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import emfer.ModelIsomorphismOp.CertInfo;
import emfer.reachability.ReachableState;

public class ModelIsomorphismOp
{
   public static class CertInfo
   {
      private String certificate;
      
      public String getCertificate()
      {
         return certificate;
      }
      
      public void setCertificate(String certificate)
      {
         this.certificate = certificate;
      }
      
      private Map<EObject,String> node2CertMap = new LinkedHashMap<EObject, String>();
      
      public Map<EObject, String> getNode2CertMap()
      {
         return node2CertMap;
      }
      
      public void setNode2CertMap(Map<EObject, String> node2CertMap)
      {
         this.node2CertMap = node2CertMap;
      }
   }
   
   public CertInfo computeCertificate(EObject root, CertInfo staticCertInfo)
   {
      Set<EObject> dynNodes = new LinkedHashSet<EObject>();
      
      dynNodes.add(root);
      
      aggregate(dynNodes, staticCertInfo);

      CertInfo certificate = computeCertificate(dynNodes, staticCertInfo);
      
      return certificate;
   }

   public CertInfo computeCertificate(Set<EObject> dynNodes, CertInfo staticCertInfo)
   {
      Map<String,String> allCertificate2Number = new TreeMap<String, String>();
      
      Map<EObject,String> oldNode2CertNo = new LinkedHashMap<EObject, String>();
      
      long oldNumOfCertificates = 0;
      
      CertInfo newCertInfo = new CertInfo();
      
      for (EObject o : dynNodes)
      {
         StringBuilder simpleCert = new StringBuilder(o.eClass().getName()).append('\n');

         EClass eClass = o.eClass();
         
         // loop through props
         for (EStructuralFeature prop : eClass.getEAllStructuralFeatures())
         {
            Object value = o.eGet(prop);
            
            if (value != null)
            {
               if (value instanceof EList)
               {
                  // ignore sets of model objects
                  continue;
               }
               else if (dynNodes.contains(value))
               {
                  // ignore model objects
                  continue; 
               }
               else if (staticCertInfo.getNode2CertMap().get(value) != null)
               {
                  // ignore model objects
                  continue; 
               }
               else // plain value
               {
                  simpleCert.append("   ").append(prop.getName()).append(": ").append(value.toString()).append("\n");
               }
            }
         } // for (String prop : creator.getProperties())
         allCertificate2Number.put(simpleCert.toString(), "");
         oldNode2CertNo.put(o, simpleCert.toString());
      }
      
      // number new certificates
      int numOfCerts = 0;
      for (String cert : allCertificate2Number.keySet())
      {
         numOfCerts++;
         allCertificate2Number.put(cert, "" + numOfCerts);
      }

      // assign cert numbers to nodes
      for (EObject o : dynNodes)
      {
         String simpleCert = oldNode2CertNo.get(o);
         String certNo = allCertificate2Number.get(simpleCert);
         oldNode2CertNo.put(o, certNo);
      }
      
      TreeMap<String, ArrayList<EObject>> cert2Nodes = new TreeMap<String, ArrayList<EObject>>();
      
      
      ArrayList<String> valueCertNumbers = new ArrayList<String>();

      while (true)
      {
         // collect new certificates
         for (EObject o : dynNodes)
         {
            EClass eClass = o.eClass();
            
            String certNo = oldNode2CertNo.get(o);
            Objects.requireNonNull(certNo);

            StringBuilder newCertificate = new StringBuilder().append(certNo).append(": \n");
            
            // loop through props
            for (EStructuralFeature prop : eClass.getEAllStructuralFeatures())
            {
               Object value = o.eGet(prop);
               
               if (value != null)
               {
                  if (value instanceof Collection)
                  {
                     Collection valueCollection = (Collection) value;

                     valueCertNumbers.clear();

                     for (Object valueElem : (Collection) value)
                     {
                        if ( dynNodes.contains(valueElem))
                        {
                           String valueCertNo = oldNode2CertNo.get(valueElem);
                           Objects.requireNonNull(valueCertNo);
                           valueCertNumbers.add(valueCertNo);
                        }
                        else if (staticCertInfo.getNode2CertMap().get(valueElem) != null)
                        {
                           String valueCertNo = staticCertInfo.getNode2CertMap().get(valueElem);
                           Objects.requireNonNull(valueCertNo);
                           valueCertNo = "S" + valueCertNo;
                           valueCertNumbers.add(valueCertNo);
                        }
                     }

                     if ( ! valueCertNumbers.isEmpty())
                     {
                        valueCertNumbers.sort(null);

                        newCertificate.append("   ").append(prop.getName()).append(": ");
                        for (String no : valueCertNumbers)
                        {
                           newCertificate.append(no).append(' ');
                        }
                        newCertificate.append('\n');
                     }
                  }
                  else if (dynNodes.contains(value))
                  {
                     String valueCertNo = oldNode2CertNo.get(value);
                     Objects.requireNonNull(valueCertNo);
                     newCertificate.append("   ").append(prop.getName()).append(": ").append(valueCertNo).append("\n");
                  }
                  else if (staticCertInfo.getNode2CertMap().get(value) != null)
                  {
                     String valueCertNo = staticCertInfo.getNode2CertMap().get(value);
                     Objects.requireNonNull(valueCertNo);
                     valueCertNo = "S" + valueCertNo;
                     newCertificate.append("   ").append(prop.getName()).append(": ").append(valueCertNo).append("\n");
                  }
                  else // plain value
                  {
                     // already contained in simple cert, ignore
                     continue;
                  }
               }
            } // for (String prop : creator.getProperties())

            ArrayList nodeList = cert2Nodes.get(newCertificate.toString());
            if (nodeList == null)
            {
               nodeList = new ArrayList();
               cert2Nodes.put(newCertificate.toString(), nodeList);
            }

            nodeList.add(o);
         } // for (Object o : graph)

         // number certificates and assign numbers to nodes and count nodes per certificate
         for (String newCert : cert2Nodes.keySet())
         {
            String certNo = allCertificate2Number.get(newCert);
            if (certNo == null)
            {
               certNo = "" + (allCertificate2Number.size() + 1);
               allCertificate2Number.put(newCert, certNo);
            }
            
            for (EObject elem : cert2Nodes.get(newCert))
            {
               newCertInfo.getNode2CertMap().put(elem, certNo);
            }
         }

         if (cert2Nodes.size() <= oldNumOfCertificates || cert2Nodes.size() == dynNodes.size())
         {
            // write state certificate
            StringBuilder buf = new StringBuilder();
            for (String cert : cert2Nodes.keySet())
            {
               Integer noOfNodes = cert2Nodes.get(cert).size();
               String certNo = allCertificate2Number.get(cert);

               buf.append(certNo).append('*').append(noOfNodes)
               .append('\n');
            }

            // append certNo certText list
            for ( Entry<String, String> entry : allCertificate2Number.entrySet())
            {
               buf.append(entry.getValue()).append(": ").append(entry.getKey());
            }

            newCertInfo.setCertificate(buf.toString());
            
            break;
         }
         

         // do another round
         oldNumOfCertificates = cert2Nodes.size();
         cert2Nodes.clear();
         
         Map<EObject, String> tmp = oldNode2CertNo;
         oldNode2CertNo = newCertInfo.getNode2CertMap();

         tmp.clear();
         
         newCertInfo.setNode2CertMap(tmp);
      } // while
      
      return newCertInfo;
   }

   public void aggregate(Set<EObject> dynNodes, CertInfo staticCertInfo)
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
                  if (elem instanceof EObject 
                        && ! dynNodes.contains(elem) 
                        && staticCertInfo.getNode2CertMap().get(elem) == null)
                  {
                     EObject e = (EObject) elem;
                     dynNodes.add(e);
                     todo.add(e);
                  }
               }
            }
            else if (value instanceof EObject 
                  && ! dynNodes.contains(value) 
                  && staticCertInfo.getNode2CertMap().get(value) == null)
            {
               EObject e = (EObject) value;
               dynNodes.add(e);
               todo.add(e);
            }
         }
      }
   }
   
   
   public Boolean lazyMatch(ReachableState s1, ReachableState s2, CertInfo staticCertInfo)
   {
      Map<EObject, EObject> fwdmapping = new LinkedHashMap<EObject, EObject>();
      Map<EObject, EObject> bwdmapping = new LinkedHashMap<EObject, EObject>();

      EObject root1 = s1.getRoot();
      EObject root2 = s2.getRoot();
      
      fwdmapping.put(root1, root2);
      bwdmapping.put(root2, root1);

      boolean match = lazyMatch(s1, s2, root1, staticCertInfo, fwdmapping, bwdmapping);

      return match ? true : null;     
   }

   private boolean lazyMatch(ReachableState s1, ReachableState s2, EObject cn1, CertInfo staticCertInfo, 
         Map<EObject, EObject> fwdmapping, 
         Map<EObject, EObject> bwdmapping)
   {
      EObject cn2 = fwdmapping.get(cn1);
      
      // a mapping for currentNode has just been added. Validate it and compute
      // mappings for neighbors
      // certificates are equal, only check refs
      // go through properties
      EClass eClass = cn1.eClass();
      
      for (EStructuralFeature prop : eClass.getEAllStructuralFeatures())
      {
         Object value1 = cn1.eGet(prop);
         Object value2 = cn2.eGet(prop);
         
         if (value1 == null)
         {
            // certificates match, thus value2 == null should hold, too.
            if (value2 != null)
            {
               return false;
            }
            else
            {
               // else go on with next property
               continue;
            }
         }
         
         if (value1 instanceof Collection)
         {
            obj1RefLoop: for (Object object1 : (Collection) value1)
            {
               // might already have been matched? 
               Object mapObject2 = fwdmapping.get(object1);
               
               if (mapObject2 != null)
               {
                  // consistent? 
                  if (((Collection) value2).contains(mapObject2))
                  {
                     // yes
                     continue;
                  }
                  else
                  {
                     return false;
                  }
               }
               
               
               // not yet mapped, search for mapping
               for (Object object2 : (Collection) value2)
               {
                  if (object1 == object2)
                  {
                     // the object is actually shared by both states. 
                     // thus it definitely matches to itself
                     fwdmapping.put((EObject) object1, (EObject) object2);
                     bwdmapping.put((EObject) object2, (EObject) object1);
                     
                     continue obj1RefLoop;
                  }
                  
                  
                  if (bwdmapping.get(object2) != null)
                  {
                     // has already been mapped to someone else.
                     continue;
                  }
                  
                  String staticCert1 = staticCertInfo.getNode2CertMap().get(object1);
                  if (staticCert1 != null)
                  {
                     String staticCert2 = staticCertInfo.getNode2CertMap().get(object2);
                     
                     if ( ! Objects.equals(staticCert1, staticCert2))
                     {
                        // try some other object2
                        continue;
                     }
                  }
                  
                  // might be a candidate, match it
                  fwdmapping.put((EObject) object1, (EObject) object2);
                  bwdmapping.put((EObject) object2, (EObject) object1);

                  boolean match = lazyMatch(s1, s2, (EObject) object1, staticCertInfo, fwdmapping, bwdmapping); 

                  if (!match)
                  {
                     // did not work
                     fwdmapping.remove(object1);
                     bwdmapping.remove(object2);
                     
                     continue;
                  }
                  else
                  {
                     continue obj1RefLoop;
                  }
               }
               
               // did not find a match for object1, thus cn2 does not match cn1
               return false;
               
            }
         }
         else
         {
            // neighbor object?
            // only care for refs
            if ( ! (value1 instanceof EObject))
            {
               // better check
               if (value1.equals(value2))
               {
                  continue;
               }
               else
               {
                  return false;
               }
            }
            
            // might already have been matched? 
            Object mapValue2 = fwdmapping.get(value1);
            
            if (mapValue2 != null)
            {
               // consistent? 
               if (mapValue2 == value2)
               {
                  // yes
                  continue;
               }
               else
               {
                  return false;
               }
            }
            
            if (value1 == value2)
            {
               // definitely isomorph
               continue;
            }
            
            String staticCert1 = staticCertInfo.getNode2CertMap().get(value1);
            if (staticCert1 != null)
            {
               String staticCert2 = staticCertInfo.getNode2CertMap().get(value2);
               
               if ( ! Objects.equals(staticCert1, staticCert2))
               {
                  // try some other object2
                  return false;
               }
            }
            
            // not yet mapped, thus add mapping and check it.
            fwdmapping.put((EObject) value1, (EObject) value2);
            bwdmapping.put((EObject) value2, (EObject) value1);

            boolean match = lazyMatch(s1, s2, (EObject) value1, staticCertInfo, fwdmapping, bwdmapping); 

            if (!match)
            {
               // did not work
               fwdmapping.remove(value1);
               bwdmapping.remove(value2);
               
               return false;
            }
            else
            {
               continue;
            }
         }
      }
      
      return true;
   }


}
