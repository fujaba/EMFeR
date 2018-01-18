/**
 */
package emfer.examples.roadwork;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Track</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link emfer.examples.roadwork.Track#getName <em>Name</em>}</li>
 *   <li>{@link emfer.examples.roadwork.Track#getTravelDirection <em>Travel Direction</em>}</li>
 *   <li>{@link emfer.examples.roadwork.Track#getWest <em>West</em>}</li>
 *   <li>{@link emfer.examples.roadwork.Track#getEast <em>East</em>}</li>
 *   <li>{@link emfer.examples.roadwork.Track#getSignal <em>Signal</em>}</li>
 *   <li>{@link emfer.examples.roadwork.Track#getCar <em>Car</em>}</li>
 * </ul>
 *
 * @see emfer.examples.roadwork.RoadworkPackage#getTrack()
 * @model
 * @generated
 */
public interface Track extends EObject
{
   /**
    * Returns the value of the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Name</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Name</em>' attribute.
    * @see #setName(String)
    * @see emfer.examples.roadwork.RoadworkPackage#getTrack_Name()
    * @model unique="false"
    * @generated
    */
   String getName();

   /**
    * Sets the value of the '{@link emfer.examples.roadwork.Track#getName <em>Name</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Name</em>' attribute.
    * @see #getName()
    * @generated
    */
   void setName(String value);

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
    * @see emfer.examples.roadwork.RoadworkPackage#getTrack_TravelDirection()
    * @model unique="false"
    * @generated
    */
   TravelDirection getTravelDirection();

   /**
    * Sets the value of the '{@link emfer.examples.roadwork.Track#getTravelDirection <em>Travel Direction</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Travel Direction</em>' attribute.
    * @see emfer.examples.roadwork.TravelDirection
    * @see #getTravelDirection()
    * @generated
    */
   void setTravelDirection(TravelDirection value);

   /**
    * Returns the value of the '<em><b>West</b></em>' reference list.
    * The list contents are of type {@link emfer.examples.roadwork.Track}.
    * It is bidirectional and its opposite is '{@link emfer.examples.roadwork.Track#getEast <em>East</em>}'.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>West</em>' reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>West</em>' reference list.
    * @see emfer.examples.roadwork.RoadworkPackage#getTrack_West()
    * @see emfer.examples.roadwork.Track#getEast
    * @model opposite="east"
    * @generated
    */
   EList<Track> getWest();

   /**
    * Returns the value of the '<em><b>East</b></em>' reference list.
    * The list contents are of type {@link emfer.examples.roadwork.Track}.
    * It is bidirectional and its opposite is '{@link emfer.examples.roadwork.Track#getWest <em>West</em>}'.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>East</em>' reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>East</em>' reference list.
    * @see emfer.examples.roadwork.RoadworkPackage#getTrack_East()
    * @see emfer.examples.roadwork.Track#getWest
    * @model opposite="west"
    * @generated
    */
   EList<Track> getEast();

   /**
    * Returns the value of the '<em><b>Signal</b></em>' reference.
    * It is bidirectional and its opposite is '{@link emfer.examples.roadwork.Signal#getTrack <em>Track</em>}'.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Signal</em>' reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Signal</em>' reference.
    * @see #setSignal(Signal)
    * @see emfer.examples.roadwork.RoadworkPackage#getTrack_Signal()
    * @see emfer.examples.roadwork.Signal#getTrack
    * @model opposite="track"
    * @generated
    */
   Signal getSignal();

   /**
    * Sets the value of the '{@link emfer.examples.roadwork.Track#getSignal <em>Signal</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Signal</em>' reference.
    * @see #getSignal()
    * @generated
    */
   void setSignal(Signal value);

   /**
    * Returns the value of the '<em><b>Car</b></em>' reference.
    * It is bidirectional and its opposite is '{@link emfer.examples.roadwork.Car#getTrack <em>Track</em>}'.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Car</em>' reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Car</em>' reference.
    * @see #setCar(Car)
    * @see emfer.examples.roadwork.RoadworkPackage#getTrack_Car()
    * @see emfer.examples.roadwork.Car#getTrack
    * @model opposite="track"
    * @generated
    */
   Car getCar();

   /**
    * Sets the value of the '{@link emfer.examples.roadwork.Track#getCar <em>Car</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Car</em>' reference.
    * @see #getCar()
    * @generated
    */
   void setCar(Car value);

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @model unique="false"
    *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%java.lang.String%&gt; _name = this.getName();\nreturn (\"Track: \" + _name);'"
    * @generated
    */
   String toString();

} // Track
