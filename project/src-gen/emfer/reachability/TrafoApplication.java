/**
 */
package emfer.reachability;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trafo Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link emfer.reachability.TrafoApplication#getDescription <em>Description</em>}</li>
 *   <li>{@link emfer.reachability.TrafoApplication#getParent <em>Parent</em>}</li>
 *   <li>{@link emfer.reachability.TrafoApplication#getSrc <em>Src</em>}</li>
 *   <li>{@link emfer.reachability.TrafoApplication#getTgt <em>Tgt</em>}</li>
 * </ul>
 *
 * @see emfer.reachability.ReachabilityPackage#getTrafoApplication()
 * @model
 * @generated
 */
public interface TrafoApplication extends EObject
{
   /**
    * Returns the value of the '<em><b>Description</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Description</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Description</em>' attribute.
    * @see #setDescription(String)
    * @see emfer.reachability.ReachabilityPackage#getTrafoApplication_Description()
    * @model unique="false"
    * @generated
    */
   String getDescription();

   /**
    * Sets the value of the '{@link emfer.reachability.TrafoApplication#getDescription <em>Description</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Description</em>' attribute.
    * @see #getDescription()
    * @generated
    */
   void setDescription(String value);

   /**
    * Returns the value of the '<em><b>Parent</b></em>' container reference.
    * It is bidirectional and its opposite is '{@link emfer.reachability.ReachabilityGraph#getTrafoApplications <em>Trafo Applications</em>}'.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Parent</em>' container reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Parent</em>' container reference.
    * @see #setParent(ReachabilityGraph)
    * @see emfer.reachability.ReachabilityPackage#getTrafoApplication_Parent()
    * @see emfer.reachability.ReachabilityGraph#getTrafoApplications
    * @model opposite="trafoApplications" transient="false"
    * @generated
    */
   ReachabilityGraph getParent();

   /**
    * Sets the value of the '{@link emfer.reachability.TrafoApplication#getParent <em>Parent</em>}' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Parent</em>' container reference.
    * @see #getParent()
    * @generated
    */
   void setParent(ReachabilityGraph value);

   /**
    * Returns the value of the '<em><b>Src</b></em>' reference.
    * It is bidirectional and its opposite is '{@link emfer.reachability.ReachableState#getTrafoApplications <em>Trafo Applications</em>}'.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Src</em>' reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Src</em>' reference.
    * @see #setSrc(ReachableState)
    * @see emfer.reachability.ReachabilityPackage#getTrafoApplication_Src()
    * @see emfer.reachability.ReachableState#getTrafoApplications
    * @model opposite="trafoApplications"
    * @generated
    */
   ReachableState getSrc();

   /**
    * Sets the value of the '{@link emfer.reachability.TrafoApplication#getSrc <em>Src</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Src</em>' reference.
    * @see #getSrc()
    * @generated
    */
   void setSrc(ReachableState value);

   /**
    * Returns the value of the '<em><b>Tgt</b></em>' reference.
    * It is bidirectional and its opposite is '{@link emfer.reachability.ReachableState#getResultOf <em>Result Of</em>}'.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Tgt</em>' reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Tgt</em>' reference.
    * @see #setTgt(ReachableState)
    * @see emfer.reachability.ReachabilityPackage#getTrafoApplication_Tgt()
    * @see emfer.reachability.ReachableState#getResultOf
    * @model opposite="resultOf"
    * @generated
    */
   ReachableState getTgt();

   /**
    * Sets the value of the '{@link emfer.reachability.TrafoApplication#getTgt <em>Tgt</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Tgt</em>' reference.
    * @see #getTgt()
    * @generated
    */
   void setTgt(ReachableState value);

} // TrafoApplication
