/**
 */
package emfer.examples.ferryman;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>River</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link emfer.examples.ferryman.River#getBanks <em>Banks</em>}</li>
 *   <li>{@link emfer.examples.ferryman.River#getBoat <em>Boat</em>}</li>
 * </ul>
 *
 * @see emfer.examples.ferryman.FerrymanPackage#getRiver()
 * @model
 * @generated
 */
public interface River extends EObject
{
   /**
    * Returns the value of the '<em><b>Banks</b></em>' reference list.
    * The list contents are of type {@link emfer.examples.ferryman.Bank}.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Banks</em>' reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Banks</em>' reference list.
    * @see emfer.examples.ferryman.FerrymanPackage#getRiver_Banks()
    * @model
    * @generated
    */
   EList<Bank> getBanks();

   /**
    * Returns the value of the '<em><b>Boat</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Boat</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Boat</em>' containment reference.
    * @see #setBoat(Boat)
    * @see emfer.examples.ferryman.FerrymanPackage#getRiver_Boat()
    * @model containment="true"
    * @generated
    */
   Boat getBoat();

   /**
    * Sets the value of the '{@link emfer.examples.ferryman.River#getBoat <em>Boat</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Boat</em>' containment reference.
    * @see #getBoat()
    * @generated
    */
   void setBoat(Boat value);

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @model unique="false"
    *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%java.lang.StringBuilder%&gt; buf = new &lt;%java.lang.StringBuilder%&gt;();\nif ((((this.getBanks() != null) &amp;&amp; (this.getBanks().size() &gt;= 2)) &amp;&amp; (this.getBoat() != null)))\n{\n\t&lt;%emfer.examples.ferryman.Bank%&gt; left = this.getBanks().get(0);\n\t&lt;%emfer.examples.ferryman.Bank%&gt; right = this.getBanks().get(1);\n\tboolean _equals = left.getName().equals(\"right\");\n\tif (_equals)\n\t{\n\t\tleft = this.getBanks().get(1);\n\t\tright = this.getBanks().get(0);\n\t}\n\tbuf.append(left.toString()).append(\"\\n\");\n\tbuf.append(this.getBoat().toString()).append(\"\\n\");\n\tbuf.append(right.toString()).append(\"\\n\");\n}\nreturn buf.toString();'"
    * @generated
    */
   String toString();

} // River
