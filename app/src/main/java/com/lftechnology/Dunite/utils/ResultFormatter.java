package com.lftechnology.Dunite.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 4/4/16.
 */
public class ResultFormatter {
    public static String format(Double input, Integer precision) {
        String returnValue;
        Double roundedOffInput = roundOffDouble(input, precision);

        if (hasNoNumbersAfterDecimalPoints(roundedOffInput) && roundedOffInput != 0) {
            returnValue = convertToNaturalNumber(roundedOffInput);
        } else {
            if (roundedOffInput == 0.000) {
                returnValue = "Less than 0.000";
            } else {
                returnValue = String.valueOf(roundedOffInput);
            }
        }
        return returnValue;
    }

    private static Double roundOffDouble(Double input, Integer precision) {
        BigDecimal bd = new BigDecimal(input);
        bd = bd.setScale(precision, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    private static Boolean hasNoNumbersAfterDecimalPoints(Double input) {
        return Math.round(input) == input;
    }

    private static String convertToNaturalNumber(Double input) {
        long inputInTermsOfInteger = input.longValue();
        return String.valueOf(inputInTermsOfInteger);
    }
}
