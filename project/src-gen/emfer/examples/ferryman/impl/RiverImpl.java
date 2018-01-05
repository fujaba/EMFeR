/**
 */
package emfer.examples.ferryman.impl;

import emfer.examples.ferryman.Bank;
import emfer.examples.ferryman.Boat;
import emfer.examples.ferryman.FerrymanPackage;
import emfer.examples.ferryman.River;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>River</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link emfer.examples.ferryman.impl.RiverImpl#getBanks <em>Banks</em>}</li>
 *   <li>{@link emfer.examples.ferryman.impl.RiverImpl#getBoat <em>Boat</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RiverImpl extends MinimalEObjectImpl.Container implements River
{
   /**
    * The cached value of the '{@link #getBanks() <em>Banks</em>}' reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getBanks()
    * @generated
    * @ordered
    */
   protected EList<Bank> banks;

   /**
    * The cached value of the '{@link #getBoat() <em>Boat</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getBoat()
    * @generated
    * @ordered
    */
   protected Boat boat;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected RiverImpl()
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
      return FerrymanPackage.Literals.RIVER;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EList<Bank> getBanks()
   {
      if (banks == null)
      {
         banks = new EObjectResolvingEList<Bank>(Bank.class, this, FerrymanPackage.RIVER__BANKS);
      }
      return banks;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Boat getBoat()
   {
      return boat;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain basicSetBoat(Boat newBoat, NotificationChain msgs)
   {
      Boat oldBoat = boat;
      boat = newBoat;
      if (eNotificationRequired())
      {
         ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FerrymanPackage.RIVER__BOAT, oldBoat, newBoat);
         if (msgs == null) msgs = notification; else msgs.add(notification);
      }
      return msgs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setBoat(Boat newBoat)
   {
      if (newBoat != boat)
      {
         NotificationChain msgs = null;
         if (boat != null)
            msgs = ((InternalEObject)boat).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FerrymanPackage.RIVER__BOAT, null, msgs);
         if (newBoat != null)
            msgs = ((InternalEObject)newBoat).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FerrymanPackage.RIVER__BOAT, null, msgs);
         msgs = basicSetBoat(newBoat, msgs);
         if (msgs != null) msgs.dispatch();
      }
      else if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, FerrymanPackage.RIVER__BOAT, newBoat, newBoat));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public String toString()
   {
      StringBuilder buf = new StringBuilder();
      if ((((this.getBanks() != null) && (this.getBanks().size() >= 2)) && (this.getBoat() != null)))
      {
         Bank left = this.getBanks().get(0);
         Bank right = this.getBanks().get(1);
         boolean _equals = left.getName().equals("right");
         if (_equals)
         {
            left = this.getBanks().get(1);
            right = this.getBanks().get(0);
         }
         buf.append(left.toString()).append("\n");
         buf.append(this.getBoat().toString()).append("\n");
         buf.append(right.toString()).append("\n");
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
         case FerrymanPackage.RIVER__BOAT:
            return basicSetBoat(null, msgs);
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
         case FerrymanPackage.RIVER__BANKS:
            return getBanks();
         case FerrymanPackage.RIVER__BOAT:
            return getBoat();
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
         case FerrymanPackage.RIVER__BANKS:
            getBanks().clear();
            getBanks().addAll((Collection<? extends Bank>)newValue);
            return;
         case FerrymanPackage.RIVER__BOAT:
            setBoat((Boat)newValue);
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
         case FerrymanPackage.RIVER__BANKS:
            getBanks().clear();
            return;
         case FerrymanPackage.RIVER__BOAT:
            setBoat((Boat)null);
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
         case FerrymanPackage.RIVER__BANKS:
            return banks != null && !banks.isEmpty();
         case FerrymanPackage.RIVER__BOAT:
            return boat != null;
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
         case FerrymanPackage.RIVER___TO_STRING:
            return toString();
      }
      return super.eInvoke(operationID, arguments);
   }

} //RiverImpl
