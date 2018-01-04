/**
 */
package emfer.reachability;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link emfer.reachability.ReachabilityGraph#getStates <em>States</em>}</li>
 *   <li>{@link emfer.reachability.ReachabilityGraph#getTrafoApplications <em>Trafo Applications</em>}</li>
 * </ul>
 *
 * @see emfer.reachability.ReachabilityPackage#getReachabilityGraph()
 * @model
 * @generated
 */
public interface ReachabilityGraph extends EObject
{
   /**
    * Returns the value of the '<em><b>States</b></em>' containment reference list.
    * The list contents are of type {@link emfer.reachability.ReachableState}.
    * It is bidirectional and its opposite is '{@link emfer.reachability.ReachableState#getParent <em>Parent</em>}'.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>States</em>' containment reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>States</em>' containment reference list.
    * @see emfer.reachability.ReachabilityPackage#getReachabilityGraph_States()
    * @see emfer.reachability.ReachableState#getParent
    * @model opposite="parent" containment="true"
    * @generated
    */
   EList<ReachableState> getStates();

   /**
    * Returns the value of the '<em><b>Trafo Applications</b></em>' containment reference list.
    * The list contents are of type {@link emfer.reachability.TrafoApplication}.
    * It is bidirectional and its opposite is '{@link emfer.reachability.TrafoApplication#getParent <em>Parent</em>}'.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Trafo Applications</em>' containment reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Trafo Applications</em>' containment reference list.
    * @see emfer.reachability.ReachabilityPackage#getReachabilityGraph_TrafoApplications()
    * @see emfer.reachability.TrafoApplication#getParent
    * @model opposite="parent" containment="true"
    * @generated
    */
   EList<TrafoApplication> getTrafoApplications();

} // ReachabilityGraph
