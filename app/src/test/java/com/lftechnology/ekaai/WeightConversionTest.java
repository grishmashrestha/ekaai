package com.lftechnology.ekaai;

import com.lftechnology.ekaai.conversions.Weight;

import org.junit.Test;

import static com.lftechnology.ekaai.constant.AppConstant.WeightConstant.CARAT;
import static com.lftechnology.ekaai.constant.AppConstant.WeightConstant.GRAIN;
import static com.lftechnology.ekaai.constant.AppConstant.WeightConstant.GRAM;
import static com.lftechnology.ekaai.constant.AppConstant.WeightConstant.KILOGRAM;
import static com.lftechnology.ekaai.constant.AppConstant.WeightConstant.POUND;
import static com.lftechnology.ekaai.constant.AppConstant.WeightConstant.TONNE;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Unit tests for {@link com.lftechnology.ekaai.conversions.Weight} conversion model
 */
public class WeightConversionTest {
    @Test
    public void weight_conversion_initialization_success() throws Exception {
        Weight weight = new Weight(1.0, POUND, TONNE);
        assertEquals(weight.getFrom(), POUND);
        assertEquals(weight.getTo(), TONNE);
        assertEquals(weight.getValue(), 1.0);
        assertEquals(weight.getReferenceUnit(), KILOGRAM);
        assertEquals(weight.convert(), 0.000453592, 0.00000001);
    }

    @Test
    public void weight_conversion_initialization_failure() throws Exception {
        Weight weight = new Weight(1.0, TONNE, CARAT);
        assertNotEquals(weight.getFrom(), CARAT);
        assertNotEquals(weight.getTo(), TONNE);
        assertNotEquals(weight.getValue(), 1.1);
        assertNotEquals(weight.getReferenceUnit(), POUND);
        assertNotEquals(weight.convert(), 5000000.01);
    }

    @Test
    public void weight_conversion_same_unit_success() {
        Weight weight = new Weight(2.0, GRAM, GRAM);
        assertEquals("True assumption", weight.getFrom(), GRAM);
        assertEquals("True assumption", weight.convert(), 2.0);

        assertNotEquals("False assumption", weight.getFrom(), GRAIN);
        assertNotEquals("False assumption", weight.convert(), 3.0);
    }
}
