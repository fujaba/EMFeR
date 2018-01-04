/**
 */
package emfer.reachability.impl;

import emfer.reachability.ReachabilityGraph;
import emfer.reachability.ReachabilityPackage;
import emfer.reachability.ReachableState;
import emfer.reachability.TrafoApplication;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trafo Application</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link emfer.reachability.impl.TrafoApplicationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link emfer.reachability.impl.TrafoApplicationImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link emfer.reachability.impl.TrafoApplicationImpl#getSrc <em>Src</em>}</li>
 *   <li>{@link emfer.reachability.impl.TrafoApplicationImpl#getTgt <em>Tgt</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TrafoApplicationImpl extends MinimalEObjectImpl.Container implements TrafoApplication
{
   /**
    * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getDescription()
    * @generated
    * @ordered
    */
   protected static final String DESCRIPTION_EDEFAULT = null;

   /**
    * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getDescription()
    * @generated
    * @ordered
    */
   protected String description = DESCRIPTION_EDEFAULT;

   /**
    * The cached value of the '{@link #getSrc() <em>Src</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getSrc()
    * @generated
    * @ordered
    */
   protected ReachableState src;

   /**
    * The cached value of the '{@link #getTgt() <em>Tgt</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getTgt()
    * @generated
    * @ordered
    */
   protected ReachableState tgt;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected TrafoApplicationImpl()
   {
      super();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   protected EClass eStaticClass()
   {
      return ReachabilityPackage.Literals.TRAFO_APPLICATION;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public String getDescription()
   {
      return description;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setDescription(String newDescription)
   {
      String oldDescription = description;
      description = newDescription;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, ReachabilityPackage.TRAFO_APPLICATION__DESCRIPTION, oldDescription, description));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public ReachabilityGraph getParent()
   {
      if (eContainerFeatureID() != ReachabilityPackage.TRAFO_APPLICATION__PARENT) return null;
      return (ReachabilityGraph)eContainer();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public ReachabilityGraph basicGetParent()
   {
      if (eContainerFeatureID() != ReachabilityPackage.TRAFO_APPLICATION__PARENT) return null;
      return (ReachabilityGraph)eInternalContainer();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain basicSetParent(ReachabilityGraph newParent, NotificationChain msgs)
   {
      msgs = eBasicSetContainer((InternalEObject)newParent, ReachabilityPackage.TRAFO_APPLICATION__PARENT, msgs);
      return msgs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setParent(ReachabilityGraph newParent)
   {
      if (newParent != eInternalContainer() || (eContainerFeatureID() != ReachabilityPackage.TRAFO_APPLICATION__PARENT && newParent != null))
      {
         if (EcoreUtil.isAncestor(this, newParent))
            throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
         NotificationChain msgs = null;
         if (eInternalContainer() != null)
            msgs = eBasicRemoveFromContainer(msgs);
         if (newParent != null)
            msgs = ((InternalEObject)newParent).eInverseAdd(this, ReachabilityPackage.REACHABILITY_GRAPH__TRAFO_APPLICATIONS, ReachabilityGraph.class, msgs);
         msgs = basicSetParent(newParent, msgs);
         if (msgs != null) msgs.dispatch();
      }
      else if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, ReachabilityPackage.TRAFO_APPLICATION__PARENT, newParent, newParent));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public ReachableState getSrc()
   {
      if (src != null && src.eIsProxy())
      {
         InternalEObject oldSrc = (InternalEObject)src;
         src = (ReachableState)eResolveProxy(oldSrc);
         if (src != oldSrc)
         {
            if (eNotificationRequired())
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReachabilityPackage.TRAFO_APPLICATION__SRC, oldSrc, src));
         }
      }
      return src;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public ReachableState basicGetSrc()
   {
      return src;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain basicSetSrc(ReachableState newSrc, NotificationChain msgs)
   {
      ReachableState oldSrc = src;
      src = newSrc;
      if (eNotificationRequired())
      {
         ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReachabilityPackage.TRAFO_APPLICATION__SRC, oldSrc, newSrc);
         if (msgs == null) msgs = notification; else msgs.add(notification);
      }
      return msgs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setSrc(ReachableState newSrc)
   {
      if (newSrc != src)
      {
         NotificationChain msgs = null;
         if (src != null)
            msgs = ((InternalEObject)src).eInverseRemove(this, ReachabilityPackage.REACHABLE_STATE__TRAFO_APPLICATIONS, ReachableState.class, msgs);
         if (newSrc != null)
            msgs = ((InternalEObject)newSrc).eInverseAdd(this, ReachabilityPackage.REACHABLE_STATE__TRAFO_APPLICATIONS, ReachableState.class, msgs);
         msgs = basicSetSrc(newSrc, msgs);
         if (msgs != null) msgs.dispatch();
      }
      else if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, ReachabilityPackage.TRAFO_APPLICATION__SRC, newSrc, newSrc));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public ReachableState getTgt()
   {
      if (tgt != null && tgt.eIsProxy())
      {
         InternalEObject oldTgt = (InternalEObject)tgt;
         tgt = (ReachableState)eResolveProxy(oldTgt);
         if (tgt != oldTgt)
         {
            if (eNotificationRequired())
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReachabilityPackage.TRAFO_APPLICATION__TGT, oldTgt, tgt));
         }
      }
      return tgt;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public ReachableState basicGetTgt()
   {
      return tgt;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain basicSetTgt(ReachableState newTgt, NotificationChain msgs)
   {
      ReachableState oldTgt = tgt;
      tgt = newTgt;
      if (eNotificationRequired())
      {
         ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReachabilityPackage.TRAFO_APPLICATION__TGT, oldTgt, newTgt);
         if (msgs == null) msgs = notification; else msgs.add(notification);
      }
      return msgs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setTgt(ReachableState newTgt)
   {
      if (newTgt != tgt)
      {
         NotificationChain msgs = null;
         if (tgt != null)
            msgs = ((InternalEObject)tgt).eInverseRemove(this, ReachabilityPackage.REACHABLE_STATE__RESULT_OF, ReachableState.class, msgs);
         if (newTgt != null)
            msgs = ((InternalEObject)newTgt).eInverseAdd(this, ReachabilityPackage.REACHABLE_STATE__RESULT_OF, ReachableState.class, msgs);
         msgs = basicSetTgt(newTgt, msgs);
         if (msgs != null) msgs.dispatch();
      }
      else if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, ReachabilityPackage.TRAFO_APPLICATION__TGT, newTgt, newTgt));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
   {
      switch (featureID)
      {
         case ReachabilityPackage.TRAFO_APPLICATION__PARENT:
            if (eInternalContainer() != null)
               msgs = eBasicRemoveFromContainer(msgs);
            return basicSetParent((ReachabilityGraph)otherEnd, msgs);
         case ReachabilityPackage.TRAFO_APPLICATION__SRC:
            if (src != null)
               msgs = ((InternalEObject)src).eInverseRemove(this, ReachabilityPackage.REACHABLE_STATE__TRAFO_APPLICATIONS, ReachableState.class, msgs);
            return basicSetSrc((ReachableState)otherEnd, msgs);
         case ReachabilityPackage.TRAFO_APPLICATION__TGT:
            if (tgt != null)
               msgs = ((InternalEObject)tgt).eInverseRemove(this, ReachabilityPackage.REACHABLE_STATE__RESULT_OF, ReachableState.class, msgs);
            return basicSetTgt((ReachableState)otherEnd, msgs);
      }
      return super.eInverseAdd(otherEnd, featureID, msgs);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
   {
      switch (featureID)
      {
         case ReachabilityPackage.TRAFO_APPLICATION__PARENT:
            return basicSetParent(null, msgs);
         case ReachabilityPackage.TRAFO_APPLICATION__SRC:
            return basicSetSrc(null, msgs);
         case ReachabilityPackage.TRAFO_APPLICATION__TGT:
            return basicSetTgt(null, msgs);
      }
      return super.eInverseRemove(otherEnd, featureID, msgs);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
   {
      switch (eContainerFeatureID())
      {
         case ReachabilityPackage.TRAFO_APPLICATION__PARENT:
            return eInternalContainer().eInverseRemove(this, ReachabilityPackage.REACHABILITY_GRAPH__TRAFO_APPLICATIONS, ReachabilityGraph.class, msgs);
      }
      return super.eBasicRemoveFromContainerFeature(msgs);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Object eGet(int featureID, boolean resolve, boolean coreType)
   {
      switch (featureID)
      {
         case ReachabilityPackage.TRAFO_APPLICATION__DESCRIPTION:
            return getDescription();
         case ReachabilityPackage.TRAFO_APPLICATION__PARENT:
            if (resolve) return getParent();
            return basicGetParent();
         case ReachabilityPackage.TRAFO_APPLICATION__SRC:
            if (resolve) return getSrc();
            return basicGetSrc();
         case ReachabilityPackage.TRAFO_APPLICATION__TGT:
            if (resolve) return getTgt();
            return basicGetTgt();
      }
      return super.eGet(featureID, resolve, coreType);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public void eSet(int featureID, Object newValue)
   {
      switch (featureID)
      {
         case ReachabilityPackage.TRAFO_APPLICATION__DESCRIPTION:
            setDescription((String)newValue);
            return;
         case ReachabilityPackage.TRAFO_APPLICATION__PARENT:
            setParent((ReachabilityGraph)newValue);
            return;
         case ReachabilityPackage.TRAFO_APPLICATION__SRC:
            setSrc((ReachableState)newValue);
            return;
         case ReachabilityPackage.TRAFO_APPLICATION__TGT:
            setTgt((ReachableState)newValue);
            return;
      }
      super.eSet(featureID, newValue);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public void eUnset(int featureID)
   {
      switch (featureID)
      {
         case ReachabilityPackage.TRAFO_APPLICATION__DESCRIPTION:
            setDescription(DESCRIPTION_EDEFAULT);
            return;
         case ReachabilityPackage.TRAFO_APPLICATION__PARENT:
            setParent((ReachabilityGraph)null);
            return;
         case ReachabilityPackage.TRAFO_APPLICATION__SRC:
            setSrc((ReachableState)null);
            return;
         case ReachabilityPackage.TRAFO_APPLICATION__TGT:
            setTgt((ReachableState)null);
            return;
      }
      super.eUnset(featureID);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public boolean eIsSet(int featureID)
   {
      switch (featureID)
      {
         case ReachabilityPackage.TRAFO_APPLICATION__DESCRIPTION:
            return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
         case ReachabilityPackage.TRAFO_APPLICATION__PARENT:
            return basicGetParent() != null;
         case ReachabilityPackage.TRAFO_APPLICATION__SRC:
            return src != null;
         case ReachabilityPackage.TRAFO_APPLICATION__TGT:
            return tgt != null;
      }
      return super.eIsSet(featureID);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public String toString()
   {
      if (eIsProxy()) return super.toString();

      StringBuffer result = new StringBuffer(super.toString());
      result.append(" (description: ");
      result.append(description);
      result.append(')');
      return result.toString();
   }

} //TrafoApplicationImpl
