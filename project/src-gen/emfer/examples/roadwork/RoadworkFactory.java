/**
 */
package emfer.examples.roadwork;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see emfer.examples.roadwork.RoadworkPackage
 * @generated
 */
public interface RoadworkFactory extends EFactory
{
   /**
    * The singleton instance of the factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   RoadworkFactory eINSTANCE = emfer.examples.roadwork.impl.RoadworkFactoryImpl.init();

   /**
    * Returns a new object of class '<em>Road Map</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return a new object of class '<em>Road Map</em>'.
    * @generated
    */
   RoadMap createRoadMap();

   /**
    * Returns a new object of class '<em>Road</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return a new object of class '<em>Road</em>'.
    * @generated
    */
   Road createRoad();

   /**
    * Returns a new object of class '<em>Track</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return a new object of class '<em>Track</em>'.
    * @generated
    */
   Track createTrack();

   /**
    * Returns a new object of class '<em>Signal</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return a new object of class '<em>Signal</em>'.
    * @generated
    */
   Signal createSignal();

   /**
    * Returns a new object of class '<em>Car</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return a new object of class '<em>Car</em>'.
    * @generated
    */
   Car createCar();

   /**
    * Returns the package supported by this factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the package supported by this factory.
    * @generated
    */
   RoadworkPackage getRoadworkPackage();

} //RoadworkFactory
