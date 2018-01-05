/**
 */
package emfer.reachability;

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
 * @see emfer.reachability.ReachabilityFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel basePackage='emfer'"
 * @generated
 */
public interface ReachabilityPackage extends EPackage
{
   /**
    * The package name.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String eNAME = "reachability";

   /**
    * The package namespace URI.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String eNS_URI = "emfer.reachability";

   /**
    * The package namespace name.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String eNS_PREFIX = "reachability";

   /**
    * The singleton instance of the package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   ReachabilityPackage eINSTANCE = emfer.reachability.impl.ReachabilityPackageImpl.init();

   /**
    * The meta object id for the '{@link emfer.reachability.impl.ReachabilityGraphImpl <em>Graph</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see emfer.reachability.impl.ReachabilityGraphImpl
    * @see emfer.reachability.impl.ReachabilityPackageImpl#getReachabilityGraph()
    * @generated
    */
   int REACHABILITY_GRAPH = 0;

   /**
    * The feature id for the '<em><b>States</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int REACHABILITY_GRAPH__STATES = 0;

   /**
    * The feature id for the '<em><b>Trafo Applications</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int REACHABILITY_GRAPH__TRAFO_APPLICATIONS = 1;

   /**
    * The number of structural features of the '<em>Graph</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int REACHABILITY_GRAPH_FEATURE_COUNT = 2;

   /**
    * The number of operations of the '<em>Graph</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int REACHABILITY_GRAPH_OPERATION_COUNT = 0;

   /**
    * The meta object id for the '{@link emfer.reachability.impl.ReachableStateImpl <em>Reachable State</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see emfer.reachability.impl.ReachableStateImpl
    * @see emfer.reachability.impl.ReachabilityPackageImpl#getReachableState()
    * @generated
    */
   int REACHABLE_STATE = 1;

   /**
    * The feature id for the '<em><b>Number</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int REACHABLE_STATE__NUMBER = 0;

   /**
    * The feature id for the '<em><b>Metric Value</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int REACHABLE_STATE__METRIC_VALUE = 1;

   /**
    * The feature id for the '<em><b>Parent</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int REACHABLE_STATE__PARENT = 2;

   /**
    * The feature id for the '<em><b>Root</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int REACHABLE_STATE__ROOT = 3;

   /**
    * The feature id for the '<em><b>Result Of</b></em>' reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int REACHABLE_STATE__RESULT_OF = 4;

   /**
    * The feature id for the '<em><b>Trafo Applications</b></em>' reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int REACHABLE_STATE__TRAFO_APPLICATIONS = 5;

   /**
    * The number of structural features of the '<em>Reachable State</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int REACHABLE_STATE_FEATURE_COUNT = 6;

   /**
    * The operation id for the '<em>To String</em>' operation.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int REACHABLE_STATE___TO_STRING = 0;

   /**
    * The number of operations of the '<em>Reachable State</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int REACHABLE_STATE_OPERATION_COUNT = 1;

   /**
    * The meta object id for the '{@link emfer.reachability.impl.TrafoApplicationImpl <em>Trafo Application</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see emfer.reachability.impl.TrafoApplicationImpl
    * @see emfer.reachability.impl.ReachabilityPackageImpl#getTrafoApplication()
    * @generated
    */
   int TRAFO_APPLICATION = 2;

   /**
    * The feature id for the '<em><b>Description</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int TRAFO_APPLICATION__DESCRIPTION = 0;

   /**
    * The feature id for the '<em><b>Parent</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int TRAFO_APPLICATION__PARENT = 1;

   /**
    * The feature id for the '<em><b>Src</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int TRAFO_APPLICATION__SRC = 2;

   /**
    * The feature id for the '<em><b>Tgt</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int TRAFO_APPLICATION__TGT = 3;

   /**
    * The number of structural features of the '<em>Trafo Application</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int TRAFO_APPLICATION_FEATURE_COUNT = 4;

   /**
    * The number of operations of the '<em>Trafo Application</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int TRAFO_APPLICATION_OPERATION_COUNT = 0;


   /**
    * Returns the meta object for class '{@link emfer.reachability.ReachabilityGraph <em>Graph</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Graph</em>'.
    * @see emfer.reachability.ReachabilityGraph
    * @generated
    */
   EClass getReachabilityGraph();

