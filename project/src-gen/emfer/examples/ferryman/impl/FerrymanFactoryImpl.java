/**
 */
package emfer.examples.ferryman.impl;

import emfer.examples.ferryman.*;

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
public class FerrymanFactoryImpl extends EFactoryImpl implements FerrymanFactory
{
   /**
    * Creates the default factory implementation.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static FerrymanFactory init()
   {
      try
      {
         FerrymanFactory theFerrymanFactory = (FerrymanFactory)EPackage.Registry.INSTANCE.getEFactory(FerrymanPackage.eNS_URI);
         if (theFerrymanFactory != null)
         {
            return theFerrymanFactory;
         }
      }
      catch (Exception exception)
      {
         EcorePlugin.INSTANCE.log(exception);
      }
      return new FerrymanFactoryImpl();
   }

   /**
    * Creates an instance of the factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public FerrymanFactoryImpl()
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
         case FerrymanPackage.RIVER: return createRiver();
         case FerrymanPackage.BANK: return createBank();
         case FerrymanPackage.BOAT: return createBoat();
         case FerrymanPackage.CARGO: return createCargo();
         default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
      }
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public River createRiver()
   {
      RiverImpl river = new RiverImpl();
      return river;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Bank createBank()
   {
      BankImpl bank = new BankImpl();
      return bank;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Boat createBoat()
   {
      BoatImpl boat = new BoatImpl();
      return boat;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Cargo createCargo()
   {
      CargoImpl cargo = new CargoImpl();
      return cargo;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public FerrymanPackage getFerrymanPackage()
   {
      return (FerrymanPackage)getEPackage();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @deprecated
    * @generated
    */
   @Deprecated
   public static FerrymanPackage getPackage()
   {
      return FerrymanPackage.eINSTANCE;
   }

} //FerrymanFactoryImpl
