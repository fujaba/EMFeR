/**
 */
package emfer.examples.roadwork;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see emfer.examples.roadwork.RoadworkFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel basePackage='emfer.examples'"
 * @generated
 */
public interface RoadworkPackage extends EPackage
{
   /**
    * The package name.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String eNAME = "roadwork";

   /**
    * The package namespace URI.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String eNS_URI = "emfer.examples.roadwork";

   /**
    * The package namespace name.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String eNS_PREFIX = "roadwork";

   /**
    * The singleton instance of the package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   RoadworkPackage eINSTANCE = emfer.examples.roadwork.impl.RoadworkPackageImpl.init();

   /**
    * The meta object id for the '{@link emfer.examples.roadwork.impl.RoadMapImpl <em>Road Map</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see emfer.examples.roadwork.impl.RoadMapImpl
    * @see emfer.examples.roadwork.impl.RoadworkPackageImpl#getRoadMap()
    * @generated
    */
   int ROAD_MAP = 0;

   /**
    * The feature id for the '<em><b>Road</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ROAD_MAP__ROAD = 0;

   /**
    * The feature id for the '<em><b>Cars</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ROAD_MAP__CARS = 1;

   /**
    * The feature id for the '<em><b>Western Signal</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ROAD_MAP__WESTERN_SIGNAL = 2;

   /**
    * The feature id for the '<em><b>Eastern Signal</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ROAD_MAP__EASTERN_SIGNAL = 3;

   /**
    * The number of structural features of the '<em>Road Map</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ROAD_MAP_FEATURE_COUNT = 4;

   /**
    * The operation id for the '<em>To String</em>' operation.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ROAD_MAP___TO_STRING = 0;

   /**
    * The number of operations of the '<em>Road Map</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ROAD_MAP_OPERATION_COUNT = 1;

   /**
    * The meta object id for the '{@link emfer.examples.roadwork.impl.RoadImpl <em>Road</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see emfer.examples.roadwork.impl.RoadImpl
    * @see emfer.examples.roadwork.impl.RoadworkPackageImpl#getRoad()
    * @generated
    */
   int ROAD = 1;

   /**
    * The feature id for the '<em><b>Tracks</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ROAD__TRACKS = 0;

   /**
    * The number of structural features of the '<em>Road</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ROAD_FEATURE_COUNT = 1;

   /**
    * The number of operations of the '<em>Road</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ROAD_OPERATION_COUNT = 0;

   /**
    * The meta object id for the '{@link emfer.examples.roadwork.impl.TrackImpl <em>Track</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see emfer.examples.roadwork.impl.TrackImpl
    * @see emfer.examples.roadwork.impl.RoadworkPackageImpl#getTrack()
    * @generated
    */
   int TRACK = 2;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int TRACK__NAME = 0;

   /**
    * The feature id for the '<em><b>Travel Direction</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int TRACK__TRAVEL_DIRECTION = 1;

   /**
    * The feature id for the '<em><b>West</b></em>' reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int TRACK__WEST = 2;

   /**
    * The feature id for the '<em><b>East</b></em>' reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int TRACK__EAST = 3;

   /**
    * The number of structural features of the '<em>Track</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int TRACK_FEATURE_COUNT = 4;

   /**
    * The number of operations of the '<em>Track</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int TRACK_OPERATION_COUNT = 0;

   /**
    * The meta object id for the '{@link emfer.examples.roadwork.impl.SignalImpl <em>Signal</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see emfer.examples.roadwork.impl.SignalImpl
    * @see emfer.examples.roadwork.impl.RoadworkPackageImpl#getSignal()
    * @generated
    */
   int SIGNAL = 3;

