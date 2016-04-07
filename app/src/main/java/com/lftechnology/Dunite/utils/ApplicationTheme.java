package com.lftechnology.Dunite.utils;

import com.lftechnology.Dunite.Dunite;
import com.lftechnology.Dunite.R;
import com.lftechnology.Dunite.constant.AppConstant;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 4/7/16.
 */
public class ApplicationTheme {
    public static Integer[] getThemeDetails(String selectedConversion) {
        Integer[] themeSet = new Integer[3];
        switch (selectedConversion) {
            case AppConstant.LENGTH:
                themeSet[0] = Dunite.getContext().getResources().getStringArray(R.array.length_options).length;
                themeSet[1] = R.color.colorLengthLight;
                themeSet[2] = R.drawable.swap_btn_cont_blue;
                break;
            case AppConstant.TEMPERATURE:
                themeSet[0] = Dunite.getContext().getResources().getStringArray(R.array.temperature_options).length;
                themeSet[1] = R.color.colorTemperatureLight;
                themeSet[2] = R.drawable.swap_btn_cont_red;
                break;
            case AppConstant.TIME:
                themeSet[0] = Dunite.getContext().getResources().getStringArray(R.array.time_options).length;
                themeSet[1] = R.color.colorTimeLight;
                themeSet[2] = R.drawable.swap_btn_cont_yellow;
                break;
            case AppConstant.VOLUME:
                themeSet[0] = Dunite.getContext().getResources().getStringArray(R.array.volume_options).length;
                themeSet[1] = R.color.colorVolumeLight;
                themeSet[2] = R.drawable.swap_btn_cont_purple;
                break;
            case AppConstant.WEIGHT:
                themeSet[0] = Dunite.getContext().getResources().getStringArray(R.array.weight_options).length;
                themeSet[1] = R.color.colorWeightLight;
                themeSet[2] = R.drawable.swap_btn_cont_green;
                break;
            default:
                themeSet[0] = Dunite.getContext().getResources().getStringArray(R.array.length_options).length;
                themeSet[1] = R.color.colorLengthLight;
                themeSet[2] = R.color.colorLengthDark;
                break;
        }
        return themeSet;
    }
}
