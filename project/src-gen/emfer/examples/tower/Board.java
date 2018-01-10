/**
 */
package emfer.examples.tower;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Board</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link emfer.examples.tower.Board#getStacks <em>Stacks</em>}</li>
 * </ul>
 *
 * @see emfer.examples.tower.TowerPackage#getBoard()
 * @model
 * @generated
 */
public interface Board extends EObject
{
   /**
    * Returns the value of the '<em><b>Stacks</b></em>' reference list.
    * The list contents are of type {@link emfer.examples.tower.Stack}.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Stacks</em>' reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Stacks</em>' reference list.
    * @see emfer.examples.tower.TowerPackage#getBoard_Stacks()
    * @model
    * @generated
    */
   EList<Stack> getStacks();

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @model unique="false"
    *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%java.lang.StringBuilder%&gt; buf = new &lt;%java.lang.StringBuilder%&gt;();\n&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%emfer.examples.tower.Stack%&gt;&gt; _stacks = this.getStacks();\nfor (final &lt;%emfer.examples.tower.Stack%&gt; s : _stacks)\n{\n\tbuf.append(s.toString());\n}\nreturn buf.toString();'"
    * @generated
    */
   String toString();

} // Board
