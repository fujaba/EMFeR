/**
 */
package emfer.examples.roadwork.impl;

import com.google.common.base.Objects;

import emfer.examples.roadwork.Car;
import emfer.examples.roadwork.Road;
import emfer.examples.roadwork.RoadMap;
import emfer.examples.roadwork.RoadworkPackage;
import emfer.examples.roadwork.Signal;
import emfer.examples.roadwork.TravelDirection;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

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
    * The cached value of the '{@link #getRoad() <em>Road</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getRoad()
    * @generated
    * @ordered
    */
   protected Road road;

   /**
    * The cached value of the '{@link #getCars() <em>Cars</em>}' reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getCars()
    * @generated
    * @ordered
    */
   protected EList<Car> cars;

   /**
    * The cached value of the '{@link #getWesternSignal() <em>Western Signal</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getWesternSignal()
    * @generated
    * @ordered
    */
   protected Signal westernSignal;

   /**
    * The cached value of the '{@link #getEasternSignal() <em>Eastern Signal</em>}' reference.
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
      if (road != null && road.eIsProxy())
      {
         InternalEObject oldRoad = (InternalEObject)road;
         road = (Road)eResolveProxy(oldRoad);
         if (road != oldRoad)
         {
            if (eNotificationRequired())
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, RoadworkPackage.ROAD_MAP__ROAD, oldRoad, road));
         }
      }
      return road;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Road basicGetRoad()
   {
      return road;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setRoad(Road newRoad)
   {
      Road oldRoad = road;
      road = newRoad;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, RoadworkPackage.ROAD_MAP__ROAD, oldRoad, road));
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
         cars = new EObjectResolvingEList<Car>(Car.class, this, RoadworkPackage.ROAD_MAP__CARS);
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
      if (westernSignal != null && westernSignal.eIsProxy())
      {
         InternalEObject oldWesternSignal = (InternalEObject)westernSignal;
         westernSignal = (Signal)eResolveProxy(oldWesternSignal);
         if (westernSignal != oldWesternSignal)
         {
            if (eNotificationRequired())
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, RoadworkPackage.ROAD_MAP__WESTERN_SIGNAL, oldWesternSignal, westernSignal));
         }
      }
      return westernSignal;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Signal basicGetWesternSignal()
   {
      return westernSignal;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setWesternSignal(Signal newWesternSignal)
   {
      Signal oldWesternSignal = westernSignal;
      westernSignal = newWesternSignal;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, RoadworkPackage.ROAD_MAP__WESTERN_SIGNAL, oldWesternSignal, westernSignal));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Signal getEasternSignal()
   {
      if (easternSignal != null && easternSignal.eIsProxy())
      {
         InternalEObject oldEasternSignal = (InternalEObject)easternSignal;
         easternSignal = (Signal)eResolveProxy(oldEasternSignal);
         if (easternSignal != oldEasternSignal)
         {
            if (eNotificationRequired())
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, RoadworkPackage.ROAD_MAP__EASTERN_SIGNAL, oldEasternSignal, easternSignal));
         }
      }
      return easternSignal;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Signal basicGetEasternSignal()
   {
      return easternSignal;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setEasternSignal(Signal newEasternSignal)
   {
      Signal oldEasternSignal = easternSignal;
      easternSignal = newEasternSignal;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, RoadworkPackage.ROAD_MAP__EASTERN_SIGNAL, oldEasternSignal, easternSignal));
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
            char carChar = 'E';
            TravelDirection _travelDirection = c.getTravelDirection();
            boolean _equals = Objects.equal(_travelDirection, TravelDirection.WEST);
            if (_equals)
            {
               carChar = 'W';
            }
            String trackName = c.getTrack().getName();
            char _charAt = trackName.charAt(1);
            int index = (_charAt - '1');
            boolean _startsWith = trackName.startsWith("n");
            if (_startsWith)
            {
               bufNorthCars.setCharAt((6 - index), carChar);
            }
            else
            {
               bufSouthCars.setCharAt(index, carChar);
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
   public Object eGet(int featureID, boolean resolve, boolean coreType)
   {
      switch (featureID)
      {
         case RoadworkPackage.ROAD_MAP__ROAD:
            if (resolve) return getRoad();
            return basicGetRoad();
         case RoadworkPackage.ROAD_MAP__CARS:
            return getCars();
         case RoadworkPackage.ROAD_MAP__WESTERN_SIGNAL:
            if (resolve) return getWesternSignal();
            return basicGetWesternSignal();
         case RoadworkPackage.ROAD_MAP__EASTERN_SIGNAL:
            if (resolve) return getEasternSignal();
            return basicGetEasternSignal();
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
