/**
 */
package emfer.examples.ferryman.impl;

import emfer.examples.ferryman.Bank;
import emfer.examples.ferryman.Cargo;
import emfer.examples.ferryman.FerrymanPackage;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bank</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link emfer.examples.ferryman.impl.BankImpl#getName <em>Name</em>}</li>
 *   <li>{@link emfer.examples.ferryman.impl.BankImpl#getCargos <em>Cargos</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BankImpl extends MinimalEObjectImpl.Container implements Bank
{
   /**
    * The default value of the '{@link #getName() <em>Name</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getName()
    * @generated
    * @ordered
    */
   protected static final String NAME_EDEFAULT = null;

   /**
    * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getName()
    * @generated
    * @ordered
    */
   protected String name = NAME_EDEFAULT;

   /**
    * The cached value of the '{@link #getCargos() <em>Cargos</em>}' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getCargos()
    * @generated
    * @ordered
    */
   protected EList<Cargo> cargos;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected BankImpl()
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
      return FerrymanPackage.Literals.BANK;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public String getName()
   {
      return name;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setName(String newName)
   {
      String oldName = name;
      name = newName;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, FerrymanPackage.BANK__NAME, oldName, name));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EList<Cargo> getCargos()
   {
      if (cargos == null)
      {
         cargos = new EObjectContainmentEList<Cargo>(Cargo.class, this, FerrymanPackage.BANK__CARGOS);
      }
      return cargos;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public String toString()
   {
      StringBuilder buf = new StringBuilder();
      buf.append(this.getName()).append(": ");
      EList<Cargo> _cargos = this.getCargos();
      for (final Cargo c : _cargos)
      {
         buf.append(c.getName()).append(" ");
      }
      return buf.toString();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
   {
      switch (featureID)
      {
         case FerrymanPackage.BANK__CARGOS:
            return ((InternalEList<?>)getCargos()).basicRemove(otherEnd, msgs);
      }
      return super.eInverseRemove(otherEnd, featureID, msgs);
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
         case FerrymanPackage.BANK__NAME:
            return getName();
         case FerrymanPackage.BANK__CARGOS:
            return getCargos();
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
         case FerrymanPackage.BANK__NAME:
            setName((String)newValue);
            return;
         case FerrymanPackage.BANK__CARGOS:
            getCargos().clear();
            getCargos().addAll((Collection<? extends Cargo>)newValue);
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
         case FerrymanPackage.BANK__NAME:
            setName(NAME_EDEFAULT);
            return;
         case FerrymanPackage.BANK__CARGOS:
            getCargos().clear();
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
         case FerrymanPackage.BANK__NAME:
            return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
         case FerrymanPackage.BANK__CARGOS:
            return cargos != null && !cargos.isEmpty();
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
         case FerrymanPackage.BANK___TO_STRING:
            return toString();
      }
      return super.eInvoke(operationID, arguments);
   }

} //BankImpl
