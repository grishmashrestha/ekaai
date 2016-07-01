package com.lftechnology.ekaai.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;

import com.lftechnology.ekaai.helper.OnKeyEventsListener;

/**
 * A customized extension of {@link EditText}
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
            ((OnKeyEventsListener) getContext()).keyboardHidden();
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
            ((OnKeyEventsListener) getContext()).keyboardHidden();
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
