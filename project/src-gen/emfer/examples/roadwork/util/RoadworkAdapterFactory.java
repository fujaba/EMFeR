/**
 */
package emfer.examples.roadwork.util;

import emfer.examples.roadwork.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see emfer.examples.roadwork.RoadworkPackage
 * @generated
 */
public class RoadworkAdapterFactory extends AdapterFactoryImpl
{
   /**
    * The cached model package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected static RoadworkPackage modelPackage;

   /**
    * Creates an instance of the adapter factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public RoadworkAdapterFactory()
   {
      if (modelPackage == null)
      {
         modelPackage = RoadworkPackage.eINSTANCE;
      }
   }

   /**
    * Returns whether this factory is applicable for the type of the object.
    * <!-- begin-user-doc -->
    * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
    * <!-- end-user-doc -->
    * @return whether this factory is applicable for the type of the object.
    * @generated
    */
   @Override
   public boolean isFactoryForType(Object object)
   {
      if (object == modelPackage)
      {
         return true;
      }
      if (object instanceof EObject)
      {
         return ((EObject)object).eClass().getEPackage() == modelPackage;
      }
      return false;
   }

   /**
    * The switch that delegates to the <code>createXXX</code> methods.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected RoadworkSwitch<Adapter> modelSwitch =
      new RoadworkSwitch<Adapter>()
      {
         @Override
         public Adapter caseRoadMap(RoadMap object)
         {
            return createRoadMapAdapter();
         }
         @Override
         public Adapter caseRoad(Road object)
         {
            return createRoadAdapter();
         }
         @Override
         public Adapter caseTrack(Track object)
         {
            return createTrackAdapter();
         }
         @Override
         public Adapter caseSignal(Signal object)
         {
            return createSignalAdapter();
         }
         @Override
         public Adapter caseCar(Car object)
         {
            return createCarAdapter();
         }
         @Override
         public Adapter defaultCase(EObject object)
         {
            return createEObjectAdapter();
         }
      };

   /**
    * Creates an adapter for the <code>target</code>.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param target the object to adapt.
    * @return the adapter for the <code>target</code>.
    * @generated
    */
   @Override
   public Adapter createAdapter(Notifier target)
   {
      return modelSwitch.doSwitch((EObject)target);
   }


   /**
    * Creates a new adapter for an object of class '{@link emfer.examples.roadwork.RoadMap <em>Road Map</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see emfer.examples.roadwork.RoadMap
    * @generated
    */
   public Adapter createRoadMapAdapter()
   {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link emfer.examples.roadwork.Road <em>Road</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see emfer.examples.roadwork.Road
    * @generated
    */
   public Adapter createRoadAdapter()
   {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link emfer.examples.roadwork.Track <em>Track</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see emfer.examples.roadwork.Track
    * @generated
    */
   public Adapter createTrackAdapter()
   {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link emfer.examples.roadwork.Signal <em>Signal</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see emfer.examples.roadwork.Signal
    * @generated
    */
   public Adapter createSignalAdapter()
   {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link emfer.examples.roadwork.Car <em>Car</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see emfer.examples.roadwork.Car
    * @generated
    */
   public Adapter createCarAdapter()
   {
      return null;
   }

   /**
    * Creates a new adapter for the default case.
    * <!-- begin-user-doc -->
    * This default implementation returns null.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @generated
    */
   public Adapter createEObjectAdapter()
   {
      return null;
   }

} //RoadworkAdapterFactory
