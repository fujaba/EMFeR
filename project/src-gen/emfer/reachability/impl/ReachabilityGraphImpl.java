/**
 */
package emfer.reachability.impl;

import emfer.reachability.ReachabilityGraph;
import emfer.reachability.ReachabilityPackage;
import emfer.reachability.ReachableState;
import emfer.reachability.TrafoApplication;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link emfer.reachability.impl.ReachabilityGraphImpl#getStates <em>States</em>}</li>
 *   <li>{@link emfer.reachability.impl.ReachabilityGraphImpl#getTrafoApplications <em>Trafo Applications</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReachabilityGraphImpl extends MinimalEObjectImpl.Container implements ReachabilityGraph
{
   /**
    * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getStates()
    * @generated
    * @ordered
    */
   protected EList<ReachableState> states;

   /**
    * The cached value of the '{@link #getTrafoApplications() <em>Trafo Applications</em>}' containment reference list.
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
   protected ReachabilityGraphImpl()
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
      return ReachabilityPackage.Literals.REACHABILITY_GRAPH;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EList<ReachableState> getStates()
   {
      if (states == null)
      {
         states = new EObjectContainmentWithInverseEList<ReachableState>(ReachableState.class, this, ReachabilityPackage.REACHABILITY_GRAPH__STATES, ReachabilityPackage.REACHABLE_STATE__PARENT);
      }
      return states;
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
         trafoApplications = new EObjectContainmentWithInverseEList<TrafoApplication>(TrafoApplication.class, this, ReachabilityPackage.REACHABILITY_GRAPH__TRAFO_APPLICATIONS, ReachabilityPackage.TRAFO_APPLICATION__PARENT);
      }
      return trafoApplications;
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
         case ReachabilityPackage.REACHABILITY_GRAPH__STATES:
            return ((InternalEList<InternalEObject>)(InternalEList<?>)getStates()).basicAdd(otherEnd, msgs);
         case ReachabilityPackage.REACHABILITY_GRAPH__TRAFO_APPLICATIONS:
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
         case ReachabilityPackage.REACHABILITY_GRAPH__STATES:
            return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
         case ReachabilityPackage.REACHABILITY_GRAPH__TRAFO_APPLICATIONS:
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
   public Object eGet(int featureID, boolean resolve, boolean coreType)
   {
      switch (featureID)
      {
         case ReachabilityPackage.REACHABILITY_GRAPH__STATES:
            return getStates();
         case ReachabilityPackage.REACHABILITY_GRAPH__TRAFO_APPLICATIONS:
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
         case ReachabilityPackage.REACHABILITY_GRAPH__STATES:
            getStates().clear();
            getStates().addAll((Collection<? extends ReachableState>)newValue);
            return;
         case ReachabilityPackage.REACHABILITY_GRAPH__TRAFO_APPLICATIONS:
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
         case ReachabilityPackage.REACHABILITY_GRAPH__STATES:
            getStates().clear();
            return;
         case ReachabilityPackage.REACHABILITY_GRAPH__TRAFO_APPLICATIONS:
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
         case ReachabilityPackage.REACHABILITY_GRAPH__STATES:
            return states != null && !states.isEmpty();
         case ReachabilityPackage.REACHABILITY_GRAPH__TRAFO_APPLICATIONS:
            return trafoApplications != null && !trafoApplications.isEmpty();
      }
      return super.eIsSet(featureID);
   }

} //ReachabilityGraphImpl
