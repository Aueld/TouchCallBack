package com.example.ch01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

// 1.5.1
// 1.5.2
// 1.5.3

public class TouchCallbackView extends View {
    private Paint paint;
    private float cx, cy;
    private boolean check = false;

    public TouchCallbackView(Context context) {
        super(context);
        paint = new Paint();
        cx = 100;
        cy = 100;
    }

    @Override
    public void onDraw(Canvas canvas) {
        if(check)
            canvas.drawCircle(cx, cy, 100, paint);
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("TouchCallbackView:",
                "(" + event.getX() + "," + event.getY() + ")");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("TouchCallbackView:",
                        "화면 누름");
                case MotionEvent.ACTION_MOVE:
                    check = true;

                cx = event.getX();
                cy = event.getY();

                invalidate();
                return true;
            case MotionEvent.ACTION_UP:
                check = false;

                Log.d("TouchCallbackView:",
                        "화면에서 손가락 떼었음");
                invalidate();
                return performClick();
        }
        return super.onTouchEvent(event);
    }
}