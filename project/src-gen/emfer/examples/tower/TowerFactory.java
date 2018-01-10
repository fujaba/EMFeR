/**
 */
package emfer.examples.tower;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see emfer.examples.tower.TowerPackage
 * @generated
 */
public interface TowerFactory extends EFactory
{
   /**
    * The singleton instance of the factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   TowerFactory eINSTANCE = emfer.examples.tower.impl.TowerFactoryImpl.init();

   /**
    * Returns a new object of class '<em>Board</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return a new object of class '<em>Board</em>'.
    * @generated
    */
   Board createBoard();

   /**
    * Returns a new object of class '<em>Stack</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return a new object of class '<em>Stack</em>'.
    * @generated
    */
   Stack createStack();

   /**
    * Returns a new object of class '<em>Disc</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return a new object of class '<em>Disc</em>'.
    * @generated
    */
   Disc createDisc();

   /**
    * Returns the package supported by this factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the package supported by this factory.
    * @generated
    */
   TowerPackage getTowerPackage();

} //TowerFactory
