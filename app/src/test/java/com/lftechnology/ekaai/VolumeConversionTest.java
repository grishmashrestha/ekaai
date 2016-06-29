package com.lftechnology.ekaai;

import com.lftechnology.ekaai.conversions.Volume;

import org.junit.Test;

import static com.lftechnology.ekaai.constant.AppConstant.VolumeConstant.BARREL;
import static com.lftechnology.ekaai.constant.AppConstant.VolumeConstant.CUBIC_CENTIMETER;
import static com.lftechnology.ekaai.constant.AppConstant.VolumeConstant.CUBIC_METER;
import static com.lftechnology.ekaai.constant.AppConstant.VolumeConstant.GALLON;
import static com.lftechnology.ekaai.constant.AppConstant.VolumeConstant.MILLILITER;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Unit tests for {@link com.lftechnology.ekaai.conversions.Volume} conversion model
 */
public class VolumeConversionTest {
    @Test
    public void volume_conversion_initialization_success() throws Exception {
        Volume volume = new Volume(1.0, MILLILITER, GALLON);
        assertEquals(volume.getFrom(), MILLILITER);
        assertEquals(volume.getTo(), GALLON);
        assertEquals(volume.getValue(), 1.0);
        assertEquals(volume.getReferenceUnit(), MILLILITER);
        assertEquals(volume.convert(), 2.641720523582E-4);
    }

    @Test
    public void volume_conversion_initialization_failure() throws Exception {
        Volume volume = new Volume(1.0, MILLILITER, GALLON);
        assertNotEquals(volume.getFrom(), GALLON);
        assertNotEquals(volume.getTo(), BARREL);
        assertNotEquals(volume.getValue(), 2.0);
        assertNotEquals(volume.getReferenceUnit(), CUBIC_CENTIMETER);
        assertNotEquals(volume.convert(), 20.0);
    }

    @Test
    public void volume_conversion_same_unit_success() {
        Volume volume = new Volume(2.0, CUBIC_METER, CUBIC_METER);
        assertEquals("True assumption", volume.getFrom(), CUBIC_METER);
        assertEquals("True assumption", volume.convert(), 2.0);

        assertNotEquals("False assumption", volume.getFrom(), CUBIC_CENTIMETER);
        assertNotEquals("False assumption", volume.convert(), 3.0);
    }
}
