/**
 */
package emfer.examples.ferryman;

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
 * @see emfer.examples.ferryman.FerrymanFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel basePackage='emfer.examples'"
 * @generated
 */
public interface FerrymanPackage extends EPackage
{
   /**
    * The package name.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String eNAME = "ferryman";

   /**
    * The package namespace URI.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String eNS_URI = "emfer.examples.ferryman";

   /**
    * The package namespace name.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String eNS_PREFIX = "ferryman";

   /**
    * The singleton instance of the package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   FerrymanPackage eINSTANCE = emfer.examples.ferryman.impl.FerrymanPackageImpl.init();

   /**
    * The meta object id for the '{@link emfer.examples.ferryman.impl.RiverImpl <em>River</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see emfer.examples.ferryman.impl.RiverImpl
    * @see emfer.examples.ferryman.impl.FerrymanPackageImpl#getRiver()
    * @generated
    */
   int RIVER = 0;

   /**
    * The feature id for the '<em><b>Banks</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int RIVER__BANKS = 0;

   /**
    * The feature id for the '<em><b>Boat</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int RIVER__BOAT = 1;

   /**
    * The number of structural features of the '<em>River</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int RIVER_FEATURE_COUNT = 2;

   /**
    * The operation id for the '<em>To String</em>' operation.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int RIVER___TO_STRING = 0;

   /**
    * The number of operations of the '<em>River</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int RIVER_OPERATION_COUNT = 1;

   /**
    * The meta object id for the '{@link emfer.examples.ferryman.impl.BankImpl <em>Bank</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see emfer.examples.ferryman.impl.BankImpl
    * @see emfer.examples.ferryman.impl.FerrymanPackageImpl#getBank()
    * @generated
    */
   int BANK = 1;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BANK__NAME = 0;

   /**
    * The feature id for the '<em><b>Cargos</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BANK__CARGOS = 1;

   /**
    * The number of structural features of the '<em>Bank</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BANK_FEATURE_COUNT = 2;

   /**
    * The operation id for the '<em>To String</em>' operation.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BANK___TO_STRING = 0;

   /**
    * The number of operations of the '<em>Bank</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BANK_OPERATION_COUNT = 1;

   /**
    * The meta object id for the '{@link emfer.examples.ferryman.impl.BoatImpl <em>Boat</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see emfer.examples.ferryman.impl.BoatImpl
    * @see emfer.examples.ferryman.impl.FerrymanPackageImpl#getBoat()
    * @generated
    */
   int BOAT = 2;

   /**
    * The feature id for the '<em><b>At</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BOAT__AT = 0;

   /**
    * The feature id for the '<em><b>Cargo</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BOAT__CARGO = 1;

   /**
    * The number of structural features of the '<em>Boat</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BOAT_FEATURE_COUNT = 2;

   /**
    * The operation id for the '<em>To String</em>' operation.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BOAT___TO_STRING = 0;

   /**
    * The number of operations of the '<em>Boat</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BOAT_OPERATION_COUNT = 1;

   /**
    * The meta object id for the '{@link emfer.examples.ferryman.impl.CargoImpl <em>Cargo</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see emfer.examples.ferryman.impl.CargoImpl
    * @see emfer.examples.ferryman.impl.FerrymanPackageImpl#getCargo()
    * @generated
    */
   int CARGO = 3;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int CARGO__NAME = 0;

   /**
    * The number of structural features of the '<em>Cargo</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int CARGO_FEATURE_COUNT = 1;

   /**
    * The number of operations of the '<em>Cargo</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int CARGO_OPERATION_COUNT = 0;


   /**
    * Returns the meta object for class '{@link emfer.examples.ferryman.River <em>River</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>River</em>'.
    * @see emfer.examples.ferryman.River
    * @generated
    */
   EClass getRiver();

   /**
    * Returns the meta object for the containment reference list '{@link emfer.examples.ferryman.River#getBanks <em>Banks</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Banks</em>'.
    * @see emfer.examples.ferryman.River#getBanks()
    * @see #getRiver()
    * @generated
    */
   EReference getRiver_Banks();

   /**
    * Returns the meta object for the containment reference '{@link emfer.examples.ferryman.River#getBoat <em>Boat</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Boat</em>'.
    * @see emfer.examples.ferryman.River#getBoat()
    * @see #getRiver()
    * @generated
    */
   EReference getRiver_Boat();

   /**
    * Returns the meta object for the '{@link emfer.examples.ferryman.River#toString() <em>To String</em>}' operation.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the '<em>To String</em>' operation.
    * @see emfer.examples.ferryman.River#toString()
    * @generated
    */
   EOperation getRiver__ToString();

   /**
    * Returns the meta object for class '{@link emfer.examples.ferryman.Bank <em>Bank</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Bank</em>'.
    * @see emfer.examples.ferryman.Bank
    * @generated
    */
   EClass getBank();

   /**
    * Returns the meta object for the attribute '{@link emfer.examples.ferryman.Bank#getName <em>Name</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Name</em>'.
    * @see emfer.examples.ferryman.Bank#getName()
    * @see #getBank()
    * @generated
    */
   EAttribute getBank_Name();

