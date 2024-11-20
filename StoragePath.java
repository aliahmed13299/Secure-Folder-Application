package com.samsung.knox.securefolder.common.constant;

import com.samsung.knox.launcher.AbstractC1092BR;
import kotlin.Metadata;
import p203q4.AbstractC3737q;
import pa.AbstractC3684l;

@Metadata(m3704d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, m3705d2 = {"Lcom/samsung/knox/securefolder/common/constant/StoragePath;", "", "", "path", "", "isSamsungNote", "<init>", "()V", "securefoldercommon_release"}, m3706k = 1, m3707mv = {1, AbstractC1092BR.behaviorViewModel, 0})
/* loaded from: classes.dex */
public final class StoragePath {
    public static final StoragePath INSTANCE = new StoragePath();

    private StoragePath() {
    }

    public final boolean isSamsungNote(String path) {
        AbstractC3737q.m4726u("path", path);
        if (AbstractC3684l.m4514T0(path, "/data/user", false)) {
            return AbstractC3684l.m4523y0(path, "/com.samsung.android.app.notes/files/share/", false) || AbstractC3684l.m4523y0(path, "/com.samsung.android.app.notes/files/move/", false);
        }
        return false;
    }
}  