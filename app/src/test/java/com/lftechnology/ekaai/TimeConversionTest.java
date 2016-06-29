package com.lftechnology.ekaai;

import com.lftechnology.ekaai.conversions.Time;

import org.junit.Test;

import static com.lftechnology.ekaai.constant.AppConstant.TimeConstant.CENTURY;
import static com.lftechnology.ekaai.constant.AppConstant.TimeConstant.DAY;
import static com.lftechnology.ekaai.constant.AppConstant.TimeConstant.MICROSECOND;
import static com.lftechnology.ekaai.constant.AppConstant.TimeConstant.MILLENNIUM;
import static com.lftechnology.ekaai.constant.AppConstant.TimeConstant.MINUTE;
import static com.lftechnology.ekaai.constant.AppConstant.TimeConstant.SECOND;
import static com.lftechnology.ekaai.constant.AppConstant.TimeConstant.YEAR;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Unit tests for {@link com.lftechnology.ekaai.conversions.Time} conversion model
 */
public class TimeConversionTest {
    @Test
    public void time_conversion_initialization_success() throws Exception {
        Time time = new Time(1.0, CENTURY, YEAR);
        assertEquals(time.getFrom(), CENTURY);
        assertEquals(time.getTo(), YEAR);
        assertEquals(time.getValue(), 1.0);
        assertEquals(time.getReferenceUnit(), DAY);
        assertEquals(time.convert(), 100.0);
    }

    @Test
    public void time_conversion_initialization_failure() throws Exception {
        Time time = new Time(1.0, SECOND, MINUTE);
        assertNotEquals(time.getFrom(), MINUTE);
        assertNotEquals(time.getTo(), SECOND);
        assertNotEquals(time.getValue(), 2.0);
        assertNotEquals(time.getReferenceUnit(), MILLENNIUM);
        assertNotEquals(time.convert(), 20.0);
    }

    @Test
    public void time_conversion_same_unit_success() {
        Time time = new Time(2.0, CENTURY, CENTURY);
        assertEquals("True assumption", time.getFrom(), CENTURY);
        assertEquals("True assumption", time.convert(), 2.0);

        assertNotEquals("False assumption", time.getFrom(), MICROSECOND);
        assertNotEquals("False assumption", time.convert(), 101.0);
    }
}