   /**
    * Returns the meta object for the containment reference list '{@link emfer.examples.ferryman.Bank#getCargos <em>Cargos</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Cargos</em>'.
    * @see emfer.examples.ferryman.Bank#getCargos()
    * @see #getBank()
    * @generated
    */
   EReference getBank_Cargos();

   /**
    * Returns the meta object for the '{@link emfer.examples.ferryman.Bank#toString() <em>To String</em>}' operation.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the '<em>To String</em>' operation.
    * @see emfer.examples.ferryman.Bank#toString()
    * @generated
    */
   EOperation getBank__ToString();

   /**
    * Returns the meta object for class '{@link emfer.examples.ferryman.Boat <em>Boat</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Boat</em>'.
    * @see emfer.examples.ferryman.Boat
    * @generated
    */
   EClass getBoat();

   /**
    * Returns the meta object for the reference '{@link emfer.examples.ferryman.Boat#getAt <em>At</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the reference '<em>At</em>'.
    * @see emfer.examples.ferryman.Boat#getAt()
    * @see #getBoat()
    * @generated
    */
   EReference getBoat_At();

   /**
    * Returns the meta object for the reference '{@link emfer.examples.ferryman.Boat#getCargo <em>Cargo</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the reference '<em>Cargo</em>'.
    * @see emfer.examples.ferryman.Boat#getCargo()
    * @see #getBoat()
    * @generated
    */
   EReference getBoat_Cargo();

   /**
    * Returns the meta object for the '{@link emfer.examples.ferryman.Boat#toString() <em>To String</em>}' operation.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the '<em>To String</em>' operation.
    * @see emfer.examples.ferryman.Boat#toString()
    * @generated
    */
   EOperation getBoat__ToString();

   /**
    * Returns the meta object for class '{@link emfer.examples.ferryman.Cargo <em>Cargo</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Cargo</em>'.
    * @see emfer.examples.ferryman.Cargo
    * @generated
    */
   EClass getCargo();

   /**
    * Returns the meta object for the attribute '{@link emfer.examples.ferryman.Cargo#getName <em>Name</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Name</em>'.
    * @see emfer.examples.ferryman.Cargo#getName()
    * @see #getCargo()
    * @generated
    */
   EAttribute getCargo_Name();

   /**
    * Returns the factory that creates the instances of the model.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the factory that creates the instances of the model.
    * @generated
    */
   FerrymanFactory getFerrymanFactory();

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
       * The meta object literal for the '{@link emfer.examples.ferryman.impl.RiverImpl <em>River</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see emfer.examples.ferryman.impl.RiverImpl
       * @see emfer.examples.ferryman.impl.FerrymanPackageImpl#getRiver()
       * @generated
       */
      EClass RIVER = eINSTANCE.getRiver();

      /**
       * The meta object literal for the '<em><b>Banks</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference RIVER__BANKS = eINSTANCE.getRiver_Banks();

      /**
       * The meta object literal for the '<em><b>Boat</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference RIVER__BOAT = eINSTANCE.getRiver_Boat();

      /**
       * The meta object literal for the '<em><b>To String</b></em>' operation.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EOperation RIVER___TO_STRING = eINSTANCE.getRiver__ToString();

      /**
       * The meta object literal for the '{@link emfer.examples.ferryman.impl.BankImpl <em>Bank</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see emfer.examples.ferryman.impl.BankImpl
       * @see emfer.examples.ferryman.impl.FerrymanPackageImpl#getBank()
       * @generated
       */
      EClass BANK = eINSTANCE.getBank();

      /**
       * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute BANK__NAME = eINSTANCE.getBank_Name();

      /**
       * The meta object literal for the '<em><b>Cargos</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference BANK__CARGOS = eINSTANCE.getBank_Cargos();

      /**
       * The meta object literal for the '<em><b>To String</b></em>' operation.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EOperation BANK___TO_STRING = eINSTANCE.getBank__ToString();

      /**
       * The meta object literal for the '{@link emfer.examples.ferryman.impl.BoatImpl <em>Boat</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see emfer.examples.ferryman.impl.BoatImpl
       * @see emfer.examples.ferryman.impl.FerrymanPackageImpl#getBoat()
       * @generated
       */
      EClass BOAT = eINSTANCE.getBoat();

      /**
       * The meta object literal for the '<em><b>At</b></em>' reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference BOAT__AT = eINSTANCE.getBoat_At();

      /**
       * The meta object literal for the '<em><b>Cargo</b></em>' reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference BOAT__CARGO = eINSTANCE.getBoat_Cargo();

      /**
       * The meta object literal for the '<em><b>To String</b></em>' operation.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EOperation BOAT___TO_STRING = eINSTANCE.getBoat__ToString();

      /**
       * The meta object literal for the '{@link emfer.examples.ferryman.impl.CargoImpl <em>Cargo</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see emfer.examples.ferryman.impl.CargoImpl
       * @see emfer.examples.ferryman.impl.FerrymanPackageImpl#getCargo()
       * @generated
       */
      EClass CARGO = eINSTANCE.getCargo();

      /**
       * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute CARGO__NAME = eINSTANCE.getCargo_Name();

   }

} //FerrymanPackage
