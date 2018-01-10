/**
 */
package emfer.examples.tower;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see emfer.examples.tower.TowerFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel basePackage='emfer.examples'"
 * @generated
 */
public interface TowerPackage extends EPackage
{
   /**
    * The package name.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String eNAME = "tower";

   /**
    * The package namespace URI.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String eNS_URI = "emfer.examples.tower";

   /**
    * The package namespace name.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String eNS_PREFIX = "tower";

   /**
    * The singleton instance of the package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   TowerPackage eINSTANCE = emfer.examples.tower.impl.TowerPackageImpl.init();

   /**
    * The meta object id for the '{@link emfer.examples.tower.impl.BoardImpl <em>Board</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see emfer.examples.tower.impl.BoardImpl
    * @see emfer.examples.tower.impl.TowerPackageImpl#getBoard()
    * @generated
    */
   int BOARD = 0;

   /**
    * The feature id for the '<em><b>Stacks</b></em>' reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BOARD__STACKS = 0;

   /**
    * The number of structural features of the '<em>Board</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BOARD_FEATURE_COUNT = 1;

   /**
    * The operation id for the '<em>To String</em>' operation.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BOARD___TO_STRING = 0;

   /**
    * The number of operations of the '<em>Board</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BOARD_OPERATION_COUNT = 1;

   /**
    * The meta object id for the '{@link emfer.examples.tower.impl.StackImpl <em>Stack</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see emfer.examples.tower.impl.StackImpl
    * @see emfer.examples.tower.impl.TowerPackageImpl#getStack()
    * @generated
    */
   int STACK = 1;

   /**
    * The feature id for the '<em><b>Position</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int STACK__POSITION = 0;

   /**
    * The feature id for the '<em><b>Discs</b></em>' reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int STACK__DISCS = 1;

   /**
    * The number of structural features of the '<em>Stack</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int STACK_FEATURE_COUNT = 2;

   /**
    * The operation id for the '<em>To String</em>' operation.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int STACK___TO_STRING = 0;

   /**
    * The number of operations of the '<em>Stack</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int STACK_OPERATION_COUNT = 1;

   /**
    * The meta object id for the '{@link emfer.examples.tower.impl.DiscImpl <em>Disc</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see emfer.examples.tower.impl.DiscImpl
    * @see emfer.examples.tower.impl.TowerPackageImpl#getDisc()
    * @generated
    */
   int DISC = 2;

   /**
    * The feature id for the '<em><b>At</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISC__AT = 0;

   /**
    * The feature id for the '<em><b>Size</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISC__SIZE = 1;

   /**
    * The number of structural features of the '<em>Disc</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISC_FEATURE_COUNT = 2;

   /**
    * The operation id for the '<em>To String</em>' operation.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISC___TO_STRING = 0;

   /**
    * The number of operations of the '<em>Disc</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISC_OPERATION_COUNT = 1;


   /**
    * Returns the meta object for class '{@link emfer.examples.tower.Board <em>Board</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Board</em>'.
    * @see emfer.examples.tower.Board
    * @generated
    */
   EClass getBoard();

   /**
    * Returns the meta object for the reference list '{@link emfer.examples.tower.Board#getStacks <em>Stacks</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the reference list '<em>Stacks</em>'.
    * @see emfer.examples.tower.Board#getStacks()
    * @see #getBoard()
    * @generated
    */
   EReference getBoard_Stacks();

   /**
    * Returns the meta object for the '{@link emfer.examples.tower.Board#toString() <em>To String</em>}' operation.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the '<em>To String</em>' operation.
    * @see emfer.examples.tower.Board#toString()
    * @generated
    */
   EOperation getBoard__ToString();

   /**
    * Returns the meta object for class '{@link emfer.examples.tower.Stack <em>Stack</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Stack</em>'.
    * @see emfer.examples.tower.Stack
    * @generated
    */
   EClass getStack();

   /**
    * Returns the meta object for the attribute '{@link emfer.examples.tower.Stack#getPosition <em>Position</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Position</em>'.
    * @see emfer.examples.tower.Stack#getPosition()
    * @see #getStack()
    * @generated
    */
   EAttribute getStack_Position();

