/**
 */
package emfer.examples.tower.impl;

import emfer.examples.tower.*;

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
public class TowerFactoryImpl extends EFactoryImpl implements TowerFactory
{
   /**
    * Creates the default factory implementation.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static TowerFactory init()
   {
      try
      {
         TowerFactory theTowerFactory = (TowerFactory)EPackage.Registry.INSTANCE.getEFactory(TowerPackage.eNS_URI);
         if (theTowerFactory != null)
         {
            return theTowerFactory;
         }
      }
      catch (Exception exception)
      {
         EcorePlugin.INSTANCE.log(exception);
      }
      return new TowerFactoryImpl();
   }

   /**
    * Creates an instance of the factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public TowerFactoryImpl()
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
         case TowerPackage.BOARD: return createBoard();
         case TowerPackage.STACK: return createStack();
         case TowerPackage.DISC: return createDisc();
         default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
      }
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Board createBoard()
   {
      BoardImpl board = new BoardImpl();
      return board;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Stack createStack()
   {
      StackImpl stack = new StackImpl();
      return stack;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Disc createDisc()
   {
      DiscImpl disc = new DiscImpl();
      return disc;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public TowerPackage getTowerPackage()
   {
      return (TowerPackage)getEPackage();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @deprecated
    * @generated
    */
   @Deprecated
   public static TowerPackage getPackage()
   {
      return TowerPackage.eINSTANCE;
   }

} //TowerFactoryImpl
