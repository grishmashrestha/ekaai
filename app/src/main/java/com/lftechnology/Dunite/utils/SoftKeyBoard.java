package com.lftechnology.Dunite.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 3/14/16.
 */
public class SoftKeyBoard {
    public static void hideSoftKeyboard(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager.isAcceptingText()) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            ((OnKeyEvents) context).keyboardHidden();
        }
    }
}
