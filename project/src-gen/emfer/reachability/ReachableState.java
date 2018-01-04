/**
 */
package emfer.reachability;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reachable State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link emfer.reachability.ReachableState#getNumber <em>Number</em>}</li>
 *   <li>{@link emfer.reachability.ReachableState#getParent <em>Parent</em>}</li>
 *   <li>{@link emfer.reachability.ReachableState#getRoot <em>Root</em>}</li>
 *   <li>{@link emfer.reachability.ReachableState#getResultOf <em>Result Of</em>}</li>
 *   <li>{@link emfer.reachability.ReachableState#getTrafoApplications <em>Trafo Applications</em>}</li>
 * </ul>
 *
 * @see emfer.reachability.ReachabilityPackage#getReachableState()
 * @model
 * @generated
 */
public interface ReachableState extends EObject
{
   /**
    * Returns the value of the '<em><b>Number</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Number</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Number</em>' attribute.
    * @see #setNumber(long)
    * @see emfer.reachability.ReachabilityPackage#getReachableState_Number()
    * @model unique="false"
    * @generated
    */
   long getNumber();

   /**
    * Sets the value of the '{@link emfer.reachability.ReachableState#getNumber <em>Number</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Number</em>' attribute.
    * @see #getNumber()
    * @generated
    */
   void setNumber(long value);

   /**
    * Returns the value of the '<em><b>Parent</b></em>' container reference.
    * It is bidirectional and its opposite is '{@link emfer.reachability.ReachabilityGraph#getStates <em>States</em>}'.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Parent</em>' container reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Parent</em>' container reference.
    * @see #setParent(ReachabilityGraph)
    * @see emfer.reachability.ReachabilityPackage#getReachableState_Parent()
    * @see emfer.reachability.ReachabilityGraph#getStates
    * @model opposite="states" transient="false"
    * @generated
    */
   ReachabilityGraph getParent();

   /**
    * Sets the value of the '{@link emfer.reachability.ReachableState#getParent <em>Parent</em>}' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Parent</em>' container reference.
    * @see #getParent()
    * @generated
    */
   void setParent(ReachabilityGraph value);

   /**
    * Returns the value of the '<em><b>Root</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Root</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Root</em>' containment reference.
    * @see #setRoot(EObject)
    * @see emfer.reachability.ReachabilityPackage#getReachableState_Root()
    * @model containment="true"
    * @generated
    */
   EObject getRoot();

   /**
    * Sets the value of the '{@link emfer.reachability.ReachableState#getRoot <em>Root</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Root</em>' containment reference.
    * @see #getRoot()
    * @generated
    */
   void setRoot(EObject value);

   /**
    * Returns the value of the '<em><b>Result Of</b></em>' reference list.
    * The list contents are of type {@link emfer.reachability.TrafoApplication}.
    * It is bidirectional and its opposite is '{@link emfer.reachability.TrafoApplication#getTgt <em>Tgt</em>}'.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Result Of</em>' reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Result Of</em>' reference list.
    * @see emfer.reachability.ReachabilityPackage#getReachableState_ResultOf()
    * @see emfer.reachability.TrafoApplication#getTgt
    * @model opposite="tgt"
    * @generated
    */
   EList<TrafoApplication> getResultOf();

   /**
    * Returns the value of the '<em><b>Trafo Applications</b></em>' reference list.
    * The list contents are of type {@link emfer.reachability.TrafoApplication}.
    * It is bidirectional and its opposite is '{@link emfer.reachability.TrafoApplication#getSrc <em>Src</em>}'.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Trafo Applications</em>' reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Trafo Applications</em>' reference list.
    * @see emfer.reachability.ReachabilityPackage#getReachableState_TrafoApplications()
    * @see emfer.reachability.TrafoApplication#getSrc
    * @model opposite="src"
    * @generated
    */
   EList<TrafoApplication> getTrafoApplications();

} // ReachableState
