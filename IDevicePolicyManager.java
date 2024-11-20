import android.content.ComponentName;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes.dex */
public interface IDevicePolicyManager extends IInterface {

    /* loaded from: classes.dex */
    public static class Default implements IDevicePolicyManager {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.app.admin.IDevicePolicyManager
        public ComponentName getDeviceOwnerComponent(boolean z6) {
            return null;
        }

        @Override // android.app.admin.IDevicePolicyManager
        public List<String> getDisallowedSystemApps(ComponentName componentName, int i2, String str) {
            return null;
        }

        @Override // android.app.admin.IDevicePolicyManager
        public void setActiveAdmin(ComponentName componentName, boolean z6, int i2) {
        }

        @Override // android.app.admin.IDevicePolicyManager
        public boolean setPermittedInputMethods(ComponentName componentName, List list) {
            return false;
        }

        @Override // android.app.admin.IDevicePolicyManager
        public boolean setProfileOwner(ComponentName componentName, String str, int i2) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IDevicePolicyManager {
        public static final String DESCRIPTOR = "android.app.admin.IDevicePolicyManager";
        static final int TRANSACTION_getDeviceOwnerComponent = 1;
        static final int TRANSACTION_getDisallowedSystemApps = 5;
        static final int TRANSACTION_setActiveAdmin = 3;
        static final int TRANSACTION_setPermittedInputMethods = 2;
        static final int TRANSACTION_setProfileOwner = 4;

        /* loaded from: classes.dex */
        public static class Proxy implements IDevicePolicyManager {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.app.admin.IDevicePolicyManager
            public ComponentName getDeviceOwnerComponent(boolean z6) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z6 ? 1 : 0);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return (ComponentName) _Parcel.readTypedObject(obtain2, ComponentName.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.app.admin.IDevicePolicyManager
            public List<String> getDisallowedSystemApps(ComponentName componentName, int i2, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, componentName, 0);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createStringArrayList();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.app.admin.IDevicePolicyManager
            public void setActiveAdmin(ComponentName componentName, boolean z6, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, componentName, 0);
                    obtain.writeInt(z6 ? 1 : 0);
                    obtain.writeInt(i2);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.app.admin.IDevicePolicyManager
            public boolean setPermittedInputMethods(ComponentName componentName, List list) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, componentName, 0);
                    obtain.writeList(list);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.app.admin.IDevicePolicyManager
            public boolean setProfileOwner(ComponentName componentName, String str, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, componentName, 0);
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDevicePolicyManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDevicePolicyManager)) ? new Proxy(iBinder) : (IDevicePolicyManager) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i10) {
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface(DESCRIPTOR);
            }
            if (i2 == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            if (i2 == 1) {
                ComponentName deviceOwnerComponent = getDeviceOwnerComponent(parcel.readInt() != 0);
                parcel2.writeNoException();
                _Parcel.writeTypedObject(parcel2, deviceOwnerComponent, 1);
            } else if (i2 == 2) {
                boolean permittedInputMethods = setPermittedInputMethods((ComponentName) _Parcel.readTypedObject(parcel, ComponentName.CREATOR), parcel.readArrayList(getClass().getClassLoader()));
                parcel2.writeNoException();
                parcel2.writeInt(permittedInputMethods ? 1 : 0);
            } else if (i2 == 3) {
                setActiveAdmin((ComponentName) _Parcel.readTypedObject(parcel, ComponentName.CREATOR), parcel.readInt() != 0, parcel.readInt());
                parcel2.writeNoException();
            } else if (i2 == 4) {
                boolean profileOwner = setProfileOwner((ComponentName) _Parcel.readTypedObject(parcel, ComponentName.CREATOR), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(profileOwner ? 1 : 0);
            } else {
                if (i2 != 5) {
                    return super.onTransact(i2, parcel, parcel2, i10);
                }
                List<String> disallowedSystemApps = getDisallowedSystemApps((ComponentName) _Parcel.readTypedObject(parcel, ComponentName.CREATOR), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeStringList(disallowedSystemApps);
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t6, int i2) {
            if (t6 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t6.writeToParcel(parcel, i2);
            }
        }
    }

    ComponentName getDeviceOwnerComponent(boolean z6);

    List<String> getDisallowedSystemApps(ComponentName componentName, int i2, String str);

    void setActiveAdmin(ComponentName componentName, boolean z6, int i2);

    boolean setPermittedInputMethods(ComponentName componentName, List list);

    boolean setProfileOwner(ComponentName componentName, String str, int i2);
}