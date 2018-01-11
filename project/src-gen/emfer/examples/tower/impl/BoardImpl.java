/**
 */
package emfer.examples.tower.impl;

import emfer.examples.tower.Board;
import emfer.examples.tower.Stack;
import emfer.examples.tower.TowerPackage;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Board</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link emfer.examples.tower.impl.BoardImpl#getStacks <em>Stacks</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BoardImpl extends MinimalEObjectImpl.Container implements Board
{
   /**
    * The cached value of the '{@link #getStacks() <em>Stacks</em>}' reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getStacks()
    * @generated
    * @ordered
    */
   protected EList<Stack> stacks;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected BoardImpl()
   {
      super();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   protected EClass eStaticClass()
   {
      return TowerPackage.Literals.BOARD;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EList<Stack> getStacks()
   {
      if (stacks == null)
      {
         stacks = new EObjectResolvingEList<Stack>(Stack.class, this, TowerPackage.BOARD__STACKS);
      }
      return stacks;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public String toString()
   {
      StringBuilder buf = new StringBuilder();
      EList<Stack> _stacks = this.getStacks();
      for (final Stack s : _stacks)
      {
         buf.append(s.toString());
      }
      return buf.toString();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Object eGet(int featureID, boolean resolve, boolean coreType)
   {
      switch (featureID)
      {
         case TowerPackage.BOARD__STACKS:
            return getStacks();
      }
      return super.eGet(featureID, resolve, coreType);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @SuppressWarnings("unchecked")
   @Override
   public void eSet(int featureID, Object newValue)
   {
      switch (featureID)
      {
         case TowerPackage.BOARD__STACKS:
            getStacks().clear();
            getStacks().addAll((Collection<? extends Stack>)newValue);
            return;
      }
      super.eSet(featureID, newValue);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public void eUnset(int featureID)
   {
      switch (featureID)
      {
         case TowerPackage.BOARD__STACKS:
            getStacks().clear();
            return;
      }
      super.eUnset(featureID);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public boolean eIsSet(int featureID)
   {
      switch (featureID)
      {
         case TowerPackage.BOARD__STACKS:
            return stacks != null && !stacks.isEmpty();
      }
      return super.eIsSet(featureID);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
   {
      switch (operationID)
      {
         case TowerPackage.BOARD___TO_STRING:
            return toString();
      }
      return super.eInvoke(operationID, arguments);
   }

} //BoardImpl