   /**
    * The feature id for the '<em><b>Pass</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int SIGNAL__PASS = 0;

   /**
    * The feature id for the '<em><b>Track</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int SIGNAL__TRACK = 1;

   /**
    * The number of structural features of the '<em>Signal</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int SIGNAL_FEATURE_COUNT = 2;

   /**
    * The number of operations of the '<em>Signal</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int SIGNAL_OPERATION_COUNT = 0;

   /**
    * The meta object id for the '{@link emfer.examples.roadwork.impl.CarImpl <em>Car</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see emfer.examples.roadwork.impl.CarImpl
    * @see emfer.examples.roadwork.impl.RoadworkPackageImpl#getCar()
    * @generated
    */
   int CAR = 4;

   /**
    * The feature id for the '<em><b>Travel Direction</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int CAR__TRAVEL_DIRECTION = 0;

   /**
    * The feature id for the '<em><b>Track</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int CAR__TRACK = 1;

   /**
    * The number of structural features of the '<em>Car</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int CAR_FEATURE_COUNT = 2;

   /**
    * The number of operations of the '<em>Car</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int CAR_OPERATION_COUNT = 0;

   /**
    * The meta object id for the '{@link emfer.examples.roadwork.TravelDirection <em>Travel Direction</em>}' enum.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see emfer.examples.roadwork.TravelDirection
    * @see emfer.examples.roadwork.impl.RoadworkPackageImpl#getTravelDirection()
    * @generated
    */
   int TRAVEL_DIRECTION = 5;


   /**
    * Returns the meta object for class '{@link emfer.examples.roadwork.RoadMap <em>Road Map</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Road Map</em>'.
    * @see emfer.examples.roadwork.RoadMap
    * @generated
    */
   EClass getRoadMap();

   /**
    * Returns the meta object for the containment reference '{@link emfer.examples.roadwork.RoadMap#getRoad <em>Road</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Road</em>'.
    * @see emfer.examples.roadwork.RoadMap#getRoad()
    * @see #getRoadMap()
    * @generated
    */
   EReference getRoadMap_Road();

   /**
    * Returns the meta object for the containment reference list '{@link emfer.examples.roadwork.RoadMap#getCars <em>Cars</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Cars</em>'.
    * @see emfer.examples.roadwork.RoadMap#getCars()
    * @see #getRoadMap()
    * @generated
    */
   EReference getRoadMap_Cars();

   /**
    * Returns the meta object for the containment reference '{@link emfer.examples.roadwork.RoadMap#getWesternSignal <em>Western Signal</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Western Signal</em>'.
    * @see emfer.examples.roadwork.RoadMap#getWesternSignal()
    * @see #getRoadMap()
    * @generated
    */
   EReference getRoadMap_WesternSignal();

   /**
    * Returns the meta object for the containment reference '{@link emfer.examples.roadwork.RoadMap#getEasternSignal <em>Eastern Signal</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Eastern Signal</em>'.
    * @see emfer.examples.roadwork.RoadMap#getEasternSignal()
    * @see #getRoadMap()
    * @generated
    */
   EReference getRoadMap_EasternSignal();

   /**
    * Returns the meta object for the '{@link emfer.examples.roadwork.RoadMap#toString() <em>To String</em>}' operation.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the '<em>To String</em>' operation.
    * @see emfer.examples.roadwork.RoadMap#toString()
    * @generated
    */
   EOperation getRoadMap__ToString();

   /**
    * Returns the meta object for class '{@link emfer.examples.roadwork.Road <em>Road</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Road</em>'.
    * @see emfer.examples.roadwork.Road
    * @generated
    */
   EClass getRoad();

   /**
    * Returns the meta object for the containment reference list '{@link emfer.examples.roadwork.Road#getTracks <em>Tracks</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Tracks</em>'.
    * @see emfer.examples.roadwork.Road#getTracks()
    * @see #getRoad()
    * @generated
    */
   EReference getRoad_Tracks();

   /**
    * Returns the meta object for class '{@link emfer.examples.roadwork.Track <em>Track</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Track</em>'.
    * @see emfer.examples.roadwork.Track
    * @generated
    */
   EClass getTrack();

   /**
    * Returns the meta object for the attribute '{@link emfer.examples.roadwork.Track#getName <em>Name</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Name</em>'.
    * @see emfer.examples.roadwork.Track#getName()
    * @see #getTrack()
    * @generated
    */
   EAttribute getTrack_Name();

