/**
 */
package emfer.reachability.impl;

import emfer.reachability.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ReachabilityFactoryImpl extends EFactoryImpl implements ReachabilityFactory
{
   /**
    * Creates the default factory implementation.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static ReachabilityFactory init()
   {
      try
      {
         ReachabilityFactory theReachabilityFactory = (ReachabilityFactory)EPackage.Registry.INSTANCE.getEFactory(ReachabilityPackage.eNS_URI);
         if (theReachabilityFactory != null)
         {
            return theReachabilityFactory;
         }
      }
      catch (Exception exception)
      {
         EcorePlugin.INSTANCE.log(exception);
      }
      return new ReachabilityFactoryImpl();
   }

   /**
    * Creates an instance of the factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public ReachabilityFactoryImpl()
   {
      super();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public EObject create(EClass eClass)
   {
      switch (eClass.getClassifierID())
      {
         case ReachabilityPackage.REACHABILITY_GRAPH: return createReachabilityGraph();
         case ReachabilityPackage.REACHABLE_STATE: return createReachableState();
         case ReachabilityPackage.TRAFO_APPLICATION: return createTrafoApplication();
         default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
      }
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public ReachabilityGraph createReachabilityGraph()
   {
      ReachabilityGraphImpl reachabilityGraph = new ReachabilityGraphImpl();
      return reachabilityGraph;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public ReachableState createReachableState()
   {
      ReachableStateImpl reachableState = new ReachableStateImpl();
      return reachableState;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public TrafoApplication createTrafoApplication()
   {
      TrafoApplicationImpl trafoApplication = new TrafoApplicationImpl();
      return trafoApplication;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public ReachabilityPackage getReachabilityPackage()
   {
      return (ReachabilityPackage)getEPackage();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @deprecated
    * @generated
    */
   @Deprecated
   public static ReachabilityPackage getPackage()
   {
      return ReachabilityPackage.eINSTANCE;
   }

} //ReachabilityFactoryImpl
