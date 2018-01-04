/**
 */
package emfer.examples.roadwork;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Road</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link emfer.examples.roadwork.Road#getTracks <em>Tracks</em>}</li>
 * </ul>
 *
 * @see emfer.examples.roadwork.RoadworkPackage#getRoad()
 * @model
 * @generated
 */
public interface Road extends EObject
{
   /**
    * Returns the value of the '<em><b>Tracks</b></em>' containment reference list.
    * The list contents are of type {@link emfer.examples.roadwork.Track}.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Tracks</em>' containment reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Tracks</em>' containment reference list.
    * @see emfer.examples.roadwork.RoadworkPackage#getRoad_Tracks()
    * @model containment="true"
    * @generated
    */
   EList<Track> getTracks();

} // Road