   /**
    * Returns the meta object for the attribute '{@link emfer.examples.roadwork.Track#getTravelDirection <em>Travel Direction</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Travel Direction</em>'.
    * @see emfer.examples.roadwork.Track#getTravelDirection()
    * @see #getTrack()
    * @generated
    */
   EAttribute getTrack_TravelDirection();

   /**
    * Returns the meta object for the reference list '{@link emfer.examples.roadwork.Track#getWest <em>West</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the reference list '<em>West</em>'.
    * @see emfer.examples.roadwork.Track#getWest()
    * @see #getTrack()
    * @generated
    */
   EReference getTrack_West();

   /**
    * Returns the meta object for the reference list '{@link emfer.examples.roadwork.Track#getEast <em>East</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the reference list '<em>East</em>'.
    * @see emfer.examples.roadwork.Track#getEast()
    * @see #getTrack()
    * @generated
    */
   EReference getTrack_East();

   /**
    * Returns the meta object for class '{@link emfer.examples.roadwork.Signal <em>Signal</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Signal</em>'.
    * @see emfer.examples.roadwork.Signal
    * @generated
    */
   EClass getSignal();

   /**
    * Returns the meta object for the attribute '{@link emfer.examples.roadwork.Signal#isPass <em>Pass</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Pass</em>'.
    * @see emfer.examples.roadwork.Signal#isPass()
    * @see #getSignal()
    * @generated
    */
   EAttribute getSignal_Pass();

   /**
    * Returns the meta object for the reference '{@link emfer.examples.roadwork.Signal#getTrack <em>Track</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the reference '<em>Track</em>'.
    * @see emfer.examples.roadwork.Signal#getTrack()
    * @see #getSignal()
    * @generated
    */
   EReference getSignal_Track();

   /**
    * Returns the meta object for class '{@link emfer.examples.roadwork.Car <em>Car</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Car</em>'.
    * @see emfer.examples.roadwork.Car
    * @generated
    */
   EClass getCar();

   /**
    * Returns the meta object for the attribute '{@link emfer.examples.roadwork.Car#getTravelDirection <em>Travel Direction</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Travel Direction</em>'.
    * @see emfer.examples.roadwork.Car#getTravelDirection()
    * @see #getCar()
    * @generated
    */
   EAttribute getCar_TravelDirection();

   /**
    * Returns the meta object for the reference '{@link emfer.examples.roadwork.Car#getTrack <em>Track</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the reference '<em>Track</em>'.
    * @see emfer.examples.roadwork.Car#getTrack()
    * @see #getCar()
    * @generated
    */
   EReference getCar_Track();

   /**
    * Returns the meta object for enum '{@link emfer.examples.roadwork.TravelDirection <em>Travel Direction</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for enum '<em>Travel Direction</em>'.
    * @see emfer.examples.roadwork.TravelDirection
    * @generated
    */
   EEnum getTravelDirection();

   /**
    * Returns the factory that creates the instances of the model.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the factory that creates the instances of the model.
    * @generated
    */
   RoadworkFactory getRoadworkFactory();

   /**
    * <!-- begin-user-doc -->
    * Defines literals for the meta objects that represent
    * <ul>
    *   <li>each class,</li>
    *   <li>each feature of each class,</li>
    *   <li>each operation of each class,</li>
    *   <li>each enum,</li>
    *   <li>and each data type</li>
    * </ul>
    * <!-- end-user-doc -->
    * @generated
    */
   interface Literals
   {
      /**
       * The meta object literal for the '{@link emfer.examples.roadwork.impl.RoadMapImpl <em>Road Map</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see emfer.examples.roadwork.impl.RoadMapImpl
       * @see emfer.examples.roadwork.impl.RoadworkPackageImpl#getRoadMap()
       * @generated
       */
      EClass ROAD_MAP = eINSTANCE.getRoadMap();

