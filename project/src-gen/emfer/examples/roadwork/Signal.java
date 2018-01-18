/**
 */
package emfer.examples.roadwork;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Signal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link emfer.examples.roadwork.Signal#isPass <em>Pass</em>}</li>
 *   <li>{@link emfer.examples.roadwork.Signal#getTrack <em>Track</em>}</li>
 * </ul>
 *
 * @see emfer.examples.roadwork.RoadworkPackage#getSignal()
 * @model
 * @generated
 */
public interface Signal extends EObject
{
   /**
    * Returns the value of the '<em><b>Pass</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Pass</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Pass</em>' attribute.
    * @see #setPass(boolean)
    * @see emfer.examples.roadwork.RoadworkPackage#getSignal_Pass()
    * @model unique="false"
    * @generated
    */
   boolean isPass();

   /**
    * Sets the value of the '{@link emfer.examples.roadwork.Signal#isPass <em>Pass</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Pass</em>' attribute.
    * @see #isPass()
    * @generated
    */
   void setPass(boolean value);

   /**
    * Returns the value of the '<em><b>Track</b></em>' reference.
    * It is bidirectional and its opposite is '{@link emfer.examples.roadwork.Track#getSignal <em>Signal</em>}'.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Track</em>' reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Track</em>' reference.
    * @see #setTrack(Track)
    * @see emfer.examples.roadwork.RoadworkPackage#getSignal_Track()
    * @see emfer.examples.roadwork.Track#getSignal
    * @model opposite="signal"
    * @generated
    */
   Track getTrack();

   /**
    * Sets the value of the '{@link emfer.examples.roadwork.Signal#getTrack <em>Track</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Track</em>' reference.
    * @see #getTrack()
    * @generated
    */
   void setTrack(Track value);

} // Signal
