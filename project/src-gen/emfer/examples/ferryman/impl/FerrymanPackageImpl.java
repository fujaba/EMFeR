/**
 */
package emfer.examples.ferryman.impl;

import emfer.examples.ferryman.Bank;
import emfer.examples.ferryman.Boat;
import emfer.examples.ferryman.Cargo;
import emfer.examples.ferryman.FerrymanFactory;
import emfer.examples.ferryman.FerrymanPackage;
import emfer.examples.ferryman.River;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FerrymanPackageImpl extends EPackageImpl implements FerrymanPackage
{
   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass riverEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass bankEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass boatEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass cargoEClass = null;

   /**
    * Creates an instance of the model <b>Package</b>, registered with
    * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
    * package URI value.
    * <p>Note: the correct way to create the package is via the static
    * factory method {@link #init init()}, which also performs
    * initialization of the package, or returns the registered package,
    * if one already exists.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.eclipse.emf.ecore.EPackage.Registry
    * @see emfer.examples.ferryman.FerrymanPackage#eNS_URI
    * @see #init()
    * @generated
    */
   private FerrymanPackageImpl()
   {
      super(eNS_URI, FerrymanFactory.eINSTANCE);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private static boolean isInited = false;

   /**
    * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
    * 
    * <p>This method is used to initialize {@link FerrymanPackage#eINSTANCE} when that field is accessed.
    * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #eNS_URI
    * @see #createPackageContents()
    * @see #initializePackageContents()
    * @generated
    */
   public static FerrymanPackage init()
   {
      if (isInited) return (FerrymanPackage)EPackage.Registry.INSTANCE.getEPackage(FerrymanPackage.eNS_URI);

      // Obtain or create and register package
      FerrymanPackageImpl theFerrymanPackage = (FerrymanPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FerrymanPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FerrymanPackageImpl());

      isInited = true;

      // Initialize simple dependencies
      EcorePackage.eINSTANCE.eClass();

      // Create package meta-data objects
      theFerrymanPackage.createPackageContents();

      // Initialize created meta-data
      theFerrymanPackage.initializePackageContents();

      // Mark meta-data to indicate it can't be changed
      theFerrymanPackage.freeze();

  
      // Update the registry and return the package
      EPackage.Registry.INSTANCE.put(FerrymanPackage.eNS_URI, theFerrymanPackage);
      return theFerrymanPackage;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getRiver()
   {
      return riverEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getRiver_Banks()
   {
      return (EReference)riverEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getRiver_Boat()
   {
      return (EReference)riverEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EOperation getRiver__ToString()
   {
      return riverEClass.getEOperations().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getBank()
   {
      return bankEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getBank_Name()
   {
      return (EAttribute)bankEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getBank_Cargos()
   {
      return (EReference)bankEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EOperation getBank__ToString()
   {
      return bankEClass.getEOperations().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getBoat()
   {
      return boatEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getBoat_At()
   {
      return (EReference)boatEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getBoat_Cargo()
   {
      return (EReference)boatEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EOperation getBoat__ToString()
   {
      return boatEClass.getEOperations().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getCargo()
   {
      return cargoEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getCargo_Name()
   {
      return (EAttribute)cargoEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public FerrymanFactory getFerrymanFactory()
   {
      return (FerrymanFactory)getEFactoryInstance();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private boolean isCreated = false;

   /**
    * Creates the meta-model objects for the package.  This method is
    * guarded to have no affect on any invocation but its first.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void createPackageContents()
   {
      if (isCreated) return;
      isCreated = true;

      // Create classes and their features
      riverEClass = createEClass(RIVER);
      createEReference(riverEClass, RIVER__BANKS);
      createEReference(riverEClass, RIVER__BOAT);
      createEOperation(riverEClass, RIVER___TO_STRING);

      bankEClass = createEClass(BANK);
      createEAttribute(bankEClass, BANK__NAME);
      createEReference(bankEClass, BANK__CARGOS);
      createEOperation(bankEClass, BANK___TO_STRING);

      boatEClass = createEClass(BOAT);
      createEReference(boatEClass, BOAT__AT);
      createEReference(boatEClass, BOAT__CARGO);
      createEOperation(boatEClass, BOAT___TO_STRING);

      cargoEClass = createEClass(CARGO);
      createEAttribute(cargoEClass, CARGO__NAME);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private boolean isInitialized = false;

   /**
    * Complete the initialization of the package and its meta-model.  This
    * method is guarded to have no affect on any invocation but its first.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void initializePackageContents()
   {
      if (isInitialized) return;
      isInitialized = true;

      // Initialize package
      setName(eNAME);
      setNsPrefix(eNS_PREFIX);
      setNsURI(eNS_URI);

      // Obtain other dependent packages
      EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

      // Create type parameters

      // Set bounds for type parameters

      // Add supertypes to classes

      // Initialize classes, features, and operations; add parameters
      initEClass(riverEClass, River.class, "River", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getRiver_Banks(), this.getBank(), null, "banks", null, 0, -1, River.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getRiver_Boat(), this.getBoat(), null, "boat", null, 0, 1, River.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEOperation(getRiver__ToString(), theEcorePackage.getEString(), "toString", 0, 1, !IS_UNIQUE, IS_ORDERED);

      initEClass(bankEClass, Bank.class, "Bank", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEAttribute(getBank_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Bank.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getBank_Cargos(), this.getCargo(), null, "cargos", null, 0, -1, Bank.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEOperation(getBank__ToString(), theEcorePackage.getEString(), "toString", 0, 1, !IS_UNIQUE, IS_ORDERED);

      initEClass(boatEClass, Boat.class, "Boat", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getBoat_At(), this.getBank(), null, "at", null, 0, 1, Boat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getBoat_Cargo(), this.getCargo(), null, "cargo", null, 0, 1, Boat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEOperation(getBoat__ToString(), theEcorePackage.getEString(), "toString", 0, 1, !IS_UNIQUE, IS_ORDERED);

      initEClass(cargoEClass, Cargo.class, "Cargo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEAttribute(getCargo_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Cargo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      // Create resource
      createResource(eNS_URI);
   }

} //FerrymanPackageImpl
