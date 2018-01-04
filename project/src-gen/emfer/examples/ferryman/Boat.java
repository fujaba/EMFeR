/**
 */
package emfer.examples.ferryman;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boat</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link emfer.examples.ferryman.Boat#getAt <em>At</em>}</li>
 *   <li>{@link emfer.examples.ferryman.Boat#getCargo <em>Cargo</em>}</li>
 * </ul>
 *
 * @see emfer.examples.ferryman.FerrymanPackage#getBoat()
 * @model
 * @generated
 */
public interface Boat extends EObject
{
   /**
    * Returns the value of the '<em><b>At</b></em>' reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>At</em>' reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>At</em>' reference.
    * @see #setAt(Bank)
    * @see emfer.examples.ferryman.FerrymanPackage#getBoat_At()
    * @model
    * @generated
    */
   Bank getAt();

   /**
    * Sets the value of the '{@link emfer.examples.ferryman.Boat#getAt <em>At</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>At</em>' reference.
    * @see #getAt()
    * @generated
    */
   void setAt(Bank value);

   /**
    * Returns the value of the '<em><b>Cargo</b></em>' reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Cargo</em>' reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Cargo</em>' reference.
    * @see #setCargo(Cargo)
    * @see emfer.examples.ferryman.FerrymanPackage#getBoat_Cargo()
    * @model
    * @generated
    */
   Cargo getCargo();

   /**
    * Sets the value of the '{@link emfer.examples.ferryman.Boat#getCargo <em>Cargo</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Cargo</em>' reference.
    * @see #getCargo()
    * @generated
    */
   void setCargo(Cargo value);

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @model unique="false"
    *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%java.lang.StringBuilder%&gt; buf = new &lt;%java.lang.StringBuilder%&gt;();\nbuf.append(\"boat at: \");\n&lt;%emfer.examples.ferryman.Bank%&gt; _at = this.getAt();\nboolean _tripleNotEquals = (_at != null);\nif (_tripleNotEquals)\n{\n\tbuf.append(this.getAt().getName()).append(\" \");\n}\nbuf.append(\"cargo: \");\n&lt;%emfer.examples.ferryman.Cargo%&gt; _cargo = this.getCargo();\nboolean _tripleNotEquals_1 = (_cargo != null);\nif (_tripleNotEquals_1)\n{\n\tbuf.append(this.getCargo().getName());\n}\nreturn buf.toString();'"
    * @generated
    */
   String toString();

} // Boat
