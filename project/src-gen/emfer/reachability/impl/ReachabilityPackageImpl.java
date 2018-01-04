/**
 */
package emfer.reachability.impl;

import emfer.reachability.ReachabilityFactory;
import emfer.reachability.ReachabilityGraph;
import emfer.reachability.ReachabilityPackage;
import emfer.reachability.ReachableState;
import emfer.reachability.TrafoApplication;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
public class ReachabilityPackageImpl extends EPackageImpl implements ReachabilityPackage
{
   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass reachabilityGraphEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass reachableStateEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass trafoApplicationEClass = null;

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
    * @see emfer.reachability.ReachabilityPackage#eNS_URI
    * @see #init()
    * @generated
    */
   private ReachabilityPackageImpl()
   {
      super(eNS_URI, ReachabilityFactory.eINSTANCE);
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
    * <p>This method is used to initialize {@link ReachabilityPackage#eINSTANCE} when that field is accessed.
    * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #eNS_URI
    * @see #createPackageContents()
    * @see #initializePackageContents()
    * @generated
    */
   public static ReachabilityPackage init()
   {
      if (isInited) return (ReachabilityPackage)EPackage.Registry.INSTANCE.getEPackage(ReachabilityPackage.eNS_URI);

      // Obtain or create and register package
      ReachabilityPackageImpl theReachabilityPackage = (ReachabilityPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ReachabilityPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ReachabilityPackageImpl());

      isInited = true;

      // Initialize simple dependencies
      EcorePackage.eINSTANCE.eClass();

      // Create package meta-data objects
      theReachabilityPackage.createPackageContents();

      // Initialize created meta-data
      theReachabilityPackage.initializePackageContents();

      // Mark meta-data to indicate it can't be changed
      theReachabilityPackage.freeze();

  
      // Update the registry and return the package
      EPackage.Registry.INSTANCE.put(ReachabilityPackage.eNS_URI, theReachabilityPackage);
      return theReachabilityPackage;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getReachabilityGraph()
   {
      return reachabilityGraphEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getReachabilityGraph_States()
   {
      return (EReference)reachabilityGraphEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getReachabilityGraph_TrafoApplications()
   {
      return (EReference)reachabilityGraphEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getReachableState()
   {
      return reachableStateEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getReachableState_Number()
   {
      return (EAttribute)reachableStateEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getReachableState_Parent()
   {
      return (EReference)reachableStateEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getReachableState_Root()
   {
      return (EReference)reachableStateEClass.getEStructuralFeatures().get(2);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getReachableState_ResultOf()
   {
      return (EReference)reachableStateEClass.getEStructuralFeatures().get(3);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getReachableState_TrafoApplications()
   {
      return (EReference)reachableStateEClass.getEStructuralFeatures().get(4);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getTrafoApplication()
   {
      return trafoApplicationEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getTrafoApplication_Description()
   {
      return (EAttribute)trafoApplicationEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getTrafoApplication_Parent()
   {
      return (EReference)trafoApplicationEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getTrafoApplication_Src()
   {
      return (EReference)trafoApplicationEClass.getEStructuralFeatures().get(2);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getTrafoApplication_Tgt()
   {
      return (EReference)trafoApplicationEClass.getEStructuralFeatures().get(3);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public ReachabilityFactory getReachabilityFactory()
   {
      return (ReachabilityFactory)getEFactoryInstance();
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
      reachabilityGraphEClass = createEClass(REACHABILITY_GRAPH);
      createEReference(reachabilityGraphEClass, REACHABILITY_GRAPH__STATES);
      createEReference(reachabilityGraphEClass, REACHABILITY_GRAPH__TRAFO_APPLICATIONS);

      reachableStateEClass = createEClass(REACHABLE_STATE);
      createEAttribute(reachableStateEClass, REACHABLE_STATE__NUMBER);
      createEReference(reachableStateEClass, REACHABLE_STATE__PARENT);
      createEReference(reachableStateEClass, REACHABLE_STATE__ROOT);
      createEReference(reachableStateEClass, REACHABLE_STATE__RESULT_OF);
      createEReference(reachableStateEClass, REACHABLE_STATE__TRAFO_APPLICATIONS);

      trafoApplicationEClass = createEClass(TRAFO_APPLICATION);
      createEAttribute(trafoApplicationEClass, TRAFO_APPLICATION__DESCRIPTION);
      createEReference(trafoApplicationEClass, TRAFO_APPLICATION__PARENT);
      createEReference(trafoApplicationEClass, TRAFO_APPLICATION__SRC);
      createEReference(trafoApplicationEClass, TRAFO_APPLICATION__TGT);
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
      initEClass(reachabilityGraphEClass, ReachabilityGraph.class, "ReachabilityGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getReachabilityGraph_States(), this.getReachableState(), this.getReachableState_Parent(), "states", null, 0, -1, ReachabilityGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getReachabilityGraph_TrafoApplications(), this.getTrafoApplication(), this.getTrafoApplication_Parent(), "trafoApplications", null, 0, -1, ReachabilityGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(reachableStateEClass, ReachableState.class, "ReachableState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEAttribute(getReachableState_Number(), theEcorePackage.getELong(), "number", null, 0, 1, ReachableState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getReachableState_Parent(), this.getReachabilityGraph(), this.getReachabilityGraph_States(), "parent", null, 0, 1, ReachableState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getReachableState_Root(), theEcorePackage.getEObject(), null, "root", null, 0, 1, ReachableState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getReachableState_ResultOf(), this.getTrafoApplication(), this.getTrafoApplication_Tgt(), "resultOf", null, 0, -1, ReachableState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getReachableState_TrafoApplications(), this.getTrafoApplication(), this.getTrafoApplication_Src(), "trafoApplications", null, 0, -1, ReachableState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(trafoApplicationEClass, TrafoApplication.class, "TrafoApplication", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEAttribute(getTrafoApplication_Description(), theEcorePackage.getEString(), "description", null, 0, 1, TrafoApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getTrafoApplication_Parent(), this.getReachabilityGraph(), this.getReachabilityGraph_TrafoApplications(), "parent", null, 0, 1, TrafoApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getTrafoApplication_Src(), this.getReachableState(), this.getReachableState_TrafoApplications(), "src", null, 0, 1, TrafoApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getTrafoApplication_Tgt(), this.getReachableState(), this.getReachableState_ResultOf(), "tgt", null, 0, 1, TrafoApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      // Create resource
      createResource(eNS_URI);
   }

} //ReachabilityPackageImpl