   /**
    * Returns the meta object for the containment reference list '{@link emfer.reachability.ReachabilityGraph#getStates <em>States</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>States</em>'.
    * @see emfer.reachability.ReachabilityGraph#getStates()
    * @see #getReachabilityGraph()
    * @generated
    */
   EReference getReachabilityGraph_States();

   /**
    * Returns the meta object for the containment reference list '{@link emfer.reachability.ReachabilityGraph#getTrafoApplications <em>Trafo Applications</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Trafo Applications</em>'.
    * @see emfer.reachability.ReachabilityGraph#getTrafoApplications()
    * @see #getReachabilityGraph()
    * @generated
    */
   EReference getReachabilityGraph_TrafoApplications();

   /**
    * Returns the meta object for class '{@link emfer.reachability.ReachableState <em>Reachable State</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Reachable State</em>'.
    * @see emfer.reachability.ReachableState
    * @generated
    */
   EClass getReachableState();

   /**
    * Returns the meta object for the attribute '{@link emfer.reachability.ReachableState#getNumber <em>Number</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Number</em>'.
    * @see emfer.reachability.ReachableState#getNumber()
    * @see #getReachableState()
    * @generated
    */
   EAttribute getReachableState_Number();

   /**
    * Returns the meta object for the attribute '{@link emfer.reachability.ReachableState#getMetricValue <em>Metric Value</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Metric Value</em>'.
    * @see emfer.reachability.ReachableState#getMetricValue()
    * @see #getReachableState()
    * @generated
    */
   EAttribute getReachableState_MetricValue();

   /**
    * Returns the meta object for the container reference '{@link emfer.reachability.ReachableState#getParent <em>Parent</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the container reference '<em>Parent</em>'.
    * @see emfer.reachability.ReachableState#getParent()
    * @see #getReachableState()
    * @generated
    */
   EReference getReachableState_Parent();

   /**
    * Returns the meta object for the reference '{@link emfer.reachability.ReachableState#getRoot <em>Root</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the reference '<em>Root</em>'.
    * @see emfer.reachability.ReachableState#getRoot()
    * @see #getReachableState()
    * @generated
    */
   EReference getReachableState_Root();

   /**
    * Returns the meta object for the reference list '{@link emfer.reachability.ReachableState#getResultOf <em>Result Of</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the reference list '<em>Result Of</em>'.
    * @see emfer.reachability.ReachableState#getResultOf()
    * @see #getReachableState()
    * @generated
    */
   EReference getReachableState_ResultOf();

   /**
    * Returns the meta object for the reference list '{@link emfer.reachability.ReachableState#getTrafoApplications <em>Trafo Applications</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the reference list '<em>Trafo Applications</em>'.
    * @see emfer.reachability.ReachableState#getTrafoApplications()
    * @see #getReachableState()
    * @generated
    */
   EReference getReachableState_TrafoApplications();

   /**
    * Returns the meta object for the '{@link emfer.reachability.ReachableState#toString() <em>To String</em>}' operation.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the '<em>To String</em>' operation.
    * @see emfer.reachability.ReachableState#toString()
    * @generated
    */
   EOperation getReachableState__ToString();

   /**
    * Returns the meta object for class '{@link emfer.reachability.TrafoApplication <em>Trafo Application</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Trafo Application</em>'.
    * @see emfer.reachability.TrafoApplication
    * @generated
    */
   EClass getTrafoApplication();

   /**
    * Returns the meta object for the attribute '{@link emfer.reachability.TrafoApplication#getDescription <em>Description</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Description</em>'.
    * @see emfer.reachability.TrafoApplication#getDescription()
    * @see #getTrafoApplication()
    * @generated
    */
   EAttribute getTrafoApplication_Description();

   /**
    * Returns the meta object for the container reference '{@link emfer.reachability.TrafoApplication#getParent <em>Parent</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the container reference '<em>Parent</em>'.
    * @see emfer.reachability.TrafoApplication#getParent()
    * @see #getTrafoApplication()
    * @generated
    */
   EReference getTrafoApplication_Parent();

