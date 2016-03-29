package com.lftechnology.unito.helper;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.lftechnology.unito.bus.EventBus;
import com.lftechnology.unito.bus.FlingListener;
import com.lftechnology.unito.bus.ScrollListener;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 3/28/16.
 */
public class GestureListener extends GestureDetector.SimpleOnGestureListener {

    public static final String TAG = "GestureListener";

    // BEGIN_INCLUDE(init_gestureListener)

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                            float distanceY) {
        // User attempted to scroll
        if (e1.getY() > e2.getY()) {
            EventBus.post(new ScrollListener(true, distanceX, distanceY));
        } else {
            EventBus.post(new ScrollListener(false, distanceX, distanceY));
        }
        return false;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                           float velocityY) {
        // Fling event occurred.  Notification of this one happens after an "up" event.
        if (e1.getY() > e2.getY()) {
            EventBus.post(new FlingListener(true));
        } else {
            EventBus.post(new FlingListener(false));
        }
        return false;
    }


    /**
     * Returns a human-readable string describing the type of touch that triggered a MotionEvent.
     */

    private static String getTouchType(MotionEvent e) {

        String touchTypeDescription = " ";
        int touchType = e.getToolType(0);

        switch (touchType) {
            case MotionEvent.TOOL_TYPE_FINGER:
                touchTypeDescription += "(finger)";
                break;
            case MotionEvent.TOOL_TYPE_STYLUS:
                touchTypeDescription += "(stylus, ";
                //Get some additional information about the stylus touch
                float stylusPressure = e.getPressure();
                touchTypeDescription += "pressure: " + stylusPressure;

                if (Build.VERSION.SDK_INT >= 21) {
                    touchTypeDescription += ", buttons pressed: " + getButtonsPressed(e);
                }

                touchTypeDescription += ")";
                break;
            case MotionEvent.TOOL_TYPE_ERASER:
                touchTypeDescription += "(eraser)";
                break;
            case MotionEvent.TOOL_TYPE_MOUSE:
                touchTypeDescription += "(mouse)";
                break;
            default:
                touchTypeDescription += "(unknown tool)";
                break;
        }

        return touchTypeDescription;
    }

    /**
     * Returns a human-readable string listing all the stylus buttons that were pressed when the
     * input MotionEvent occurred.
     */
    @TargetApi(21)
    private static String getButtonsPressed(MotionEvent e) {
        String buttons = "";

        if (e.isButtonPressed(MotionEvent.BUTTON_PRIMARY)) {
            buttons += " primary";
        }

        if (e.isButtonPressed(MotionEvent.BUTTON_SECONDARY)) {
            buttons += " secondary";
        }

        if (e.isButtonPressed(MotionEvent.BUTTON_TERTIARY)) {
            buttons += " tertiary";
        }

        if (e.isButtonPressed(MotionEvent.BUTTON_BACK)) {
            buttons += " back";
        }

        if (e.isButtonPressed(MotionEvent.BUTTON_FORWARD)) {
            buttons += " forward";
        }

        if (buttons.equals("")) {
            buttons = "none";
        }

        return buttons;
    }

}