/**
 */
package emfer.examples.roadwork.impl;

import emfer.examples.roadwork.RoadworkPackage;
import emfer.examples.roadwork.Track;
import emfer.examples.roadwork.TravelDirection;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Track</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link emfer.examples.roadwork.impl.TrackImpl#getName <em>Name</em>}</li>
 *   <li>{@link emfer.examples.roadwork.impl.TrackImpl#getTravelDirection <em>Travel Direction</em>}</li>
 *   <li>{@link emfer.examples.roadwork.impl.TrackImpl#getWest <em>West</em>}</li>
 *   <li>{@link emfer.examples.roadwork.impl.TrackImpl#getEast <em>East</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TrackImpl extends MinimalEObjectImpl.Container implements Track
{
   /**
    * The default value of the '{@link #getName() <em>Name</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getName()
    * @generated
    * @ordered
    */
   protected static final String NAME_EDEFAULT = null;

   /**
    * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getName()
    * @generated
    * @ordered
    */
   protected String name = NAME_EDEFAULT;

   /**
    * The default value of the '{@link #getTravelDirection() <em>Travel Direction</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getTravelDirection()
    * @generated
    * @ordered
    */
   protected static final TravelDirection TRAVEL_DIRECTION_EDEFAULT = TravelDirection.UNDEFINED;

   /**
    * The cached value of the '{@link #getTravelDirection() <em>Travel Direction</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getTravelDirection()
    * @generated
    * @ordered
    */
   protected TravelDirection travelDirection = TRAVEL_DIRECTION_EDEFAULT;

   /**
    * The cached value of the '{@link #getWest() <em>West</em>}' reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getWest()
    * @generated
    * @ordered
    */
   protected EList<Track> west;

   /**
    * The cached value of the '{@link #getEast() <em>East</em>}' reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getEast()
    * @generated
    * @ordered
    */
   protected EList<Track> east;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected TrackImpl()
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
      return RoadworkPackage.Literals.TRACK;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public String getName()
   {
      return name;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setName(String newName)
   {
      String oldName = name;
      name = newName;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, RoadworkPackage.TRACK__NAME, oldName, name));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public TravelDirection getTravelDirection()
   {
      return travelDirection;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setTravelDirection(TravelDirection newTravelDirection)
   {
      TravelDirection oldTravelDirection = travelDirection;
      travelDirection = newTravelDirection == null ? TRAVEL_DIRECTION_EDEFAULT : newTravelDirection;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, RoadworkPackage.TRACK__TRAVEL_DIRECTION, oldTravelDirection, travelDirection));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EList<Track> getWest()
   {
      if (west == null)
      {
         west = new EObjectWithInverseResolvingEList.ManyInverse<Track>(Track.class, this, RoadworkPackage.TRACK__WEST, RoadworkPackage.TRACK__EAST);
      }
      return west;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EList<Track> getEast()
   {
      if (east == null)
      {
         east = new EObjectWithInverseResolvingEList.ManyInverse<Track>(Track.class, this, RoadworkPackage.TRACK__EAST, RoadworkPackage.TRACK__WEST);
      }
      return east;
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
         case RoadworkPackage.TRACK__WEST:
            return ((InternalEList<InternalEObject>)(InternalEList<?>)getWest()).basicAdd(otherEnd, msgs);
         case RoadworkPackage.TRACK__EAST:
            return ((InternalEList<InternalEObject>)(InternalEList<?>)getEast()).basicAdd(otherEnd, msgs);
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
         case RoadworkPackage.TRACK__WEST:
            return ((InternalEList<?>)getWest()).basicRemove(otherEnd, msgs);
         case RoadworkPackage.TRACK__EAST:
            return ((InternalEList<?>)getEast()).basicRemove(otherEnd, msgs);
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
         case RoadworkPackage.TRACK__NAME:
            return getName();
         case RoadworkPackage.TRACK__TRAVEL_DIRECTION:
            return getTravelDirection();
         case RoadworkPackage.TRACK__WEST:
            return getWest();
         case RoadworkPackage.TRACK__EAST:
            return getEast();
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
         case RoadworkPackage.TRACK__NAME:
            setName((String)newValue);
            return;
         case RoadworkPackage.TRACK__TRAVEL_DIRECTION:
            setTravelDirection((TravelDirection)newValue);
            return;
         case RoadworkPackage.TRACK__WEST:
            getWest().clear();
            getWest().addAll((Collection<? extends Track>)newValue);
            return;
         case RoadworkPackage.TRACK__EAST:
            getEast().clear();
            getEast().addAll((Collection<? extends Track>)newValue);
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
         case RoadworkPackage.TRACK__NAME:
            setName(NAME_EDEFAULT);
            return;
         case RoadworkPackage.TRACK__TRAVEL_DIRECTION:
            setTravelDirection(TRAVEL_DIRECTION_EDEFAULT);
            return;
         case RoadworkPackage.TRACK__WEST:
            getWest().clear();
            return;
         case RoadworkPackage.TRACK__EAST:
            getEast().clear();
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
         case RoadworkPackage.TRACK__NAME:
            return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
         case RoadworkPackage.TRACK__TRAVEL_DIRECTION:
            return travelDirection != TRAVEL_DIRECTION_EDEFAULT;
         case RoadworkPackage.TRACK__WEST:
            return west != null && !west.isEmpty();
         case RoadworkPackage.TRACK__EAST:
            return east != null && !east.isEmpty();
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
      result.append(" (name: ");
      result.append(name);
      result.append(", travelDirection: ");
      result.append(travelDirection);
      result.append(')');
      return result.toString();
   }

} //TrackImpl
