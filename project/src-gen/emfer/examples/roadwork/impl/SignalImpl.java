/**
 */
package emfer.examples.roadwork.impl;

import emfer.examples.roadwork.RoadworkPackage;
import emfer.examples.roadwork.Signal;
import emfer.examples.roadwork.Track;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Signal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link emfer.examples.roadwork.impl.SignalImpl#isPass <em>Pass</em>}</li>
 *   <li>{@link emfer.examples.roadwork.impl.SignalImpl#getTrack <em>Track</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SignalImpl extends MinimalEObjectImpl.Container implements Signal
{
   /**
    * The default value of the '{@link #isPass() <em>Pass</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isPass()
    * @generated
    * @ordered
    */
   protected static final boolean PASS_EDEFAULT = false;

   /**
    * The cached value of the '{@link #isPass() <em>Pass</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isPass()
    * @generated
    * @ordered
    */
   protected boolean pass = PASS_EDEFAULT;

   /**
    * The cached value of the '{@link #getTrack() <em>Track</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getTrack()
    * @generated
    * @ordered
    */
   protected Track track;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected SignalImpl()
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
      return RoadworkPackage.Literals.SIGNAL;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean isPass()
   {
      return pass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setPass(boolean newPass)
   {
      boolean oldPass = pass;
      pass = newPass;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, RoadworkPackage.SIGNAL__PASS, oldPass, pass));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Track getTrack()
   {
      if (track != null && track.eIsProxy())
      {
         InternalEObject oldTrack = (InternalEObject)track;
         track = (Track)eResolveProxy(oldTrack);
         if (track != oldTrack)
         {
            if (eNotificationRequired())
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, RoadworkPackage.SIGNAL__TRACK, oldTrack, track));
         }
      }
      return track;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Track basicGetTrack()
   {
      return track;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setTrack(Track newTrack)
   {
      Track oldTrack = track;
      track = newTrack;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, RoadworkPackage.SIGNAL__TRACK, oldTrack, track));
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
         case RoadworkPackage.SIGNAL__PASS:
            return isPass();
         case RoadworkPackage.SIGNAL__TRACK:
            if (resolve) return getTrack();
            return basicGetTrack();
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
         case RoadworkPackage.SIGNAL__PASS:
            setPass((Boolean)newValue);
            return;
         case RoadworkPackage.SIGNAL__TRACK:
            setTrack((Track)newValue);
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
         case RoadworkPackage.SIGNAL__PASS:
            setPass(PASS_EDEFAULT);
            return;
         case RoadworkPackage.SIGNAL__TRACK:
            setTrack((Track)null);
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
         case RoadworkPackage.SIGNAL__PASS:
            return pass != PASS_EDEFAULT;
         case RoadworkPackage.SIGNAL__TRACK:
            return track != null;
      }
      return super.eIsSet(featureID);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public String toString()
   {
      if (eIsProxy()) return super.toString();

      StringBuffer result = new StringBuffer(super.toString());
      result.append(" (pass: ");
      result.append(pass);
      result.append(')');
      return result.toString();
   }

} //SignalImpl
