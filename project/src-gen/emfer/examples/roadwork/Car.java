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
    * It is bidirectional and its opposite is '{@link emfer.examples.roadwork.Track#getCar <em>Car</em>}'.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Track</em>' reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Track</em>' reference.
    * @see #setTrack(Track)
    * @see emfer.examples.roadwork.RoadworkPackage#getCar_Track()
    * @see emfer.examples.roadwork.Track#getCar
    * @model opposite="car"
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

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @model unique="false"
    *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%java.lang.String%&gt; result = \"\";\n&lt;%emfer.examples.roadwork.Track%&gt; _track = this.getTrack();\nboolean _tripleNotEquals = (_track != null);\nif (_tripleNotEquals)\n{\n\t&lt;%java.lang.String%&gt; _result = result;\n\t&lt;%emfer.examples.roadwork.Track%&gt; _track_1 = this.getTrack();\n\t&lt;%java.lang.String%&gt; _plus = (\"at: \" + _track_1);\n\tresult = (_result + _plus);\n}\n&lt;%java.lang.String%&gt; _result_1 = result;\n&lt;%emfer.examples.roadwork.TravelDirection%&gt; _travelDirection = this.getTravelDirection();\n&lt;%java.lang.String%&gt; _plus_1 = (\" going \" + _travelDirection);\nresult = (_result_1 + _plus_1);\nreturn result;'"
    * @generated
    */
   String toString();

} // Car
