/**
 */
package emfer.examples.roadwork.impl;

import emfer.examples.roadwork.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RoadworkFactoryImpl extends EFactoryImpl implements RoadworkFactory
{
   /**
    * Creates the default factory implementation.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static RoadworkFactory init()
   {
      try
      {
         RoadworkFactory theRoadworkFactory = (RoadworkFactory)EPackage.Registry.INSTANCE.getEFactory(RoadworkPackage.eNS_URI);
         if (theRoadworkFactory != null)
         {
            return theRoadworkFactory;
         }
      }
      catch (Exception exception)
      {
         EcorePlugin.INSTANCE.log(exception);
      }
      return new RoadworkFactoryImpl();
   }

   /**
    * Creates an instance of the factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public RoadworkFactoryImpl()
   {
      super();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public EObject create(EClass eClass)
   {
      switch (eClass.getClassifierID())
      {
         case RoadworkPackage.ROAD_MAP: return createRoadMap();
         case RoadworkPackage.ROAD: return createRoad();
         case RoadworkPackage.TRACK: return createTrack();
         case RoadworkPackage.SIGNAL: return createSignal();
         case RoadworkPackage.CAR: return createCar();
         default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
      }
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Object createFromString(EDataType eDataType, String initialValue)
   {
      switch (eDataType.getClassifierID())
      {
         case RoadworkPackage.TRAVEL_DIRECTION:
            return createTravelDirectionFromString(eDataType, initialValue);
         default:
            throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
      }
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public String convertToString(EDataType eDataType, Object instanceValue)
   {
      switch (eDataType.getClassifierID())
      {
         case RoadworkPackage.TRAVEL_DIRECTION:
            return convertTravelDirectionToString(eDataType, instanceValue);
         default:
            throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
      }
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public RoadMap createRoadMap()
   {
      RoadMapImpl roadMap = new RoadMapImpl();
      return roadMap;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Road createRoad()
   {
      RoadImpl road = new RoadImpl();
      return road;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Track createTrack()
   {
      TrackImpl track = new TrackImpl();
      return track;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Signal createSignal()
   {
      SignalImpl signal = new SignalImpl();
      return signal;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Car createCar()
   {
      CarImpl car = new CarImpl();
      return car;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public TravelDirection createTravelDirectionFromString(EDataType eDataType, String initialValue)
   {
      TravelDirection result = TravelDirection.get(initialValue);
      if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public String convertTravelDirectionToString(EDataType eDataType, Object instanceValue)
   {
      return instanceValue == null ? null : instanceValue.toString();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public RoadworkPackage getRoadworkPackage()
   {
      return (RoadworkPackage)getEPackage();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @deprecated
    * @generated
    */
   @Deprecated
   public static RoadworkPackage getPackage()
   {
      return RoadworkPackage.eINSTANCE;
   }

} //RoadworkFactoryImpl
