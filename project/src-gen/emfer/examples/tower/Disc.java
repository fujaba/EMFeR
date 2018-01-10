/**
 */
package emfer.examples.tower;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Disc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link emfer.examples.tower.Disc#getAt <em>At</em>}</li>
 *   <li>{@link emfer.examples.tower.Disc#getSize <em>Size</em>}</li>
 * </ul>
 *
 * @see emfer.examples.tower.TowerPackage#getDisc()
 * @model
 * @generated
 */
public interface Disc extends EObject
{
   /**
    * Returns the value of the '<em><b>At</b></em>' reference.
    * It is bidirectional and its opposite is '{@link emfer.examples.tower.Stack#getDiscs <em>Discs</em>}'.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>At</em>' reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>At</em>' reference.
    * @see #setAt(Stack)
    * @see emfer.examples.tower.TowerPackage#getDisc_At()
    * @see emfer.examples.tower.Stack#getDiscs
    * @model opposite="discs"
    * @generated
    */
   Stack getAt();

   /**
    * Sets the value of the '{@link emfer.examples.tower.Disc#getAt <em>At</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>At</em>' reference.
    * @see #getAt()
    * @generated
    */
   void setAt(Stack value);

   /**
    * Returns the value of the '<em><b>Size</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Size</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Size</em>' attribute.
    * @see #setSize(Integer)
    * @see emfer.examples.tower.TowerPackage#getDisc_Size()
    * @model unique="false"
    * @generated
    */
   Integer getSize();

   /**
    * Sets the value of the '{@link emfer.examples.tower.Disc#getSize <em>Size</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Size</em>' attribute.
    * @see #getSize()
    * @generated
    */
   void setSize(Integer value);

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @model unique="false"
    *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%java.lang.StringBuilder%&gt; buf = new &lt;%java.lang.StringBuilder%&gt;();\nbuf.append(\"disc \").append(this.getSize()).append(\" \");\nreturn buf.toString();'"
    * @generated
    */
   String toString();

} // Disc
