/**
 */
package emfer.examples.ferryman.impl;

import emfer.examples.ferryman.Bank;
import emfer.examples.ferryman.Boat;
import emfer.examples.ferryman.Cargo;
import emfer.examples.ferryman.FerrymanPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boat</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link emfer.examples.ferryman.impl.BoatImpl#getAt <em>At</em>}</li>
 *   <li>{@link emfer.examples.ferryman.impl.BoatImpl#getCargo <em>Cargo</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BoatImpl extends MinimalEObjectImpl.Container implements Boat
{
   /**
    * The cached value of the '{@link #getAt() <em>At</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getAt()
    * @generated
    * @ordered
    */
   protected Bank at;

   /**
    * The cached value of the '{@link #getCargo() <em>Cargo</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getCargo()
    * @generated
    * @ordered
    */
   protected Cargo cargo;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected BoatImpl()
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
      return FerrymanPackage.Literals.BOAT;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Bank getAt()
   {
      if (at != null && at.eIsProxy())
      {
         InternalEObject oldAt = (InternalEObject)at;
         at = (Bank)eResolveProxy(oldAt);
         if (at != oldAt)
         {
            if (eNotificationRequired())
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, FerrymanPackage.BOAT__AT, oldAt, at));
         }
      }
      return at;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Bank basicGetAt()
   {
      return at;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setAt(Bank newAt)
   {
      Bank oldAt = at;
      at = newAt;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, FerrymanPackage.BOAT__AT, oldAt, at));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Cargo getCargo()
   {
      if (cargo != null && cargo.eIsProxy())
      {
         InternalEObject oldCargo = (InternalEObject)cargo;
         cargo = (Cargo)eResolveProxy(oldCargo);
         if (cargo != oldCargo)
         {
            if (eNotificationRequired())
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, FerrymanPackage.BOAT__CARGO, oldCargo, cargo));
         }
      }
      return cargo;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Cargo basicGetCargo()
   {
      return cargo;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setCargo(Cargo newCargo)
   {
      Cargo oldCargo = cargo;
      cargo = newCargo;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, FerrymanPackage.BOAT__CARGO, oldCargo, cargo));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public String toString()
   {
      StringBuilder buf = new StringBuilder();
      buf.append("boat at: ");
      Bank _at = this.getAt();
      boolean _tripleNotEquals = (_at != null);
      if (_tripleNotEquals)
      {
         buf.append(this.getAt().getName()).append(" ");
      }
      buf.append("cargo: ");
      Cargo _cargo = this.getCargo();
      boolean _tripleNotEquals_1 = (_cargo != null);
      if (_tripleNotEquals_1)
      {
         buf.append(this.getCargo().getName());
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
         case FerrymanPackage.BOAT__AT:
            if (resolve) return getAt();
            return basicGetAt();
         case FerrymanPackage.BOAT__CARGO:
            if (resolve) return getCargo();
            return basicGetCargo();
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
         case FerrymanPackage.BOAT__AT:
            setAt((Bank)newValue);
            return;
         case FerrymanPackage.BOAT__CARGO:
            setCargo((Cargo)newValue);
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
         case FerrymanPackage.BOAT__AT:
            setAt((Bank)null);
            return;
         case FerrymanPackage.BOAT__CARGO:
            setCargo((Cargo)null);
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
         case FerrymanPackage.BOAT__AT:
            return at != null;
         case FerrymanPackage.BOAT__CARGO:
            return cargo != null;
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
         case FerrymanPackage.BOAT___TO_STRING:
            return toString();
      }
      return super.eInvoke(operationID, arguments);
   }

} //BoatImpl
