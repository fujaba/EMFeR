/**
 */
package emfer.examples.ferryman;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bank</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link emfer.examples.ferryman.Bank#getName <em>Name</em>}</li>
 *   <li>{@link emfer.examples.ferryman.Bank#getCargos <em>Cargos</em>}</li>
 * </ul>
 *
 * @see emfer.examples.ferryman.FerrymanPackage#getBank()
 * @model
 * @generated
 */
public interface Bank extends EObject
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
    * @see emfer.examples.ferryman.FerrymanPackage#getBank_Name()
    * @model unique="false"
    * @generated
    */
   String getName();

   /**
    * Sets the value of the '{@link emfer.examples.ferryman.Bank#getName <em>Name</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Name</em>' attribute.
    * @see #getName()
    * @generated
    */
   void setName(String value);

   /**
    * Returns the value of the '<em><b>Cargos</b></em>' reference list.
    * The list contents are of type {@link emfer.examples.ferryman.Cargo}.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Cargos</em>' reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Cargos</em>' reference list.
    * @see emfer.examples.ferryman.FerrymanPackage#getBank_Cargos()
    * @model
    * @generated
    */
   EList<Cargo> getCargos();

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @model unique="false"
    *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%java.lang.StringBuilder%&gt; buf = new &lt;%java.lang.StringBuilder%&gt;();\nbuf.append(this.getName()).append(\": \");\n&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%emfer.examples.ferryman.Cargo%&gt;&gt; _cargos = this.getCargos();\nfor (final &lt;%emfer.examples.ferryman.Cargo%&gt; c : _cargos)\n{\n\tbuf.append(c.getName()).append(\" \");\n}\nreturn buf.toString();'"
    * @generated
    */
   String toString();

} // Bank
