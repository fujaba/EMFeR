/**
 */
package emfer.examples.ferryman.util;

import emfer.examples.ferryman.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see emfer.examples.ferryman.FerrymanPackage
 * @generated
 */
public class FerrymanAdapterFactory extends AdapterFactoryImpl
{
   /**
    * The cached model package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected static FerrymanPackage modelPackage;

   /**
    * Creates an instance of the adapter factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public FerrymanAdapterFactory()
   {
      if (modelPackage == null)
      {
         modelPackage = FerrymanPackage.eINSTANCE;
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
   protected FerrymanSwitch<Adapter> modelSwitch =
      new FerrymanSwitch<Adapter>()
      {
         @Override
         public Adapter caseRiver(River object)
         {
            return createRiverAdapter();
         }
         @Override
         public Adapter caseBank(Bank object)
         {
            return createBankAdapter();
         }
         @Override
         public Adapter caseBoat(Boat object)
         {
            return createBoatAdapter();
         }
         @Override
         public Adapter caseCargo(Cargo object)
         {
            return createCargoAdapter();
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
    * Creates a new adapter for an object of class '{@link emfer.examples.ferryman.River <em>River</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see emfer.examples.ferryman.River
    * @generated
    */
   public Adapter createRiverAdapter()
   {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link emfer.examples.ferryman.Bank <em>Bank</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see emfer.examples.ferryman.Bank
    * @generated
    */
   public Adapter createBankAdapter()
   {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link emfer.examples.ferryman.Boat <em>Boat</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see emfer.examples.ferryman.Boat
    * @generated
    */
   public Adapter createBoatAdapter()
   {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link emfer.examples.ferryman.Cargo <em>Cargo</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see emfer.examples.ferryman.Cargo
    * @generated
    */
   public Adapter createCargoAdapter()
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

} //FerrymanAdapterFactory
