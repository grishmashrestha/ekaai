package com.lftechnology.ekaai.utils;

import android.widget.TextView;

import com.lftechnology.ekaai.Ekaai;
import com.lftechnology.ekaai.R;

/**
 * A class to auto-resize the font of a {@link TextView} according to the TextView's length
 */
public class AutoResizeFontTextView {

    public static void changeFontSize(CharSequence s, TextView tv) {
        int currentHeight = tv.getHeight();
        float stringLength = s.length();
        float fontSize;
        float density = Ekaai.getContext().getResources().getDisplayMetrics().density;
        if (stringLength <= 6) {
            fontSize = (Ekaai.getContext().getResources().getDimension(R.dimen.text_size_edit_text_default) / density);
        } else if (stringLength <= 7) {
            fontSize = (Ekaai.getContext().getResources().getDimension(R.dimen.text_size_edit_text_length_7) / density);
        } else if (stringLength <= 8) {
            fontSize = (Ekaai.getContext().getResources().getDimension(R.dimen.text_size_edit_text_length_8) / density);
        } else if (stringLength <= 9) {
            fontSize = (Ekaai.getContext().getResources().getDimension(R.dimen.text_size_edit_text_length_9) / density);
        } else if (stringLength <= 10) {
            fontSize = (Ekaai.getContext().getResources().getDimension(R.dimen.text_size_edit_text_length_10) / density);
        } else if (stringLength <= 12) {
            fontSize = (Ekaai.getContext().getResources().getDimension(R.dimen.text_size_edit_text_length_12) / density);
        } else {
            fontSize = (Ekaai.getContext().getResources().getDimension(R.dimen.text_size_edit_text_length_max) / density);
        }
        tv.setTextSize(fontSize);
        tv.setHeight(currentHeight);
    }
}