      /**
       * The meta object literal for the '<em><b>Road</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference ROAD_MAP__ROAD = eINSTANCE.getRoadMap_Road();

      /**
       * The meta object literal for the '<em><b>Cars</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference ROAD_MAP__CARS = eINSTANCE.getRoadMap_Cars();

      /**
       * The meta object literal for the '<em><b>Western Signal</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference ROAD_MAP__WESTERN_SIGNAL = eINSTANCE.getRoadMap_WesternSignal();

      /**
       * The meta object literal for the '<em><b>Eastern Signal</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference ROAD_MAP__EASTERN_SIGNAL = eINSTANCE.getRoadMap_EasternSignal();

      /**
       * The meta object literal for the '<em><b>To String</b></em>' operation.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EOperation ROAD_MAP___TO_STRING = eINSTANCE.getRoadMap__ToString();

      /**
       * The meta object literal for the '{@link emfer.examples.roadwork.impl.RoadImpl <em>Road</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see emfer.examples.roadwork.impl.RoadImpl
       * @see emfer.examples.roadwork.impl.RoadworkPackageImpl#getRoad()
       * @generated
       */
      EClass ROAD = eINSTANCE.getRoad();

      /**
       * The meta object literal for the '<em><b>Tracks</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference ROAD__TRACKS = eINSTANCE.getRoad_Tracks();

      /**
       * The meta object literal for the '{@link emfer.examples.roadwork.impl.TrackImpl <em>Track</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see emfer.examples.roadwork.impl.TrackImpl
       * @see emfer.examples.roadwork.impl.RoadworkPackageImpl#getTrack()
       * @generated
       */
      EClass TRACK = eINSTANCE.getTrack();

      /**
       * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute TRACK__NAME = eINSTANCE.getTrack_Name();

      /**
       * The meta object literal for the '<em><b>Travel Direction</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute TRACK__TRAVEL_DIRECTION = eINSTANCE.getTrack_TravelDirection();

      /**
       * The meta object literal for the '<em><b>West</b></em>' reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference TRACK__WEST = eINSTANCE.getTrack_West();

      /**
       * The meta object literal for the '<em><b>East</b></em>' reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference TRACK__EAST = eINSTANCE.getTrack_East();

      /**
       * The meta object literal for the '{@link emfer.examples.roadwork.impl.SignalImpl <em>Signal</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see emfer.examples.roadwork.impl.SignalImpl
       * @see emfer.examples.roadwork.impl.RoadworkPackageImpl#getSignal()
       * @generated
       */
      EClass SIGNAL = eINSTANCE.getSignal();

      /**
       * The meta object literal for the '<em><b>Pass</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute SIGNAL__PASS = eINSTANCE.getSignal_Pass();

      /**
       * The meta object literal for the '<em><b>Track</b></em>' reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference SIGNAL__TRACK = eINSTANCE.getSignal_Track();

      /**
       * The meta object literal for the '{@link emfer.examples.roadwork.impl.CarImpl <em>Car</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see emfer.examples.roadwork.impl.CarImpl
       * @see emfer.examples.roadwork.impl.RoadworkPackageImpl#getCar()
       * @generated
       */
      EClass CAR = eINSTANCE.getCar();

      /**
       * The meta object literal for the '<em><b>Travel Direction</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute CAR__TRAVEL_DIRECTION = eINSTANCE.getCar_TravelDirection();

      /**
       * The meta object literal for the '<em><b>Track</b></em>' reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference CAR__TRACK = eINSTANCE.getCar_Track();

      /**
       * The meta object literal for the '{@link emfer.examples.roadwork.TravelDirection <em>Travel Direction</em>}' enum.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see emfer.examples.roadwork.TravelDirection
       * @see emfer.examples.roadwork.impl.RoadworkPackageImpl#getTravelDirection()
       * @generated
       */
      EEnum TRAVEL_DIRECTION = eINSTANCE.getTravelDirection();

   }

} //RoadworkPackage
