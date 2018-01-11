/**
 */
package emfer.examples.tower;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stack</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link emfer.examples.tower.Stack#getPosition <em>Position</em>}</li>
 *   <li>{@link emfer.examples.tower.Stack#getDiscs <em>Discs</em>}</li>
 * </ul>
 *
 * @see emfer.examples.tower.TowerPackage#getStack()
 * @model
 * @generated
 */
public interface Stack extends EObject
{
   /**
    * Returns the value of the '<em><b>Position</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Position</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Position</em>' attribute.
    * @see #setPosition(String)
    * @see emfer.examples.tower.TowerPackage#getStack_Position()
    * @model unique="false"
    * @generated
    */
   String getPosition();

   /**
    * Sets the value of the '{@link emfer.examples.tower.Stack#getPosition <em>Position</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Position</em>' attribute.
    * @see #getPosition()
    * @generated
    */
   void setPosition(String value);

   /**
    * Returns the value of the '<em><b>Discs</b></em>' reference list.
    * The list contents are of type {@link emfer.examples.tower.Disc}.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Discs</em>' reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Discs</em>' reference list.
    * @see emfer.examples.tower.TowerPackage#getStack_Discs()
    * @model
    * @generated
    */
   EList<Disc> getDiscs();

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @model unique="false"
    *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%java.lang.StringBuilder%&gt; buf = new &lt;%java.lang.StringBuilder%&gt;();\nbuf.append(\"stack \").append(this.getPosition()).append(\": \");\n&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%emfer.examples.tower.Disc%&gt;&gt; _discs = this.getDiscs();\nfor (final &lt;%emfer.examples.tower.Disc%&gt; d : _discs)\n{\n\tbuf.append(d.toString());\n}\nreturn buf.toString();'"
    * @generated
    */
   String toString();

} // Stack
