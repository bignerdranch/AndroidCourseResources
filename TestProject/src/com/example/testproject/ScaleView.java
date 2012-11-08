package com.example.testproject;

import android.content.Context;

import android.graphics.Canvas;

import android.graphics.drawable.Drawable;

import android.graphics.PointF;

import android.util.AttributeSet;
import android.util.Log;

import android.view.MotionEvent;
import android.view.View;

public class ScaleView extends View {
    private static final String TAG = "ScaleView";

    Drawable image;

    public ScaleView(Context context) {
        this(context, null);
    }

    public ScaleView(Context context, AttributeSet attrs) {
        super(context, attrs);

        image = context.getResources()
            .getDrawable(R.drawable.ic_launcher);
        int height = image.getIntrinsicHeight();
        int width = image.getIntrinsicWidth();
        image.setBounds(-width/2, -height/2, width/2, height/2);
    }

    public void onDraw(Canvas canvas) {
        int x = canvas.getWidth() / 2;
        int y = canvas.getHeight() / 2;
        float rotate = 0;

        canvas.translate(x, y);

        if (touches != null) {
            canvas.rotate(touches.getRotationAngle());
            PointF translation = touches.getTranslation();
            canvas.translate(translation.x, translation.y);
        }

        Log.i(TAG, "rotate: " + rotate);
        image.draw(canvas);
    }

    private Points touches;

    public boolean onTouchEvent(MotionEvent event) {
        int i;
        int pointerId;
        PointF point;

        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN: 
            case MotionEvent.ACTION_POINTER_DOWN:
                i = event.getActionIndex();
                pointerId = event.getPointerId(i);
                point = new PointF(event.getX(i), event.getY(i));

                if (touches == null) {
                    touches = new Points(pointerId, point);
                } else {
                    touches.setRotateInitial(point);
                }

                break;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                i = event.getActionIndex();
                pointerId = event.getPointerId(i);
                point = new PointF(event.getX(i), event.getY(i));

                if (touches != null && touches.isTranslatePointerId(pointerId)) {
                    touches = null;
                }

                break;

            case MotionEvent.ACTION_MOVE:
                for (i = 0; i < event.getPointerCount(); i++) {
                    pointerId = event.getPointerId(i);
                    point = new PointF(event.getX(i), event.getY(i));

                    if (touches == null) {
                    } else if (touches.isTranslatePointerId(pointerId)) {
                        touches.setTranslateCurrent(point);
                    } else {
                        touches.setRotateCurrent(point);
                    }
                }

                break;
        }

        invalidate();

        return true;
    }
}
