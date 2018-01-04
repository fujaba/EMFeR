/**
 */
package emfer.examples.roadwork.impl;

import com.google.common.base.Objects;

import emfer.examples.roadwork.Car;
import emfer.examples.roadwork.Road;
import emfer.examples.roadwork.RoadMap;
import emfer.examples.roadwork.RoadworkPackage;
import emfer.examples.roadwork.Signal;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Road Map</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link emfer.examples.roadwork.impl.RoadMapImpl#getRoad <em>Road</em>}</li>
 *   <li>{@link emfer.examples.roadwork.impl.RoadMapImpl#getCars <em>Cars</em>}</li>
 *   <li>{@link emfer.examples.roadwork.impl.RoadMapImpl#getWesternSignal <em>Western Signal</em>}</li>
 *   <li>{@link emfer.examples.roadwork.impl.RoadMapImpl#getEasternSignal <em>Eastern Signal</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RoadMapImpl extends MinimalEObjectImpl.Container implements RoadMap
{
   /**
    * The cached value of the '{@link #getRoad() <em>Road</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getRoad()
    * @generated
    * @ordered
    */
   protected Road road;

   /**
    * The cached value of the '{@link #getCars() <em>Cars</em>}' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getCars()
    * @generated
    * @ordered
    */
   protected EList<Car> cars;

   /**
    * The cached value of the '{@link #getWesternSignal() <em>Western Signal</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getWesternSignal()
    * @generated
    * @ordered
    */
   protected Signal westernSignal;

   /**
    * The cached value of the '{@link #getEasternSignal() <em>Eastern Signal</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getEasternSignal()
    * @generated
    * @ordered
    */
   protected Signal easternSignal;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected RoadMapImpl()
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
      return RoadworkPackage.Literals.ROAD_MAP;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Road getRoad()
   {
      return road;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain basicSetRoad(Road newRoad, NotificationChain msgs)
   {
      Road oldRoad = road;
      road = newRoad;
      if (eNotificationRequired())
      {
         ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RoadworkPackage.ROAD_MAP__ROAD, oldRoad, newRoad);
         if (msgs == null) msgs = notification; else msgs.add(notification);
      }
      return msgs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setRoad(Road newRoad)
   {
      if (newRoad != road)
      {
         NotificationChain msgs = null;
         if (road != null)
            msgs = ((InternalEObject)road).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RoadworkPackage.ROAD_MAP__ROAD, null, msgs);
         if (newRoad != null)
            msgs = ((InternalEObject)newRoad).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RoadworkPackage.ROAD_MAP__ROAD, null, msgs);
         msgs = basicSetRoad(newRoad, msgs);
         if (msgs != null) msgs.dispatch();
      }
      else if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, RoadworkPackage.ROAD_MAP__ROAD, newRoad, newRoad));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EList<Car> getCars()
   {
      if (cars == null)
      {
         cars = new EObjectContainmentEList<Car>(Car.class, this, RoadworkPackage.ROAD_MAP__CARS);
      }
      return cars;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Signal getWesternSignal()
   {
      return westernSignal;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain basicSetWesternSignal(Signal newWesternSignal, NotificationChain msgs)
   {
      Signal oldWesternSignal = westernSignal;
      westernSignal = newWesternSignal;
      if (eNotificationRequired())
      {
         ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RoadworkPackage.ROAD_MAP__WESTERN_SIGNAL, oldWesternSignal, newWesternSignal);
         if (msgs == null) msgs = notification; else msgs.add(notification);
      }
      return msgs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setWesternSignal(Signal newWesternSignal)
   {
      if (newWesternSignal != westernSignal)
      {
         NotificationChain msgs = null;
         if (westernSignal != null)
            msgs = ((InternalEObject)westernSignal).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RoadworkPackage.ROAD_MAP__WESTERN_SIGNAL, null, msgs);
         if (newWesternSignal != null)
            msgs = ((InternalEObject)newWesternSignal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RoadworkPackage.ROAD_MAP__WESTERN_SIGNAL, null, msgs);
         msgs = basicSetWesternSignal(newWesternSignal, msgs);
         if (msgs != null) msgs.dispatch();
      }
      else if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, RoadworkPackage.ROAD_MAP__WESTERN_SIGNAL, newWesternSignal, newWesternSignal));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Signal getEasternSignal()
   {
      return easternSignal;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain basicSetEasternSignal(Signal newEasternSignal, NotificationChain msgs)
   {
      Signal oldEasternSignal = easternSignal;
      easternSignal = newEasternSignal;
      if (eNotificationRequired())
      {
         ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RoadworkPackage.ROAD_MAP__EASTERN_SIGNAL, oldEasternSignal, newEasternSignal);
         if (msgs == null) msgs = notification; else msgs.add(notification);
      }
      return msgs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setEasternSignal(Signal newEasternSignal)
   {
      if (newEasternSignal != easternSignal)
      {
         NotificationChain msgs = null;
         if (easternSignal != null)
            msgs = ((InternalEObject)easternSignal).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RoadworkPackage.ROAD_MAP__EASTERN_SIGNAL, null, msgs);
         if (newEasternSignal != null)
            msgs = ((InternalEObject)newEasternSignal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RoadworkPackage.ROAD_MAP__EASTERN_SIGNAL, null, msgs);
         msgs = basicSetEasternSignal(newEasternSignal, msgs);
         if (msgs != null) msgs.dispatch();
      }
      else if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, RoadworkPackage.ROAD_MAP__EASTERN_SIGNAL, newEasternSignal, newEasternSignal));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public String toString()
   {
      StringBuilder bufNorthSignal = new StringBuilder("       \n");
      StringBuilder bufNorthCars = new StringBuilder("-------\n");
      StringBuilder bufSouthCars = new StringBuilder("--/ \\--\n");
      StringBuilder bufSouthSignal = new StringBuilder("       \n");
      boolean _isPass = this.getWesternSignal().isPass();
      if (_isPass)
      {
         bufNorthSignal.setCharAt(5, 'T');
      }
      else
      {
         bufNorthSignal.setCharAt(5, 'F');
      }
      boolean _isPass_1 = this.getEasternSignal().isPass();
      if (_isPass_1)
      {
         bufSouthSignal.setCharAt(1, 'T');
      }
      else
      {
         bufSouthSignal.setCharAt(1, 'F');
      }
      EList<Car> _cars = this.getCars();
      for (final Car c : _cars)
      {
         {
            String trackName = c.getTrack().getName();
            char dir = trackName.charAt(0);
            char _charAt = trackName.charAt(1);
            int index = (_charAt - '0');
            boolean _equals = Objects.equal(Character.valueOf(dir), "n");
            if (_equals)
            {
               bufNorthCars.setCharAt(index, 'c');
            }
            else
            {
               bufSouthCars.setCharAt(index, 'c');
            }
         }
      }
      String _string = bufNorthSignal.append(bufNorthCars).append(bufSouthCars).append(bufSouthSignal).toString();
      return ("\n" + _string);
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
         case RoadworkPackage.ROAD_MAP__ROAD:
            return basicSetRoad(null, msgs);
         case RoadworkPackage.ROAD_MAP__CARS:
            return ((InternalEList<?>)getCars()).basicRemove(otherEnd, msgs);
         case RoadworkPackage.ROAD_MAP__WESTERN_SIGNAL:
            return basicSetWesternSignal(null, msgs);
         case RoadworkPackage.ROAD_MAP__EASTERN_SIGNAL:
            return basicSetEasternSignal(null, msgs);
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
         case RoadworkPackage.ROAD_MAP__ROAD:
            return getRoad();
         case RoadworkPackage.ROAD_MAP__CARS:
            return getCars();
         case RoadworkPackage.ROAD_MAP__WESTERN_SIGNAL:
            return getWesternSignal();
         case RoadworkPackage.ROAD_MAP__EASTERN_SIGNAL:
            return getEasternSignal();
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
         case RoadworkPackage.ROAD_MAP__ROAD:
            setRoad((Road)newValue);
            return;
         case RoadworkPackage.ROAD_MAP__CARS:
            getCars().clear();
            getCars().addAll((Collection<? extends Car>)newValue);
            return;
         case RoadworkPackage.ROAD_MAP__WESTERN_SIGNAL:
            setWesternSignal((Signal)newValue);
            return;
         case RoadworkPackage.ROAD_MAP__EASTERN_SIGNAL:
            setEasternSignal((Signal)newValue);
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
         case RoadworkPackage.ROAD_MAP__ROAD:
            setRoad((Road)null);
            return;
         case RoadworkPackage.ROAD_MAP__CARS:
            getCars().clear();
            return;
         case RoadworkPackage.ROAD_MAP__WESTERN_SIGNAL:
            setWesternSignal((Signal)null);
            return;
         case RoadworkPackage.ROAD_MAP__EASTERN_SIGNAL:
            setEasternSignal((Signal)null);
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
         case RoadworkPackage.ROAD_MAP__ROAD:
            return road != null;
         case RoadworkPackage.ROAD_MAP__CARS:
            return cars != null && !cars.isEmpty();
         case RoadworkPackage.ROAD_MAP__WESTERN_SIGNAL:
            return westernSignal != null;
         case RoadworkPackage.ROAD_MAP__EASTERN_SIGNAL:
            return easternSignal != null;
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
         case RoadworkPackage.ROAD_MAP___TO_STRING:
            return toString();
      }
      return super.eInvoke(operationID, arguments);
   }

} //RoadMapImpl
