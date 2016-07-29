package com.lftechnology.ekaai.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.lftechnology.ekaai.Ekaai;
import com.lftechnology.ekaai.R;
import com.lftechnology.ekaai.constant.AppConstant;

/**
 * A class to fetch dataset and theme related to the given selected conversion
 */
public class ApplicationThemeAndDataset {

    /**
     * Returns the dataset from {@link SharedPreferences} according to the selectedConversion passed
     *
     * @param selectedConversion {@link String} for which dataset is required
     * @return the dataset for the given selectedConversion
     */
    public static String[] getDataset(String selectedConversion) {
        String[] dataset;
        SharedPreferences sharedPref = Ekaai.getContext().getSharedPreferences(AppConstant.EKAAI, Context.MODE_PRIVATE);
        String preference = sharedPref.getString(selectedConversion, AppConstant.NOT_AVAILABLE);
        if (preference.equals(AppConstant.NOT_AVAILABLE)) {
            switch (selectedConversion) {
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

    /**
     * Return application theme related details in integer array
     *
     * @param selectedConversion current conversion unit
     * @return application theme related details such as array of units, color for the bottom view pager and swap button color for the selected conversion.
     */
    public static Integer[] getThemeDetails(String selectedConversion) {
        Integer[] themeSet = new Integer[3];
        switch (selectedConversion) {
            case AppConstant.LENGTH:
                themeSet[0] = Ekaai.getContext().getResources().getStringArray(R.array.length_options).length;
                themeSet[1] = R.color.colorLengthLight;
                themeSet[2] = R.drawable.swap_btn_blue;
                break;
            case AppConstant.TEMPERATURE:
                themeSet[0] = Ekaai.getContext().getResources().getStringArray(R.array.temperature_options).length;
                themeSet[1] = R.color.colorTemperatureLight;
                themeSet[2] = R.drawable.swap_btn_red;
                break;
            case AppConstant.TIME:
                themeSet[0] = Ekaai.getContext().getResources().getStringArray(R.array.time_options).length;
                themeSet[1] = R.color.colorTimeLight;
                themeSet[2] = R.drawable.swap_btn_yellow;
                break;
            case AppConstant.VOLUME:
                themeSet[0] = Ekaai.getContext().getResources().getStringArray(R.array.volume_options).length;
                themeSet[1] = R.color.colorVolumeLight;
                themeSet[2] = R.drawable.swap_btn_purple;
                break;
            case AppConstant.WEIGHT:
                themeSet[0] = Ekaai.getContext().getResources().getStringArray(R.array.weight_options).length;
                themeSet[1] = R.color.colorWeightLight;
                themeSet[2] = R.drawable.swap_btn_green;
                break;
            default:
                themeSet[0] = Ekaai.getContext().getResources().getStringArray(R.array.length_options).length;
                themeSet[1] = R.color.colorLengthLight;
                themeSet[2] = R.drawable.swap_btn_blue;
                break;
        }
        return themeSet;
    }
}