   /**
    * Returns the meta object for the reference list '{@link emfer.examples.tower.Stack#getDiscs <em>Discs</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the reference list '<em>Discs</em>'.
    * @see emfer.examples.tower.Stack#getDiscs()
    * @see #getStack()
    * @generated
    */
   EReference getStack_Discs();

   /**
    * Returns the meta object for the '{@link emfer.examples.tower.Stack#toString() <em>To String</em>}' operation.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the '<em>To String</em>' operation.
    * @see emfer.examples.tower.Stack#toString()
    * @generated
    */
   EOperation getStack__ToString();

   /**
    * Returns the meta object for class '{@link emfer.examples.tower.Disc <em>Disc</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Disc</em>'.
    * @see emfer.examples.tower.Disc
    * @generated
    */
   EClass getDisc();

   /**
    * Returns the meta object for the reference '{@link emfer.examples.tower.Disc#getAt <em>At</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the reference '<em>At</em>'.
    * @see emfer.examples.tower.Disc#getAt()
    * @see #getDisc()
    * @generated
    */
   EReference getDisc_At();

   /**
    * Returns the meta object for the attribute '{@link emfer.examples.tower.Disc#getSize <em>Size</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Size</em>'.
    * @see emfer.examples.tower.Disc#getSize()
    * @see #getDisc()
    * @generated
    */
   EAttribute getDisc_Size();

   /**
    * Returns the meta object for the '{@link emfer.examples.tower.Disc#toString() <em>To String</em>}' operation.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the '<em>To String</em>' operation.
    * @see emfer.examples.tower.Disc#toString()
    * @generated
    */
   EOperation getDisc__ToString();

   /**
    * Returns the factory that creates the instances of the model.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the factory that creates the instances of the model.
    * @generated
    */
   TowerFactory getTowerFactory();

   /**
    * <!-- begin-user-doc -->
    * Defines literals for the meta objects that represent
    * <ul>
    *   <li>each class,</li>
    *   <li>each feature of each class,</li>
    *   <li>each operation of each class,</li>
    *   <li>each enum,</li>
    *   <li>and each data type</li>
    * </ul>
    * <!-- end-user-doc -->
    * @generated
    */
   interface Literals
   {
      /**
       * The meta object literal for the '{@link emfer.examples.tower.impl.BoardImpl <em>Board</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see emfer.examples.tower.impl.BoardImpl
       * @see emfer.examples.tower.impl.TowerPackageImpl#getBoard()
       * @generated
       */
      EClass BOARD = eINSTANCE.getBoard();

      /**
       * The meta object literal for the '<em><b>Stacks</b></em>' reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference BOARD__STACKS = eINSTANCE.getBoard_Stacks();

      /**
       * The meta object literal for the '<em><b>To String</b></em>' operation.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EOperation BOARD___TO_STRING = eINSTANCE.getBoard__ToString();

      /**
       * The meta object literal for the '{@link emfer.examples.tower.impl.StackImpl <em>Stack</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see emfer.examples.tower.impl.StackImpl
       * @see emfer.examples.tower.impl.TowerPackageImpl#getStack()
       * @generated
       */
      EClass STACK = eINSTANCE.getStack();

      /**
       * The meta object literal for the '<em><b>Position</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute STACK__POSITION = eINSTANCE.getStack_Position();

      /**
       * The meta object literal for the '<em><b>Discs</b></em>' reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference STACK__DISCS = eINSTANCE.getStack_Discs();

      /**
       * The meta object literal for the '<em><b>To String</b></em>' operation.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EOperation STACK___TO_STRING = eINSTANCE.getStack__ToString();

      /**
       * The meta object literal for the '{@link emfer.examples.tower.impl.DiscImpl <em>Disc</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see emfer.examples.tower.impl.DiscImpl
       * @see emfer.examples.tower.impl.TowerPackageImpl#getDisc()
       * @generated
       */
      EClass DISC = eINSTANCE.getDisc();

      /**
       * The meta object literal for the '<em><b>At</b></em>' reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference DISC__AT = eINSTANCE.getDisc_At();

      /**
       * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute DISC__SIZE = eINSTANCE.getDisc_Size();

      /**
       * The meta object literal for the '<em><b>To String</b></em>' operation.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EOperation DISC___TO_STRING = eINSTANCE.getDisc__ToString();

   }

} //TowerPackage
