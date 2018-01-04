/**
 */
package emfer.examples.roadwork.impl;

import emfer.examples.roadwork.Car;
import emfer.examples.roadwork.RoadworkPackage;
import emfer.examples.roadwork.Track;
import emfer.examples.roadwork.TravelDirection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Car</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link emfer.examples.roadwork.impl.CarImpl#getTravelDirection <em>Travel Direction</em>}</li>
 *   <li>{@link emfer.examples.roadwork.impl.CarImpl#getTrack <em>Track</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CarImpl extends MinimalEObjectImpl.Container implements Car
{
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
    * The cached value of the '{@link #getTrack() <em>Track</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getTrack()
    * @generated
    * @ordered
    */
   protected Track track;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected CarImpl()
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
      return RoadworkPackage.Literals.CAR;
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
         eNotify(new ENotificationImpl(this, Notification.SET, RoadworkPackage.CAR__TRAVEL_DIRECTION, oldTravelDirection, travelDirection));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Track getTrack()
   {
      if (track != null && track.eIsProxy())
      {
         InternalEObject oldTrack = (InternalEObject)track;
         track = (Track)eResolveProxy(oldTrack);
         if (track != oldTrack)
         {
            if (eNotificationRequired())
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, RoadworkPackage.CAR__TRACK, oldTrack, track));
         }
      }
      return track;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Track basicGetTrack()
   {
      return track;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setTrack(Track newTrack)
   {
      Track oldTrack = track;
      track = newTrack;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, RoadworkPackage.CAR__TRACK, oldTrack, track));
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
         case RoadworkPackage.CAR__TRAVEL_DIRECTION:
            return getTravelDirection();
         case RoadworkPackage.CAR__TRACK:
            if (resolve) return getTrack();
            return basicGetTrack();
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
         case RoadworkPackage.CAR__TRAVEL_DIRECTION:
            setTravelDirection((TravelDirection)newValue);
            return;
         case RoadworkPackage.CAR__TRACK:
            setTrack((Track)newValue);
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
         case RoadworkPackage.CAR__TRAVEL_DIRECTION:
            setTravelDirection(TRAVEL_DIRECTION_EDEFAULT);
            return;
         case RoadworkPackage.CAR__TRACK:
            setTrack((Track)null);
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
         case RoadworkPackage.CAR__TRAVEL_DIRECTION:
            return travelDirection != TRAVEL_DIRECTION_EDEFAULT;
         case RoadworkPackage.CAR__TRACK:
            return track != null;
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
      result.append(" (travelDirection: ");
      result.append(travelDirection);
      result.append(')');
      return result.toString();
   }

} //CarImpl
