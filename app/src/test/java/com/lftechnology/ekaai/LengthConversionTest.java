package com.lftechnology.ekaai;

import com.lftechnology.ekaai.conversions.Length;

import org.junit.Test;

import static com.lftechnology.ekaai.constant.AppConstant.LengthConstant.FEET;
import static com.lftechnology.ekaai.constant.AppConstant.LengthConstant.INCH;
import static com.lftechnology.ekaai.constant.AppConstant.LengthConstant.KILOMETER;
import static com.lftechnology.ekaai.constant.AppConstant.LengthConstant.MICRON;
import static com.lftechnology.ekaai.constant.AppConstant.LengthConstant.MILE;
import static com.lftechnology.ekaai.constant.AppConstant.LengthConstant.NAUTICAL_MILE;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;

/**
 * Unit tests for {@link Length} conversion model
 */
public class LengthConversionTest {
    @Test
    public void length_conversion_initialization_success() throws Exception {
        Length length = new Length(1.0, NAUTICAL_MILE, KILOMETER);
        assertEquals(length.getFrom(), NAUTICAL_MILE);
        assertEquals(length.getTo(), KILOMETER);
        assertEquals(length.getValue(), 1.0);
        assertEquals(length.getReferenceUnit(), KILOMETER);
        assertEquals(length.convert(), 1.852);
    }

    @Test
    public void length_conversion_initialization_failure() throws Exception {
        Length length = new Length(1.0, NAUTICAL_MILE, KILOMETER);
        assertNotEquals(length.getFrom(), MILE);
        assertNotEquals(length.getTo(), NAUTICAL_MILE);
        assertNotEquals(length.getValue(), 2.0);
        assertNotEquals(length.getReferenceUnit(), MILE);
        assertNotEquals(length.convert(), 20.0);
    }

    @Test
    public void length_conversion_kilometer_to_nautical_mile_is_correct() throws Exception {
        Length length = new Length(1.0, INCH, KILOMETER);
        assertEquals(length.convert(), 2.54E-5);
        assertNotEquals(length.convert(), 3.54E-5);
    }

    @Test
    public void length_conversion_same_unit_conversions_is_correct() throws Exception {
        Length length = new Length(10.0, KILOMETER, KILOMETER);
        assertNotEquals("False assumption", length.convert(), 5.0);
        assertEquals("True Assumption", length.convert(), 10.0);
        assertNotNull(length.convert());
    }

    @Test
    public void length_conversion_micron_to_feet_is_correct() throws Exception {
        Length length = new Length(10.0, MICRON, FEET);
        assertNotEquals("False assumption", length.convert(), 5.0);
        assertEquals("True Assumption", length.convert(), 3.280839895013123E-5);
        assertNotNull(length.convert());
    }
}
