/**
 */
package emfer.reachability.impl;

import com.google.common.base.Objects;

import emfer.reachability.ReachabilityGraph;
import emfer.reachability.ReachabilityPackage;
import emfer.reachability.ReachableState;
import emfer.reachability.TrafoApplication;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reachable State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link emfer.reachability.impl.ReachableStateImpl#getNumber <em>Number</em>}</li>
 *   <li>{@link emfer.reachability.impl.ReachableStateImpl#getMetricValue <em>Metric Value</em>}</li>
 *   <li>{@link emfer.reachability.impl.ReachableStateImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link emfer.reachability.impl.ReachableStateImpl#getRoot <em>Root</em>}</li>
 *   <li>{@link emfer.reachability.impl.ReachableStateImpl#getResultOf <em>Result Of</em>}</li>
 *   <li>{@link emfer.reachability.impl.ReachableStateImpl#getTrafoApplications <em>Trafo Applications</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReachableStateImpl extends MinimalEObjectImpl.Container implements ReachableState
{
   /**
    * The default value of the '{@link #getNumber() <em>Number</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getNumber()
    * @generated
    * @ordered
    */
   protected static final long NUMBER_EDEFAULT = 0L;

   /**
    * The cached value of the '{@link #getNumber() <em>Number</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getNumber()
    * @generated
    * @ordered
    */
   protected long number = NUMBER_EDEFAULT;

   /**
    * The default value of the '{@link #getMetricValue() <em>Metric Value</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getMetricValue()
    * @generated
    * @ordered
    */
   protected static final double METRIC_VALUE_EDEFAULT = 0.0;

   /**
    * The cached value of the '{@link #getMetricValue() <em>Metric Value</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getMetricValue()
    * @generated
    * @ordered
    */
   protected double metricValue = METRIC_VALUE_EDEFAULT;

   /**
    * The cached value of the '{@link #getRoot() <em>Root</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getRoot()
    * @generated
    * @ordered
    */
   protected EObject root;

   /**
    * The cached value of the '{@link #getResultOf() <em>Result Of</em>}' reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getResultOf()
    * @generated
    * @ordered
    */
   protected EList<TrafoApplication> resultOf;

   /**
    * The cached value of the '{@link #getTrafoApplications() <em>Trafo Applications</em>}' reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getTrafoApplications()
    * @generated
    * @ordered
    */
   protected EList<TrafoApplication> trafoApplications;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected ReachableStateImpl()
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
      return ReachabilityPackage.Literals.REACHABLE_STATE;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public long getNumber()
   {
      return number;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setNumber(long newNumber)
   {
      long oldNumber = number;
      number = newNumber;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, ReachabilityPackage.REACHABLE_STATE__NUMBER, oldNumber, number));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public double getMetricValue()
   {
      return metricValue;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setMetricValue(double newMetricValue)
   {
      double oldMetricValue = metricValue;
      metricValue = newMetricValue;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, ReachabilityPackage.REACHABLE_STATE__METRIC_VALUE, oldMetricValue, metricValue));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public ReachabilityGraph getParent()
   {
      if (eContainerFeatureID() != ReachabilityPackage.REACHABLE_STATE__PARENT) return null;
      return (ReachabilityGraph)eContainer();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public ReachabilityGraph basicGetParent()
   {
      if (eContainerFeatureID() != ReachabilityPackage.REACHABLE_STATE__PARENT) return null;
      return (ReachabilityGraph)eInternalContainer();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain basicSetParent(ReachabilityGraph newParent, NotificationChain msgs)
   {
      msgs = eBasicSetContainer((InternalEObject)newParent, ReachabilityPackage.REACHABLE_STATE__PARENT, msgs);
      return msgs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setParent(ReachabilityGraph newParent)
   {
      if (newParent != eInternalContainer() || (eContainerFeatureID() != ReachabilityPackage.REACHABLE_STATE__PARENT && newParent != null))
      {
         if (EcoreUtil.isAncestor(this, newParent))
            throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
         NotificationChain msgs = null;
         if (eInternalContainer() != null)
            msgs = eBasicRemoveFromContainer(msgs);
         if (newParent != null)
            msgs = ((InternalEObject)newParent).eInverseAdd(this, ReachabilityPackage.REACHABILITY_GRAPH__STATES, ReachabilityGraph.class, msgs);
         msgs = basicSetParent(newParent, msgs);
         if (msgs != null) msgs.dispatch();
      }
      else if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, ReachabilityPackage.REACHABLE_STATE__PARENT, newParent, newParent));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EObject getRoot()
   {
      if (root != null && root.eIsProxy())
      {
         InternalEObject oldRoot = (InternalEObject)root;
         root = eResolveProxy(oldRoot);
         if (root != oldRoot)
         {
            if (eNotificationRequired())
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReachabilityPackage.REACHABLE_STATE__ROOT, oldRoot, root));
         }
      }
      return root;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EObject basicGetRoot()
   {
      return root;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setRoot(EObject newRoot)
   {
      EObject oldRoot = root;
      root = newRoot;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, ReachabilityPackage.REACHABLE_STATE__ROOT, oldRoot, root));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EList<TrafoApplication> getResultOf()
   {
      if (resultOf == null)
      {
         resultOf = new EObjectWithInverseResolvingEList<TrafoApplication>(TrafoApplication.class, this, ReachabilityPackage.REACHABLE_STATE__RESULT_OF, ReachabilityPackage.TRAFO_APPLICATION__TGT);
      }
      return resultOf;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EList<TrafoApplication> getTrafoApplications()
   {
      if (trafoApplications == null)
      {
         trafoApplications = new EObjectWithInverseResolvingEList<TrafoApplication>(TrafoApplication.class, this, ReachabilityPackage.REACHABLE_STATE__TRAFO_APPLICATIONS, ReachabilityPackage.TRAFO_APPLICATION__SRC);
      }
      return trafoApplications;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public String toString()
   {
      StringBuilder buf = new StringBuilder();
      buf.append("ReachableState: number: ").append(this.getNumber()).append(" metricValue: ").append(this.getMetricValue()).append("\n");
      EObject _root = this.getRoot();
      boolean _notEquals = (!Objects.equal(_root, null));
      if (_notEquals)
      {
         buf.append(this.getRoot().toString());
      }
      return buf.toString();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @SuppressWarnings("unchecked")
   @Override
   public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
   {
      switch (featureID)
      {
         case ReachabilityPackage.REACHABLE_STATE__PARENT:
            if (eInternalContainer() != null)
               msgs = eBasicRemoveFromContainer(msgs);
            return basicSetParent((ReachabilityGraph)otherEnd, msgs);
         case ReachabilityPackage.REACHABLE_STATE__RESULT_OF:
            return ((InternalEList<InternalEObject>)(InternalEList<?>)getResultOf()).basicAdd(otherEnd, msgs);
         case ReachabilityPackage.REACHABLE_STATE__TRAFO_APPLICATIONS:
            return ((InternalEList<InternalEObject>)(InternalEList<?>)getTrafoApplications()).basicAdd(otherEnd, msgs);
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
         case ReachabilityPackage.REACHABLE_STATE__PARENT:
            return basicSetParent(null, msgs);
         case ReachabilityPackage.REACHABLE_STATE__RESULT_OF:
            return ((InternalEList<?>)getResultOf()).basicRemove(otherEnd, msgs);
         case ReachabilityPackage.REACHABLE_STATE__TRAFO_APPLICATIONS:
            return ((InternalEList<?>)getTrafoApplications()).basicRemove(otherEnd, msgs);
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
         case ReachabilityPackage.REACHABLE_STATE__PARENT:
            return eInternalContainer().eInverseRemove(this, ReachabilityPackage.REACHABILITY_GRAPH__STATES, ReachabilityGraph.class, msgs);
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
         case ReachabilityPackage.REACHABLE_STATE__NUMBER:
            return getNumber();
         case ReachabilityPackage.REACHABLE_STATE__METRIC_VALUE:
            return getMetricValue();
         case ReachabilityPackage.REACHABLE_STATE__PARENT:
            if (resolve) return getParent();
            return basicGetParent();
         case ReachabilityPackage.REACHABLE_STATE__ROOT:
            if (resolve) return getRoot();
            return basicGetRoot();
         case ReachabilityPackage.REACHABLE_STATE__RESULT_OF:
            return getResultOf();
         case ReachabilityPackage.REACHABLE_STATE__TRAFO_APPLICATIONS:
            return getTrafoApplications();
      }
      return super.eGet(featureID, resolve, coreType);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @SuppressWarnings("unchecked")
   @Override
   public void eSet(int featureID, Object newValue)
   {
      switch (featureID)
      {
         case ReachabilityPackage.REACHABLE_STATE__NUMBER:
            setNumber((Long)newValue);
            return;
         case ReachabilityPackage.REACHABLE_STATE__METRIC_VALUE:
            setMetricValue((Double)newValue);
            return;
         case ReachabilityPackage.REACHABLE_STATE__PARENT:
            setParent((ReachabilityGraph)newValue);
            return;
         case ReachabilityPackage.REACHABLE_STATE__ROOT:
            setRoot((EObject)newValue);
            return;
         case ReachabilityPackage.REACHABLE_STATE__RESULT_OF:
            getResultOf().clear();
            getResultOf().addAll((Collection<? extends TrafoApplication>)newValue);
            return;
         case ReachabilityPackage.REACHABLE_STATE__TRAFO_APPLICATIONS:
            getTrafoApplications().clear();
            getTrafoApplications().addAll((Collection<? extends TrafoApplication>)newValue);
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
         case ReachabilityPackage.REACHABLE_STATE__NUMBER:
            setNumber(NUMBER_EDEFAULT);
            return;
         case ReachabilityPackage.REACHABLE_STATE__METRIC_VALUE:
            setMetricValue(METRIC_VALUE_EDEFAULT);
            return;
         case ReachabilityPackage.REACHABLE_STATE__PARENT:
            setParent((ReachabilityGraph)null);
            return;
         case ReachabilityPackage.REACHABLE_STATE__ROOT:
            setRoot((EObject)null);
            return;
         case ReachabilityPackage.REACHABLE_STATE__RESULT_OF:
            getResultOf().clear();
            return;
         case ReachabilityPackage.REACHABLE_STATE__TRAFO_APPLICATIONS:
            getTrafoApplications().clear();
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
         case ReachabilityPackage.REACHABLE_STATE__NUMBER:
            return number != NUMBER_EDEFAULT;
         case ReachabilityPackage.REACHABLE_STATE__METRIC_VALUE:
            return metricValue != METRIC_VALUE_EDEFAULT;
         case ReachabilityPackage.REACHABLE_STATE__PARENT:
            return basicGetParent() != null;
         case ReachabilityPackage.REACHABLE_STATE__ROOT:
            return root != null;
         case ReachabilityPackage.REACHABLE_STATE__RESULT_OF:
            return resultOf != null && !resultOf.isEmpty();
         case ReachabilityPackage.REACHABLE_STATE__TRAFO_APPLICATIONS:
            return trafoApplications != null && !trafoApplications.isEmpty();
      }
      return super.eIsSet(featureID);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
   {
      switch (operationID)
      {
         case ReachabilityPackage.REACHABLE_STATE___TO_STRING:
            return toString();
      }
      return super.eInvoke(operationID, arguments);
   }

} //ReachableStateImpl
