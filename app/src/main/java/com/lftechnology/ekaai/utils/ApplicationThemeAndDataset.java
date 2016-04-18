package com.lftechnology.ekaai.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.lftechnology.ekaai.Ekaai;
import com.lftechnology.ekaai.R;
import com.lftechnology.ekaai.constant.AppConstant;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 4/7/16.
 */
public class ApplicationThemeAndDataset {
    public static String[] getDataset(String mSelectedConversion) {
        String[] dataset;
        SharedPreferences sharedPref = Ekaai.getContext().getSharedPreferences(AppConstant.EKAAI, Context.MODE_PRIVATE);
        String preference = sharedPref.getString(mSelectedConversion, AppConstant.NOT_AVAILABLE);
        if (preference.equals(AppConstant.NOT_AVAILABLE)) {
            switch (mSelectedConversion) {
                case AppConstant.LENGTH:
                    dataset = Ekaai.getContext().getResources().getStringArray(R.array.length_options);
                    break;
                case AppConstant.TEMPERATURE:
                    dataset = Ekaai.getContext().getResources().getStringArray(R.array.temperature_options);
                    break;
                case AppConstant.TIME:
                    dataset = Ekaai.getContext().getResources().getStringArray(R.array.time_options);
                    break;
                case AppConstant.VOLUME:
                    dataset = Ekaai.getContext().getResources().getStringArray(R.array.volume_options);
                    break;
                case AppConstant.WEIGHT:
                    dataset = Ekaai.getContext().getResources().getStringArray(R.array.weight_options);
                    break;
                default:
                    dataset = Ekaai.getContext().getResources().getStringArray(R.array.length_options);
                    break;
            }
        } else {
            Gson gson = new Gson();
            dataset = gson.fromJson(preference, String[].class);
        }
        return dataset;
    }

    public static Integer[] getThemeDetails(String selectedConversion) {
        Integer[] themeSet = new Integer[3];
        switch (selectedConversion) {
            case AppConstant.LENGTH:
                themeSet[0] = Ekaai.getContext().getResources().getStringArray(R.array.length_options).length;
                themeSet[1] = R.color.colorLengthLight;
                themeSet[2] = R.drawable.swap_btn_cont_blue;
                break;
            case AppConstant.TEMPERATURE:
                themeSet[0] = Ekaai.getContext().getResources().getStringArray(R.array.temperature_options).length;
                themeSet[1] = R.color.colorTemperatureLight;
                themeSet[2] = R.drawable.swap_btn_cont_red;
                break;
            case AppConstant.TIME:
                themeSet[0] = Ekaai.getContext().getResources().getStringArray(R.array.time_options).length;
                themeSet[1] = R.color.colorTimeLight;
                themeSet[2] = R.drawable.swap_btn_cont_yellow;
                break;
            case AppConstant.VOLUME:
                themeSet[0] = Ekaai.getContext().getResources().getStringArray(R.array.volume_options).length;
                themeSet[1] = R.color.colorVolumeLight;
                themeSet[2] = R.drawable.swap_btn_cont_purple;
                break;
            case AppConstant.WEIGHT:
                themeSet[0] = Ekaai.getContext().getResources().getStringArray(R.array.weight_options).length;
                themeSet[1] = R.color.colorWeightLight;
                themeSet[2] = R.drawable.swap_btn_cont_green;
                break;
            default:
                themeSet[0] = Ekaai.getContext().getResources().getStringArray(R.array.length_options).length;
                themeSet[1] = R.color.colorLengthLight;
                themeSet[2] = R.color.colorLengthDark;
                break;
        }
        return themeSet;
    }
}