   /**
    * Returns the meta object for the reference '{@link emfer.reachability.TrafoApplication#getSrc <em>Src</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the reference '<em>Src</em>'.
    * @see emfer.reachability.TrafoApplication#getSrc()
    * @see #getTrafoApplication()
    * @generated
    */
   EReference getTrafoApplication_Src();

   /**
    * Returns the meta object for the reference '{@link emfer.reachability.TrafoApplication#getTgt <em>Tgt</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the reference '<em>Tgt</em>'.
    * @see emfer.reachability.TrafoApplication#getTgt()
    * @see #getTrafoApplication()
    * @generated
    */
   EReference getTrafoApplication_Tgt();

   /**
    * Returns the factory that creates the instances of the model.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the factory that creates the instances of the model.
    * @generated
    */
   ReachabilityFactory getReachabilityFactory();

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
       * The meta object literal for the '{@link emfer.reachability.impl.ReachabilityGraphImpl <em>Graph</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see emfer.reachability.impl.ReachabilityGraphImpl
       * @see emfer.reachability.impl.ReachabilityPackageImpl#getReachabilityGraph()
       * @generated
       */
      EClass REACHABILITY_GRAPH = eINSTANCE.getReachabilityGraph();

      /**
       * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference REACHABILITY_GRAPH__STATES = eINSTANCE.getReachabilityGraph_States();

      /**
       * The meta object literal for the '<em><b>Trafo Applications</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference REACHABILITY_GRAPH__TRAFO_APPLICATIONS = eINSTANCE.getReachabilityGraph_TrafoApplications();

      /**
       * The meta object literal for the '{@link emfer.reachability.impl.ReachableStateImpl <em>Reachable State</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see emfer.reachability.impl.ReachableStateImpl
       * @see emfer.reachability.impl.ReachabilityPackageImpl#getReachableState()
       * @generated
       */
      EClass REACHABLE_STATE = eINSTANCE.getReachableState();

      /**
       * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute REACHABLE_STATE__NUMBER = eINSTANCE.getReachableState_Number();

      /**
       * The meta object literal for the '<em><b>Metric Value</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute REACHABLE_STATE__METRIC_VALUE = eINSTANCE.getReachableState_MetricValue();

      /**
       * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference REACHABLE_STATE__PARENT = eINSTANCE.getReachableState_Parent();

      /**
       * The meta object literal for the '<em><b>Root</b></em>' reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference REACHABLE_STATE__ROOT = eINSTANCE.getReachableState_Root();

      /**
       * The meta object literal for the '<em><b>Result Of</b></em>' reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference REACHABLE_STATE__RESULT_OF = eINSTANCE.getReachableState_ResultOf();

      /**
       * The meta object literal for the '<em><b>Trafo Applications</b></em>' reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference REACHABLE_STATE__TRAFO_APPLICATIONS = eINSTANCE.getReachableState_TrafoApplications();

      /**
       * The meta object literal for the '<em><b>To String</b></em>' operation.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EOperation REACHABLE_STATE___TO_STRING = eINSTANCE.getReachableState__ToString();

      /**
       * The meta object literal for the '{@link emfer.reachability.impl.TrafoApplicationImpl <em>Trafo Application</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see emfer.reachability.impl.TrafoApplicationImpl
       * @see emfer.reachability.impl.ReachabilityPackageImpl#getTrafoApplication()
       * @generated
       */
      EClass TRAFO_APPLICATION = eINSTANCE.getTrafoApplication();

      /**
       * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute TRAFO_APPLICATION__DESCRIPTION = eINSTANCE.getTrafoApplication_Description();

      /**
       * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference TRAFO_APPLICATION__PARENT = eINSTANCE.getTrafoApplication_Parent();

      /**
       * The meta object literal for the '<em><b>Src</b></em>' reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference TRAFO_APPLICATION__SRC = eINSTANCE.getTrafoApplication_Src();

      /**
       * The meta object literal for the '<em><b>Tgt</b></em>' reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference TRAFO_APPLICATION__TGT = eINSTANCE.getTrafoApplication_Tgt();

   }

} //ReachabilityPackage
