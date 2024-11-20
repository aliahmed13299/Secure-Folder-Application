package com.samsung.knox.securefolder;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.samsung.android.sdk.bixby2.provider.CapsuleProvider;
import com.samsung.knox.common.reflection.knox.SettingsWrapper;
import com.samsung.knox.common.util.device.SemSystemPropertiesUtil;
import com.samsung.knox.launcher.AbstractC1092BR;
import com.samsung.knox.securefolder.common.notification.NotificationController;
import com.samsung.knox.securefolder.common.util.MyFilesProviderHelper;
import com.samsung.knox.securefolder.p044di.module.SecureFolderModules;
import com.samsung.knox.securefolder.provisioning.switcher.bixby.BixbyActionHandler;
import com.samsung.knox.securefolder.receiver.SepUnionManager;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import kotlin.Metadata;
import p006a5.C0060a;
import p031c5.C0720a;
import p034c8.InterfaceC0727b;
import p059d8.AbstractC2084l;
import p059d8.AbstractC2095w;
import p095g5.C2569a;
import p124ib.AbstractC2870t;
import p128j3.AbstractC2918f;
import p131j6.C2961a;
import p137k0.AbstractC3046d;
import p147kb.C3149b;
import p175nb.AbstractC3518a;
import p183o7.AbstractC3587b;
import p183o7.C3586a;
import p194p7.AbstractC3655a;
import p203q4.AbstractC3737q;
import p216r7.C3971n;
import p220rb.C4071a;
import p220rb.C4072b;
import p266w.C4477e;
import p290xb.C4621a;
import p296y4.C4681a;
import p301yb.C4729a;
import qa.AbstractC3878v;
import qa.AbstractC3885y;
import qa.InterfaceC3883x;
import sb.InterfaceC4174a;

