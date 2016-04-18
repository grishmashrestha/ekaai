package com.lftechnology.NaapTol.utils;

import android.widget.TextView;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 3/4/16.
 */
public class AutoResizeFontTextView {

    public static void changeFontSize(CharSequence s, TextView tv) {
        int currentHeight = tv.getHeight();
        float stringLength = s.length();
        float fontSize;
        if (stringLength <= 6) {
            fontSize = 100;
        } else if (stringLength <= 7) {
            fontSize = 90;
        } else if (stringLength <= 8) {
            fontSize = 80;
        } else if (stringLength <= 9) {
            fontSize = 70;
        } else if (stringLength <= 10) {
            fontSize = 60;
        } else if (stringLength <= 12) {
            fontSize = 50;
        } else {
            fontSize = 40;
        }
        tv.setTextSize(fontSize);
        tv.setHeight(currentHeight);
    }
}
