package com.example.ch01;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

import androidx.core.content.res.ResourcesCompat;

public class ImageDisplay extends View {
    private Bitmap bitmap;
    private Rect src, dst;

    public ImageDisplay(Context context) {
        super(context);
        Resources res = getResources();
        BitmapDrawable drawable = (BitmapDrawable) ResourcesCompat.getDrawable(res, R.drawable.image, null);
        bitmap = drawable.getBitmap();
        src = new Rect();
        dst = new Rect();
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawBitmap(bitmap, 0, 0, null);

        int w = bitmap.getWidth();
        int h = bitmap.getHeight();

        src.set(w / 2, h / 2, w, h);
        dst.set(w, h / 2, w + w / 2, h);
        canvas.drawBitmap(bitmap, src, dst, null);

        // 연습문제 1.4.1

        src.set(w / 2, h / 2, w, h);
        dst.set(w / 2, h, w, h + h / 2);
        canvas.drawBitmap(bitmap, src, dst, null);

        src.set(0, h / 2, w / 2, h);
        dst.set(0, h / 2 + h, w / 2, h * 2);
        canvas.drawBitmap(bitmap, src, dst, null);
    }
}