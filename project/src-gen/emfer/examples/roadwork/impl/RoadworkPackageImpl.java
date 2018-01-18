/**
 */
package emfer.examples.roadwork.impl;

import emfer.examples.roadwork.Car;
import emfer.examples.roadwork.Road;
import emfer.examples.roadwork.RoadMap;
import emfer.examples.roadwork.RoadworkFactory;
import emfer.examples.roadwork.RoadworkPackage;
import emfer.examples.roadwork.Signal;
import emfer.examples.roadwork.Track;
import emfer.examples.roadwork.TravelDirection;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RoadworkPackageImpl extends EPackageImpl implements RoadworkPackage
{
   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass roadMapEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass roadEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass trackEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass signalEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass carEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EEnum travelDirectionEEnum = null;

   /**
    * Creates an instance of the model <b>Package</b>, registered with
    * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
    * package URI value.
    * <p>Note: the correct way to create the package is via the static
    * factory method {@link #init init()}, which also performs
    * initialization of the package, or returns the registered package,
    * if one already exists.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.eclipse.emf.ecore.EPackage.Registry
    * @see emfer.examples.roadwork.RoadworkPackage#eNS_URI
    * @see #init()
    * @generated
    */
   private RoadworkPackageImpl()
   {
      super(eNS_URI, RoadworkFactory.eINSTANCE);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private static boolean isInited = false;

   /**
    * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
    * 
    * <p>This method is used to initialize {@link RoadworkPackage#eINSTANCE} when that field is accessed.
    * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #eNS_URI
    * @see #createPackageContents()
    * @see #initializePackageContents()
    * @generated
    */
   public static RoadworkPackage init()
   {
      if (isInited) return (RoadworkPackage)EPackage.Registry.INSTANCE.getEPackage(RoadworkPackage.eNS_URI);

      // Obtain or create and register package
      RoadworkPackageImpl theRoadworkPackage = (RoadworkPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RoadworkPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RoadworkPackageImpl());

      isInited = true;

      // Initialize simple dependencies
      EcorePackage.eINSTANCE.eClass();

      // Create package meta-data objects
      theRoadworkPackage.createPackageContents();

      // Initialize created meta-data
      theRoadworkPackage.initializePackageContents();

      // Mark meta-data to indicate it can't be changed
      theRoadworkPackage.freeze();

  
      // Update the registry and return the package
      EPackage.Registry.INSTANCE.put(RoadworkPackage.eNS_URI, theRoadworkPackage);
      return theRoadworkPackage;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getRoadMap()
   {
      return roadMapEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getRoadMap_Road()
   {
      return (EReference)roadMapEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getRoadMap_Cars()
   {
      return (EReference)roadMapEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getRoadMap_WesternSignal()
   {
      return (EReference)roadMapEClass.getEStructuralFeatures().get(2);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getRoadMap_EasternSignal()
   {
      return (EReference)roadMapEClass.getEStructuralFeatures().get(3);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EOperation getRoadMap__ToString()
   {
      return roadMapEClass.getEOperations().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getRoad()
   {
      return roadEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getRoad_Tracks()
   {
      return (EReference)roadEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getTrack()
   {
      return trackEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getTrack_Name()
   {
      return (EAttribute)trackEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getTrack_TravelDirection()
   {
      return (EAttribute)trackEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getTrack_West()
   {
      return (EReference)trackEClass.getEStructuralFeatures().get(2);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getTrack_East()
   {
      return (EReference)trackEClass.getEStructuralFeatures().get(3);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getTrack_Signal()
   {
      return (EReference)trackEClass.getEStructuralFeatures().get(4);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getTrack_Car()
   {
      return (EReference)trackEClass.getEStructuralFeatures().get(5);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EOperation getTrack__ToString()
   {
      return trackEClass.getEOperations().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getSignal()
   {
      return signalEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getSignal_Pass()
   {
      return (EAttribute)signalEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getSignal_Track()
   {
      return (EReference)signalEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getCar()
   {
      return carEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getCar_TravelDirection()
   {
      return (EAttribute)carEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getCar_Track()
   {
      return (EReference)carEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EOperation getCar__ToString()
   {
      return carEClass.getEOperations().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EEnum getTravelDirection()
   {
      return travelDirectionEEnum;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public RoadworkFactory getRoadworkFactory()
   {
      return (RoadworkFactory)getEFactoryInstance();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private boolean isCreated = false;

   /**
    * Creates the meta-model objects for the package.  This method is
    * guarded to have no affect on any invocation but its first.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void createPackageContents()
   {
      if (isCreated) return;
      isCreated = true;

      // Create classes and their features
      roadMapEClass = createEClass(ROAD_MAP);
      createEReference(roadMapEClass, ROAD_MAP__ROAD);
      createEReference(roadMapEClass, ROAD_MAP__CARS);
      createEReference(roadMapEClass, ROAD_MAP__WESTERN_SIGNAL);
      createEReference(roadMapEClass, ROAD_MAP__EASTERN_SIGNAL);
      createEOperation(roadMapEClass, ROAD_MAP___TO_STRING);

      roadEClass = createEClass(ROAD);
      createEReference(roadEClass, ROAD__TRACKS);

      trackEClass = createEClass(TRACK);
      createEAttribute(trackEClass, TRACK__NAME);
      createEAttribute(trackEClass, TRACK__TRAVEL_DIRECTION);
      createEReference(trackEClass, TRACK__WEST);
      createEReference(trackEClass, TRACK__EAST);
      createEReference(trackEClass, TRACK__SIGNAL);
      createEReference(trackEClass, TRACK__CAR);
      createEOperation(trackEClass, TRACK___TO_STRING);

      signalEClass = createEClass(SIGNAL);
      createEAttribute(signalEClass, SIGNAL__PASS);
      createEReference(signalEClass, SIGNAL__TRACK);

      carEClass = createEClass(CAR);
      createEAttribute(carEClass, CAR__TRAVEL_DIRECTION);
      createEReference(carEClass, CAR__TRACK);
      createEOperation(carEClass, CAR___TO_STRING);

      // Create enums
      travelDirectionEEnum = createEEnum(TRAVEL_DIRECTION);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private boolean isInitialized = false;

   /**
    * Complete the initialization of the package and its meta-model.  This
    * method is guarded to have no affect on any invocation but its first.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void initializePackageContents()
   {
      if (isInitialized) return;
      isInitialized = true;

      // Initialize package
      setName(eNAME);
      setNsPrefix(eNS_PREFIX);
      setNsURI(eNS_URI);

      // Obtain other dependent packages
      EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

      // Create type parameters

      // Set bounds for type parameters

      // Add supertypes to classes

      // Initialize classes, features, and operations; add parameters
      initEClass(roadMapEClass, RoadMap.class, "RoadMap", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getRoadMap_Road(), this.getRoad(), null, "road", null, 0, 1, RoadMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getRoadMap_Cars(), this.getCar(), null, "cars", null, 0, -1, RoadMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getRoadMap_WesternSignal(), this.getSignal(), null, "westernSignal", null, 0, 1, RoadMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getRoadMap_EasternSignal(), this.getSignal(), null, "easternSignal", null, 0, 1, RoadMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEOperation(getRoadMap__ToString(), theEcorePackage.getEString(), "toString", 0, 1, !IS_UNIQUE, IS_ORDERED);

      initEClass(roadEClass, Road.class, "Road", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getRoad_Tracks(), this.getTrack(), null, "tracks", null, 0, -1, Road.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(trackEClass, Track.class, "Track", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEAttribute(getTrack_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Track.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getTrack_TravelDirection(), this.getTravelDirection(), "travelDirection", null, 0, 1, Track.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getTrack_West(), this.getTrack(), this.getTrack_East(), "west", null, 0, -1, Track.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getTrack_East(), this.getTrack(), this.getTrack_West(), "east", null, 0, -1, Track.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getTrack_Signal(), this.getSignal(), this.getSignal_Track(), "signal", null, 0, 1, Track.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getTrack_Car(), this.getCar(), this.getCar_Track(), "car", null, 0, 1, Track.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEOperation(getTrack__ToString(), theEcorePackage.getEString(), "toString", 0, 1, !IS_UNIQUE, IS_ORDERED);

      initEClass(signalEClass, Signal.class, "Signal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEAttribute(getSignal_Pass(), theEcorePackage.getEBoolean(), "pass", null, 0, 1, Signal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getSignal_Track(), this.getTrack(), this.getTrack_Signal(), "track", null, 0, 1, Signal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(carEClass, Car.class, "Car", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEAttribute(getCar_TravelDirection(), this.getTravelDirection(), "travelDirection", null, 0, 1, Car.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getCar_Track(), this.getTrack(), this.getTrack_Car(), "track", null, 0, 1, Car.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEOperation(getCar__ToString(), theEcorePackage.getEString(), "toString", 0, 1, !IS_UNIQUE, IS_ORDERED);

      // Initialize enums and add enum literals
      initEEnum(travelDirectionEEnum, TravelDirection.class, "TravelDirection");
      addEEnumLiteral(travelDirectionEEnum, TravelDirection.UNDEFINED);
      addEEnumLiteral(travelDirectionEEnum, TravelDirection.EAST);
      addEEnumLiteral(travelDirectionEEnum, TravelDirection.WEST);

      // Create resource
      createResource(eNS_URI);
   }

} //RoadworkPackageImpl
