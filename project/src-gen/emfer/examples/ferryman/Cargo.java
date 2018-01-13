/**
 */
package emfer.examples.ferryman;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cargo</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link emfer.examples.ferryman.Cargo#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see emfer.examples.ferryman.FerrymanPackage#getCargo()
 * @model
 * @generated
 */
public interface Cargo extends EObject
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
    * @see emfer.examples.ferryman.FerrymanPackage#getCargo_Name()
    * @model unique="false"
    * @generated
    */
   String getName();

   /**
    * Sets the value of the '{@link emfer.examples.ferryman.Cargo#getName <em>Name</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Name</em>' attribute.
    * @see #getName()
    * @generated
    */
   void setName(String value);

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @model unique="false"
    *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%java.lang.String%&gt; _name = this.getName();\nreturn (\"Cargo: \" + _name);'"
    * @generated
    */
   String toString();

} // Cargo