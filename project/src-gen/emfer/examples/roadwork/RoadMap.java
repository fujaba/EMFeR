/**
 */
package emfer.examples.roadwork;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Road Map</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link emfer.examples.roadwork.RoadMap#getRoad <em>Road</em>}</li>
 *   <li>{@link emfer.examples.roadwork.RoadMap#getCars <em>Cars</em>}</li>
 *   <li>{@link emfer.examples.roadwork.RoadMap#getWesternSignal <em>Western Signal</em>}</li>
 *   <li>{@link emfer.examples.roadwork.RoadMap#getEasternSignal <em>Eastern Signal</em>}</li>
 * </ul>
 *
 * @see emfer.examples.roadwork.RoadworkPackage#getRoadMap()
 * @model
 * @generated
 */
public interface RoadMap extends EObject
{
   /**
    * Returns the value of the '<em><b>Road</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Road</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Road</em>' containment reference.
    * @see #setRoad(Road)
    * @see emfer.examples.roadwork.RoadworkPackage#getRoadMap_Road()
    * @model containment="true"
    * @generated
    */
   Road getRoad();

   /**
    * Sets the value of the '{@link emfer.examples.roadwork.RoadMap#getRoad <em>Road</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Road</em>' containment reference.
    * @see #getRoad()
    * @generated
    */
   void setRoad(Road value);

   /**
    * Returns the value of the '<em><b>Cars</b></em>' containment reference list.
    * The list contents are of type {@link emfer.examples.roadwork.Car}.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Cars</em>' containment reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Cars</em>' containment reference list.
    * @see emfer.examples.roadwork.RoadworkPackage#getRoadMap_Cars()
    * @model containment="true"
    * @generated
    */
   EList<Car> getCars();

   /**
    * Returns the value of the '<em><b>Western Signal</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Western Signal</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Western Signal</em>' containment reference.
    * @see #setWesternSignal(Signal)
    * @see emfer.examples.roadwork.RoadworkPackage#getRoadMap_WesternSignal()
    * @model containment="true"
    * @generated
    */
   Signal getWesternSignal();

   /**
    * Sets the value of the '{@link emfer.examples.roadwork.RoadMap#getWesternSignal <em>Western Signal</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Western Signal</em>' containment reference.
    * @see #getWesternSignal()
    * @generated
    */
   void setWesternSignal(Signal value);

   /**
    * Returns the value of the '<em><b>Eastern Signal</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Eastern Signal</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Eastern Signal</em>' containment reference.
    * @see #setEasternSignal(Signal)
    * @see emfer.examples.roadwork.RoadworkPackage#getRoadMap_EasternSignal()
    * @model containment="true"
    * @generated
    */
   Signal getEasternSignal();

   /**
    * Sets the value of the '{@link emfer.examples.roadwork.RoadMap#getEasternSignal <em>Eastern Signal</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Eastern Signal</em>' containment reference.
    * @see #getEasternSignal()
    * @generated
    */
   void setEasternSignal(Signal value);

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @model unique="false"
    *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%java.lang.StringBuilder%&gt; bufNorthSignal = new &lt;%java.lang.StringBuilder%&gt;(\"       \\n\");\n&lt;%java.lang.StringBuilder%&gt; bufNorthCars = new &lt;%java.lang.StringBuilder%&gt;(\"-------\\n\");\n&lt;%java.lang.StringBuilder%&gt; bufSouthCars = new &lt;%java.lang.StringBuilder%&gt;(\"--/ \\\\--\\n\");\n&lt;%java.lang.StringBuilder%&gt; bufSouthSignal = new &lt;%java.lang.StringBuilder%&gt;(\"       \\n\");\nboolean _isPass = this.getEasternSignal().isPass();\nif (_isPass)\n{\n\tbufNorthSignal.setCharAt(5, \'T\');\n}\nelse\n{\n\tbufNorthSignal.setCharAt(5, \'F\');\n}\nboolean _isPass_1 = this.getWesternSignal().isPass();\nif (_isPass_1)\n{\n\tbufSouthSignal.setCharAt(1, \'T\');\n}\nelse\n{\n\tbufSouthSignal.setCharAt(1, \'F\');\n}\n&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%emfer.examples.roadwork.Car%&gt;&gt; _cars = this.getCars();\nfor (final &lt;%emfer.examples.roadwork.Car%&gt; c : _cars)\n{\n\t{\n\t\tchar carChar = \'E\';\n\t\t&lt;%emfer.examples.roadwork.TravelDirection%&gt; _travelDirection = c.getTravelDirection();\n\t\tboolean _equals = &lt;%com.google.common.base.Objects%&gt;.equal(_travelDirection, &lt;%emfer.examples.roadwork.TravelDirection%&gt;.WEST);\n\t\tif (_equals)\n\t\t{\n\t\t\tcarChar = \'W\';\n\t\t}\n\t\t&lt;%java.lang.String%&gt; trackName = c.getTrack().getName();\n\t\tchar _charAt = trackName.charAt(1);\n\t\tint index = (_charAt - \'1\');\n\t\tboolean _startsWith = trackName.startsWith(\"n\");\n\t\tif (_startsWith)\n\t\t{\n\t\t\tbufNorthCars.setCharAt((6 - index), carChar);\n\t\t}\n\t\telse\n\t\t{\n\t\t\tbufSouthCars.setCharAt(index, carChar);\n\t\t}\n\t}\n}\n&lt;%java.lang.String%&gt; _string = bufNorthSignal.append(bufNorthCars).append(bufSouthCars).append(bufSouthSignal).toString();\nreturn (\"\\n\" + _string);'"
    * @generated
    */
   String toString();

} // RoadMap
