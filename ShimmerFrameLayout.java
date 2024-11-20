package com.facebook.shimmer;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import p180o3.AbstractC3548a;
import p180o3.C3549b;
import p180o3.C3550c;
import p180o3.C3552e;

/* loaded from: classes.dex */
public class ShimmerFrameLayout extends FrameLayout {

    /* renamed from: j */
    public final Paint f2867j;

    /* renamed from: k */
    public final C3552e f2868k;

    /* renamed from: l */
    public final boolean f2869l;

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2867j = new Paint();
        C3552e c3552e = new C3552e();
        this.f2868k = c3552e;
        this.f2869l = true;
        setWillNotDraw(false);
        c3552e.setCallback(this);
        if (attributeSet == null) {
            m1439a(new C3549b(0).m3721a());
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3548a.f7866a, 0, 0);
        try {
            m1439a(((obtainStyledAttributes.hasValue(4) && obtainStyledAttributes.getBoolean(4, false)) ? new C3549b(1) : new C3549b(0)).mo3722b(obtainStyledAttributes).m3721a());
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: a */
    public final void m1439a(C3550c c3550c) {
        boolean z6;
        C3552e c3552e = this.f2868k;
        c3552e.f7895f = c3550c;
        if (c3550c != null) {
            c3552e.f7891b.setXfermode(new PorterDuffXfermode(c3552e.f7895f.f7883p ? PorterDuff.Mode.DST_IN : PorterDuff.Mode.SRC_IN));
        }
        c3552e.m4217b();
        if (c3552e.f7895f != null) {
            ValueAnimator valueAnimator = c3552e.f7894e;
            if (valueAnimator != null) {
                z6 = valueAnimator.isStarted();
                c3552e.f7894e.cancel();
                c3552e.f7894e.removeAllUpdateListeners();
            } else {
                z6 = false;
            }
            C3550c c3550c2 = c3552e.f7895f;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, ((float) (c3550c2.f7887t / c3550c2.f7886s)) + 1.0f);
            c3552e.f7894e = ofFloat;
            ofFloat.setRepeatMode(c3552e.f7895f.f7885r);
            c3552e.f7894e.setRepeatCount(c3552e.f7895f.f7884q);
            ValueAnimator valueAnimator2 = c3552e.f7894e;
            C3550c c3550c3 = c3552e.f7895f;
            valueAnimator2.setDuration(c3550c3.f7886s + c3550c3.f7887t);
            c3552e.f7894e.addUpdateListener(c3552e.f7890a);
            if (z6) {
                c3552e.f7894e.start();
            }
        }
        c3552e.invalidateSelf();
        if (c3550c == null || !c3550c.f7881n) {
            setLayerType(0, null);
        } else {
            setLayerType(2, this.f2867j);
        }
    }

    /* renamed from: b */
    public final void m1440b() {
        C3552e c3552e = this.f2868k;
        ValueAnimator valueAnimator = c3552e.f7894e;
        if (valueAnimator != null) {
            if (valueAnimator != null && valueAnimator.isStarted()) {
                c3552e.f7894e.cancel();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f2869l) {
            this.f2868k.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2868k.m4216a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m1440b();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z6, int i2, int i10, int i11, int i12) {
        super.onLayout(z6, i2, i10, i11, i12);
        this.f2868k.setBounds(0, 0, getWidth(), getHeight());
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2868k;
    }
}