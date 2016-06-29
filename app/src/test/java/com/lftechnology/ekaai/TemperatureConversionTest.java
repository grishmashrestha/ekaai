package com.lftechnology.ekaai;

import com.lftechnology.ekaai.conversions.Temperature;

import org.junit.Test;

import static com.lftechnology.ekaai.constant.AppConstant.TemperatureConstant.CELSIUS;
import static com.lftechnology.ekaai.constant.AppConstant.TemperatureConstant.FAHRENHEIT;
import static com.lftechnology.ekaai.constant.AppConstant.TemperatureConstant.KELVIN;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Unit tests for {@link com.lftechnology.ekaai.conversions.Temperature} conversion model
 */
public class TemperatureConversionTest {
    @Test
    public void temperature_conversion_initialization_success() throws Exception {
        Temperature temperature = new Temperature(1.0, KELVIN, FAHRENHEIT);
        assertEquals(temperature.getFrom(), KELVIN);
        assertEquals(temperature.getTo(), FAHRENHEIT);
        assertEquals(temperature.getValue(), 1.0);
        assertEquals(temperature.getReferenceUnit(), CELSIUS);
        assertEquals(temperature.convert(), -457.87);
    }

    @Test
    public void temperature_conversion_initialization_failure() throws Exception {
        Temperature temperature = new Temperature(1.0, KELVIN, CELSIUS);
        assertNotEquals(temperature.getFrom(), CELSIUS);
        assertNotEquals(temperature.getTo(), FAHRENHEIT);
        assertNotEquals(temperature.getValue(), 2.0);
        assertNotEquals(temperature.getReferenceUnit(), KELVIN);
        assertNotEquals(temperature.convert(), 20.0);
    }

    @Test
    public void temperature_conversion_same_unit_success() {
        Temperature temperature = new Temperature(1.0, KELVIN, KELVIN);
        assertEquals("True assumption", temperature.getFrom(), KELVIN);
        assertEquals("True assumption", temperature.convert(), 1.0);

        assertNotEquals("False assumption", temperature.getFrom(), CELSIUS);
        assertNotEquals("False assumption", temperature.convert(), 330.0);
    }
}
