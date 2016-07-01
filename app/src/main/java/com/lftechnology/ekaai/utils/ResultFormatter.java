package com.lftechnology.ekaai.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * A class to format {@link Double} value to desired {@link String} result suitable for user to read
 */
public class ResultFormatter {

    /**
     * Convert {@link Double} input into desired {@link String} value
     *
     * @param input     {@link Double} input value
     * @param precision {@link Integer} precision of numbers after decimal
     * @return {@link String} formatted result
     */
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

    /**
     * Round off {@link Double} to precision mentioned
     *
     * @param input     {@link Double} input to be manipulated
     * @param precision {@link Integer}  precision of numbers after decimal
     * @return rounded of {@link Double} value
     */
    private static Double roundOffDouble(Double input, Integer precision) {
        BigDecimal bd = new BigDecimal(input);
        bd = bd.setScale(precision, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    /**
     * Method to check if the passed {@link Double} has numbers after decimal point
     *
     * @param input {@link Double} the number to be evaluated
     * @return returns true the input does not have numbers after decimal points
     */
    private static Boolean hasNoNumbersAfterDecimalPoints(Double input) {
        return Math.round(input) == input;
    }

    /**
     * Remove number after decimal point
     *
     * @param input {@link Double} input to be manipulated
     * @return {@link String} the converted value
     */
    private static String convertToNaturalNumber(Double input) {
        long inputInTermsOfInteger = input.longValue();
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
        return String.valueOf(decimalFormat.format(inputInTermsOfInteger));
    }
}
