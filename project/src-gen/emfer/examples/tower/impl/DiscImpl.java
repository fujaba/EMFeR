/**
 */
package emfer.examples.tower.impl;

import emfer.examples.tower.Disc;
import emfer.examples.tower.TowerPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Disc</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link emfer.examples.tower.impl.DiscImpl#getSize <em>Size</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DiscImpl extends MinimalEObjectImpl.Container implements Disc
{
   /**
    * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getSize()
    * @generated
    * @ordered
    */
   protected static final Integer SIZE_EDEFAULT = null;

   /**
    * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getSize()
    * @generated
    * @ordered
    */
   protected Integer size = SIZE_EDEFAULT;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected DiscImpl()
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
      return TowerPackage.Literals.DISC;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Integer getSize()
   {
      return size;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setSize(Integer newSize)
   {
      Integer oldSize = size;
      size = newSize;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, TowerPackage.DISC__SIZE, oldSize, size));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public String toString()
   {
      StringBuilder buf = new StringBuilder();
      buf.append("disc ").append(this.getSize()).append(" ");
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
         case TowerPackage.DISC__SIZE:
            return getSize();
      }
      return super.eGet(featureID, resolve, coreType);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public void eSet(int featureID, Object newValue)
   {
      switch (featureID)
      {
         case TowerPackage.DISC__SIZE:
            setSize((Integer)newValue);
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
         case TowerPackage.DISC__SIZE:
            setSize(SIZE_EDEFAULT);
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
         case TowerPackage.DISC__SIZE:
            return SIZE_EDEFAULT == null ? size != null : !SIZE_EDEFAULT.equals(size);
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
         case TowerPackage.DISC___TO_STRING:
            return toString();
      }
      return super.eInvoke(operationID, arguments);
   }

} //DiscImpl
