/**
 */
package emfer.examples.roadwork.impl;

import emfer.examples.roadwork.Car;
import emfer.examples.roadwork.RoadworkPackage;
import emfer.examples.roadwork.Signal;
import emfer.examples.roadwork.Track;
import emfer.examples.roadwork.TravelDirection;

import java.lang.reflect.InvocationTargetException;

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
 *   <li>{@link emfer.examples.roadwork.impl.TrackImpl#getSignal <em>Signal</em>}</li>
 *   <li>{@link emfer.examples.roadwork.impl.TrackImpl#getCar <em>Car</em>}</li>
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
    * The cached value of the '{@link #getSignal() <em>Signal</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getSignal()
    * @generated
    * @ordered
    */
   protected Signal signal;

   /**
    * The cached value of the '{@link #getCar() <em>Car</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getCar()
    * @generated
    * @ordered
    */
   protected Car car;

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
   public Signal getSignal()
   {
      if (signal != null && signal.eIsProxy())
      {
         InternalEObject oldSignal = (InternalEObject)signal;
         signal = (Signal)eResolveProxy(oldSignal);
         if (signal != oldSignal)
         {
            if (eNotificationRequired())
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, RoadworkPackage.TRACK__SIGNAL, oldSignal, signal));
         }
      }
      return signal;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Signal basicGetSignal()
   {
      return signal;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain basicSetSignal(Signal newSignal, NotificationChain msgs)
   {
      Signal oldSignal = signal;
      signal = newSignal;
      if (eNotificationRequired())
      {
         ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RoadworkPackage.TRACK__SIGNAL, oldSignal, newSignal);
         if (msgs == null) msgs = notification; else msgs.add(notification);
      }
      return msgs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setSignal(Signal newSignal)
   {
      if (newSignal != signal)
      {
         NotificationChain msgs = null;
         if (signal != null)
            msgs = ((InternalEObject)signal).eInverseRemove(this, RoadworkPackage.SIGNAL__TRACK, Signal.class, msgs);
         if (newSignal != null)
            msgs = ((InternalEObject)newSignal).eInverseAdd(this, RoadworkPackage.SIGNAL__TRACK, Signal.class, msgs);
         msgs = basicSetSignal(newSignal, msgs);
         if (msgs != null) msgs.dispatch();
      }
      else if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, RoadworkPackage.TRACK__SIGNAL, newSignal, newSignal));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Car getCar()
   {
      if (car != null && car.eIsProxy())
      {
         InternalEObject oldCar = (InternalEObject)car;
         car = (Car)eResolveProxy(oldCar);
         if (car != oldCar)
         {
            if (eNotificationRequired())
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, RoadworkPackage.TRACK__CAR, oldCar, car));
         }
      }
      return car;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Car basicGetCar()
   {
      return car;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain basicSetCar(Car newCar, NotificationChain msgs)
   {
      Car oldCar = car;
      car = newCar;
      if (eNotificationRequired())
      {
         ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RoadworkPackage.TRACK__CAR, oldCar, newCar);
         if (msgs == null) msgs = notification; else msgs.add(notification);
      }
      return msgs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setCar(Car newCar)
   {
      if (newCar != car)
      {
         NotificationChain msgs = null;
         if (car != null)
            msgs = ((InternalEObject)car).eInverseRemove(this, RoadworkPackage.CAR__TRACK, Car.class, msgs);
         if (newCar != null)
            msgs = ((InternalEObject)newCar).eInverseAdd(this, RoadworkPackage.CAR__TRACK, Car.class, msgs);
         msgs = basicSetCar(newCar, msgs);
         if (msgs != null) msgs.dispatch();
      }
      else if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, RoadworkPackage.TRACK__CAR, newCar, newCar));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public String toString()
   {
      String _name = this.getName();
      return ("Track: " + _name);
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
         case RoadworkPackage.TRACK__SIGNAL:
            if (signal != null)
               msgs = ((InternalEObject)signal).eInverseRemove(this, RoadworkPackage.SIGNAL__TRACK, Signal.class, msgs);
            return basicSetSignal((Signal)otherEnd, msgs);
         case RoadworkPackage.TRACK__CAR:
            if (car != null)
               msgs = ((InternalEObject)car).eInverseRemove(this, RoadworkPackage.CAR__TRACK, Car.class, msgs);
            return basicSetCar((Car)otherEnd, msgs);
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
         case RoadworkPackage.TRACK__SIGNAL:
            return basicSetSignal(null, msgs);
         case RoadworkPackage.TRACK__CAR:
            return basicSetCar(null, msgs);
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
         case RoadworkPackage.TRACK__SIGNAL:
            if (resolve) return getSignal();
            return basicGetSignal();
         case RoadworkPackage.TRACK__CAR:
            if (resolve) return getCar();
            return basicGetCar();
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
         case RoadworkPackage.TRACK__SIGNAL:
            setSignal((Signal)newValue);
            return;
         case RoadworkPackage.TRACK__CAR:
            setCar((Car)newValue);
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
         case RoadworkPackage.TRACK__SIGNAL:
            setSignal((Signal)null);
            return;
         case RoadworkPackage.TRACK__CAR:
            setCar((Car)null);
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
         case RoadworkPackage.TRACK__SIGNAL:
            return signal != null;
         case RoadworkPackage.TRACK__CAR:
            return car != null;
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
         case RoadworkPackage.TRACK___TO_STRING:
            return toString();
      }
      return super.eInvoke(operationID, arguments);
   }

} //TrackImpl
