/**
 */
package emfer.examples.tower.impl;

import emfer.examples.tower.Disc;
import emfer.examples.tower.Stack;
import emfer.examples.tower.TowerPackage;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stack</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link emfer.examples.tower.impl.StackImpl#getPosition <em>Position</em>}</li>
 *   <li>{@link emfer.examples.tower.impl.StackImpl#getDiscs <em>Discs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StackImpl extends MinimalEObjectImpl.Container implements Stack
{
   /**
    * The default value of the '{@link #getPosition() <em>Position</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getPosition()
    * @generated
    * @ordered
    */
   protected static final String POSITION_EDEFAULT = null;

   /**
    * The cached value of the '{@link #getPosition() <em>Position</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getPosition()
    * @generated
    * @ordered
    */
   protected String position = POSITION_EDEFAULT;

   /**
    * The cached value of the '{@link #getDiscs() <em>Discs</em>}' reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getDiscs()
    * @generated
    * @ordered
    */
   protected EList<Disc> discs;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected StackImpl()
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
      return TowerPackage.Literals.STACK;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public String getPosition()
   {
      return position;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setPosition(String newPosition)
   {
      String oldPosition = position;
      position = newPosition;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, TowerPackage.STACK__POSITION, oldPosition, position));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EList<Disc> getDiscs()
   {
      if (discs == null)
      {
         discs = new EObjectResolvingEList<Disc>(Disc.class, this, TowerPackage.STACK__DISCS);
      }
      return discs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public String toString()
   {
      StringBuilder buf = new StringBuilder();
      buf.append("stack ").append(this.getPosition()).append(": ");
      EList<Disc> _discs = this.getDiscs();
      for (final Disc d : _discs)
      {
         buf.append(d.toString());
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
         case TowerPackage.STACK__POSITION:
            return getPosition();
         case TowerPackage.STACK__DISCS:
            return getDiscs();
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
         case TowerPackage.STACK__POSITION:
            setPosition((String)newValue);
            return;
         case TowerPackage.STACK__DISCS:
            getDiscs().clear();
            getDiscs().addAll((Collection<? extends Disc>)newValue);
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
         case TowerPackage.STACK__POSITION:
            setPosition(POSITION_EDEFAULT);
            return;
         case TowerPackage.STACK__DISCS:
            getDiscs().clear();
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
         case TowerPackage.STACK__POSITION:
            return POSITION_EDEFAULT == null ? position != null : !POSITION_EDEFAULT.equals(position);
         case TowerPackage.STACK__DISCS:
            return discs != null && !discs.isEmpty();
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
         case TowerPackage.STACK___TO_STRING:
            return toString();
      }
      return super.eInvoke(operationID, arguments);
   }

} //StackImpl
