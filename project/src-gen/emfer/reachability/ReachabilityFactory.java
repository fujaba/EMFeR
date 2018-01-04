/**
 */
package emfer.reachability;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see emfer.reachability.ReachabilityPackage
 * @generated
 */
public interface ReachabilityFactory extends EFactory
{
   /**
    * The singleton instance of the factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   ReachabilityFactory eINSTANCE = emfer.reachability.impl.ReachabilityFactoryImpl.init();

   /**
    * Returns a new object of class '<em>Graph</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return a new object of class '<em>Graph</em>'.
    * @generated
    */
   ReachabilityGraph createReachabilityGraph();

   /**
    * Returns a new object of class '<em>Reachable State</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return a new object of class '<em>Reachable State</em>'.
    * @generated
    */
   ReachableState createReachableState();

   /**
    * Returns a new object of class '<em>Trafo Application</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return a new object of class '<em>Trafo Application</em>'.
    * @generated
    */
   TrafoApplication createTrafoApplication();

   /**
    * Returns the package supported by this factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the package supported by this factory.
    * @generated
    */
   ReachabilityPackage getReachabilityPackage();

} //ReachabilityFactory