@Metadata(m3704d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\u000e"}, m3705d2 = {"Lcom/samsung/knox/securefolder/SecureFolderApplication;", "Landroid/app/Application;", "Lsb/a;", "Lr7/n;", "ensureFeatures", "enableDiagMonLogging", "ensureFingerPrintPlus", "createNotificationChannel", "registerSepUnion", "initBixbyActionHandler", "updateMyFilesIconStatus", "onCreate", "<init>", "()V", "SecureFolder_release"}, m3706k = 1, m3707mv = {1, AbstractC1092BR.behaviorViewModel, 0})
/* loaded from: classes.dex */
public final class SecureFolderApplication extends Application implements InterfaceC4174a {
    public SecureFolderApplication() {
        C0720a c0720a = C0720a.f2655B;
        synchronized (c0720a) {
            C4071a c4071a = C0720a.f2656C;
            if (c4071a != null) {
                c4071a.m5280a();
            }
            C0720a.f2656C = null;
        }
        C12101 c12101 = new C12101();
        synchronized (c0720a) {
            C4072b c4072b = new C4072b();
            if (C0720a.f2656C != null) {
                throw new C2569a("A Koin Application has already been started", 5);
            }
            C0720a.f2656C = c4072b.f9124a;
            c12101.invoke((Object) c4072b);
            c4072b.m5283a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createNotificationChannel() {
        ((NotificationController) getKoin().f9119a.f2528d.m1436a(null, AbstractC2095w.m1924a(NotificationController.class), null)).createNotificationChannels();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enableDiagMonLogging() {
        int i2;
        if (((SemSystemPropertiesUtil) getKoin().f9119a.f2528d.m1436a(null, AbstractC2095w.m1924a(SemSystemPropertiesUtil.class), null)).isUserBuild()) {
            Context applicationContext = getApplicationContext();
            AbstractC2918f.m3303c0(applicationContext, "5rwsdnntjy");
            if (AbstractC3587b.f7934e == 3) {
                AbstractC2918f.m3292T0("setDefaultConfiguration can't be used because CustomLogging is using");
            } else if (AbstractC3587b.f7930a != null) {
                AbstractC2918f.m3292T0("setDefaultConfiguration is already set");
            } else {
                try {
                    i2 = applicationContext.getPackageManager().getPackageInfo("com.sec.android.diagmonagent", 0).versionCode;
                } catch (PackageManager.NameNotFoundException unused) {
                    AbstractC2918f.m3267D("DMA Client is not exist");
                    i2 = 0;
                }
                if (i2 == 0) {
                    Log.w(AbstractC3655a.f8221a, "It is not supported : NO_DMA");
                } else {
                    C4477e c4477e = new C4477e(applicationContext);
                    c4477e.f10346d = "5rwsdnntjy";
                    c4477e.f10348f = "D";
                    if (AbstractC3655a.m4431a(applicationContext) == 1) {
                        C2961a c2961a = (C2961a) c4477e.f10351i;
                        String str = (String) c4477e.f10348f;
                        c2961a.f6155l = str;
                        if ("S".equals(str)) {
                            c2961a.f6155l = "Y";
                        }
                        if (((String) c2961a.f6155l).isEmpty()) {
                            Log.w(AbstractC3655a.f8221a, "Empty agreement");
                            c2961a.f6154k = false;
                        } else if ("Y".equals((String) c2961a.f6155l) || "D".equals((String) c2961a.f6155l)) {
                            c2961a.f6154k = true;
                        } else {
                            Log.w(AbstractC3655a.f8221a, "Wrong agreement : " + str);
                            c2961a.f6154k = false;
                        }
                    } else if ("D".equals((String) c4477e.f10348f) || "S".equals((String) c4477e.f10348f)) {
                        c4477e.f10343a = true;
                    } else {
                        c4477e.f10343a = false;
                    }
                    AbstractC3587b.f7930a = c4477e;
                    AbstractC3587b.f7934e = 2;
                    AbstractC2918f.m3262A("setConfiguration type : ".concat(AbstractC3046d.m3577D(2)));
                    AbstractC3587b.m4300h0();
                }
            }
            Context applicationContext2 = getApplicationContext();
            try {
                C4477e c4477e2 = AbstractC3587b.f7930a;
                if (c4477e2 == null) {
                    Log.w(AbstractC3655a.f8221a, "UncaughtExceptionLogging can't be enabled because Configuration is null");
                } else {
                    AbstractC2918f.m3303c0((Context) c4477e2.f10345c, (String) c4477e2.f10346d);
                    if (AbstractC3587b.f7934e == 1) {
                        AbstractC2918f.m3292T0("You first have to call configuration method");
                    } else if (AbstractC3587b.f7933d) {
                        AbstractC2918f.m3292T0("UncaughtExceptionLogging is already enabled");
                    } else {
                        AbstractC3587b.f7933d = true;
                        AbstractC3587b.f7932c = Thread.getDefaultUncaughtExceptionHandler();
                        Thread.setDefaultUncaughtExceptionHandler(new C3586a(applicationContext2, AbstractC3587b.f7932c, AbstractC3587b.f7930a));
                    }
                }
            } catch (Exception e4) {
                AbstractC2918f.m3267D("failed to enableUncaughtExceptionLogging" + e4);
            }
        }
    }

    private final void ensureFeatures() {
        AbstractC3737q.m4619A0((InterfaceC3883x) getKoin().f9119a.f2528d.m1436a(null, AbstractC2095w.m1924a(InterfaceC3883x.class), AbstractC3885y.m5041i0("global")), (AbstractC3878v) getKoin().f9119a.f2528d.m1436a(null, AbstractC2095w.m1924a(AbstractC3878v.class), AbstractC3885y.m5041i0("io")), new SecureFolderApplication$ensureFeatures$1(this, null), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ensureFingerPrintPlus() {
        ((SettingsWrapper) getKoin().f9119a.f2528d.m1436a(null, AbstractC2095w.m1924a(SettingsWrapper.class), null)).getStringForUser("secure_folder_feature_name", 0, "system");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initBixbyActionHandler() {
        if (C4681a.f11130b == null) {
            C4681a.f11130b = new C4681a();
        }
        C4681a c4681a = C4681a.f11130b;
        String packageName = getPackageName();
        c4681a.getClass();
        if (TextUtils.isEmpty(packageName)) {
            throw new IllegalArgumentException("package name is null or empty.");
        }
        Object obj = CapsuleProvider.f3458q;
        synchronized (obj) {
            if (!CapsuleProvider.f3456o) {
                CapsuleProvider.f3456o = true;
                Log.i("CapsuleProvider_1.0.25", "releasing initialize wait lock.");
                obj.notify();
            }
        }
        new Timer().schedule(new C0060a(), 3000L);
        Log.i(C4681a.f11129a, "initialized");
        synchronized (C4681a.class) {
            if (C4681a.f11130b == null) {
                throw new IllegalStateException("The Sbixby instance is NULL. do initialize Sbixby before accessing instance.");
            }
        }
        BixbyActionHandler bixbyActionHandler = new BixbyActionHandler();
        C4681a.m6128a("SecureFolderOn", bixbyActionHandler);
        C4681a.m6128a("SecureFolderOff", bixbyActionHandler);
        C4681a.m6128a("GoToCreateSecureFolder", bixbyActionHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerSepUnion() {
        ((SepUnionManager) getKoin().f9119a.f2528d.m1436a(null, AbstractC2095w.m1924a(SepUnionManager.class), null)).registerPendingIntents();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateMyFilesIconStatus() {
        ((MyFilesProviderHelper) getKoin().f9119a.f2528d.m1436a(null, AbstractC2095w.m1924a(MyFilesProviderHelper.class), null)).updateMyFilesIconStatus();
    }

    @Override // sb.InterfaceC4174a
    public C4071a getKoin() {
        return AbstractC3885y.m5003M();
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        ensureFeatures();
    }

    @Metadata(m3704d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, m3705d2 = {"Lrb/b;", "Lr7/n;", "invoke", "(Lrb/b;)V", "<anonymous>"}, m3706k = 3, m3707mv = {1, AbstractC1092BR.behaviorViewModel, 0})
    /* renamed from: com.samsung.knox.securefolder.SecureFolderApplication$1 */
    /* loaded from: classes.dex */
    public static final class C12101 extends AbstractC2084l implements InterfaceC0727b {
        public C12101() {
            super(1);
        }

        public final void invoke(C4072b c4072b) {
            AbstractC3737q.m4726u("$this$startKoin", c4072b);
            List m4621B0 = AbstractC3737q.m4621B0(AbstractC3518a.f7823a);
            C4071a c4071a = c4072b.f9124a;
            c4071a.m5282c(m4621B0, true);
            SecureFolderApplication secureFolderApplication = SecureFolderApplication.this;
            AbstractC3737q.m4726u("androidContext", secureFolderApplication);
            C4621a c4621a = c4071a.f9123e;
            if (c4621a.m6062b(2) && c4621a.m6062b(2)) {
                C4621a.m6061a(2, "[init] declare Android Context");
            }
            c4071a.m5282c(AbstractC3737q.m4621B0(AbstractC2870t.m3194y(new C3149b(secureFolderApplication, 0))), true);
            List<C4729a> allModule = SecureFolderModules.INSTANCE.getAllModule();
            AbstractC3737q.m4726u("modules", allModule);
            boolean m6062b = c4621a.m6062b(2);
            boolean z6 = c4072b.f9125b;
            if (m6062b) {
                long nanoTime = System.nanoTime();
                c4071a.m5282c(allModule, z6);
                double doubleValue = Double.valueOf((System.nanoTime() - nanoTime) / 1000000.0d).doubleValue();
                String str = "loaded " + ((Map) c4071a.f9120b.f6043l).size() + " definitions in " + doubleValue + " ms";
                c4621a.getClass();
                C4621a.m6061a(2, str);
                return;
            }
            c4071a.m5282c(allModule, z6);
        }

        @Override // p034c8.InterfaceC0727b
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((C4072b) obj);
            return C3971n.f8939a;
        }
    }
}  