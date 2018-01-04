/**
 */
package emfer.examples.roadwork;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Car</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link emfer.examples.roadwork.Car#getTravelDirection <em>Travel Direction</em>}</li>
 *   <li>{@link emfer.examples.roadwork.Car#getTrack <em>Track</em>}</li>
 * </ul>
 *
 * @see emfer.examples.roadwork.RoadworkPackage#getCar()
 * @model
 * @generated
 */
public interface Car extends EObject
{
   /**
    * Returns the value of the '<em><b>Travel Direction</b></em>' attribute.
    * The literals are from the enumeration {@link emfer.examples.roadwork.TravelDirection}.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Travel Direction</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Travel Direction</em>' attribute.
    * @see emfer.examples.roadwork.TravelDirection
    * @see #setTravelDirection(TravelDirection)
    * @see emfer.examples.roadwork.RoadworkPackage#getCar_TravelDirection()
    * @model unique="false"
    * @generated
    */
   TravelDirection getTravelDirection();

   /**
    * Sets the value of the '{@link emfer.examples.roadwork.Car#getTravelDirection <em>Travel Direction</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Travel Direction</em>' attribute.
    * @see emfer.examples.roadwork.TravelDirection
    * @see #getTravelDirection()
    * @generated
    */
   void setTravelDirection(TravelDirection value);

   /**
    * Returns the value of the '<em><b>Track</b></em>' reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Track</em>' reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Track</em>' reference.
    * @see #setTrack(Track)
    * @see emfer.examples.roadwork.RoadworkPackage#getCar_Track()
    * @model
    * @generated
    */
   Track getTrack();

   /**
    * Sets the value of the '{@link emfer.examples.roadwork.Car#getTrack <em>Track</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Track</em>' reference.
    * @see #getTrack()
    * @generated
    */
   void setTrack(Track value);

} // Car
