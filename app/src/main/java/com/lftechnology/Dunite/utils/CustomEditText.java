package com.lftechnology.Dunite.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 4/1/16.
 */
public class CustomEditText extends EditText {
    public CustomEditText(Context context) {
        super(context);
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        // when back key is pressed
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (getText().toString().equals("")) {
                setText("1");
            }
            ((OnKeyEvents) getContext()).keyboardHidden();
            return false;
        }
        return super.dispatchKeyEvent(event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        // when done key is pressed
        if (keyCode == 66) {
            if (getText().toString().equals("")) {
                setText("1");
            }
            ((OnKeyEvents) getContext()).keyboardHidden();
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    protected void onSelectionChanged(int selStart, int selEnd) {
        CharSequence text = getText();
        if (text != null) {
            if (selStart != selEnd) {
                setSelection(text.length(), text.length());
                return;
            }
        }
        super.onSelectionChanged(selStart, selEnd);
    }
}
