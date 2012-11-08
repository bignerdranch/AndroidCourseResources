package com.example.testproject;

import android.graphics.PointF;

import android.util.Log;

public class Points {
    private static final String TAG = "Points";

    private int mTranslatePointerId;
    private PointF mTranslateOrigin;
    private PointF mTranslateCurrent;

	public boolean isTranslatePointerId(int pointerId) {
		return mTranslatePointerId == pointerId;
	}

    private float mAngleBase = 0.0f;
	private float mAngleInitial = 0.0f;
    private float mAngleCurrent = 0.0f;

    public Points(int pointerId, PointF translateOrigin) {
        mTranslatePointerId = pointerId;
        mTranslateOrigin = mTranslateCurrent = translateOrigin;
    }

    public PointF getTranslateOrigin() {
		return mTranslateOrigin;
	}

	public PointF getTranslateCurrent() {
		return mTranslateCurrent;
	}

    public PointF getTranslation() {
        return new PointF(mTranslateCurrent.x - mTranslateOrigin.x, 
                mTranslateCurrent.y - mTranslateOrigin.y);
    }

	public void setTranslateCurrent(PointF translateCurrent) {
		mTranslateCurrent = translateCurrent;
	}

	public float getAngleCurrent() {
		return mAngleCurrent;
	}

    public float getRotationAngle() {
        return mAngleBase + mAngleCurrent - mAngleInitial;
    }

    public void setRotateCurrent(PointF rotateCurrent) {
        mAngleCurrent = getElevationAngle(mTranslateCurrent, rotateCurrent);
    }

    public void setRotateInitial(PointF rotateInitial) {
        mAngleBase = getRotationAngle();
        mAngleInitial = mAngleCurrent = getElevationAngle(mTranslateCurrent, rotateInitial);
    }

    private static float getElevationAngle(PointF a, PointF b) {
        PointF vector = new PointF(b.x - a.x, b.y - a.y);

        double result = Math.atan2(vector.y, vector.x);

        Log.i(TAG, "result: " + result);
        return (float)Math.toDegrees(result);
    }
}
