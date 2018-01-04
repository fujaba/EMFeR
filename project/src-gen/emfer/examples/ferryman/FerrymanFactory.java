/**
 */
package emfer.examples.ferryman;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see emfer.examples.ferryman.FerrymanPackage
 * @generated
 */
public interface FerrymanFactory extends EFactory
{
   /**
    * The singleton instance of the factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   FerrymanFactory eINSTANCE = emfer.examples.ferryman.impl.FerrymanFactoryImpl.init();

   /**
    * Returns a new object of class '<em>River</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return a new object of class '<em>River</em>'.
    * @generated
    */
   River createRiver();

   /**
    * Returns a new object of class '<em>Bank</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return a new object of class '<em>Bank</em>'.
    * @generated
    */
   Bank createBank();

   /**
    * Returns a new object of class '<em>Boat</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return a new object of class '<em>Boat</em>'.
    * @generated
    */
   Boat createBoat();

   /**
    * Returns a new object of class '<em>Cargo</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return a new object of class '<em>Cargo</em>'.
    * @generated
    */
   Cargo createCargo();

   /**
    * Returns the package supported by this factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the package supported by this factory.
    * @generated
    */
   FerrymanPackage getFerrymanPackage();

} //FerrymanFactory
