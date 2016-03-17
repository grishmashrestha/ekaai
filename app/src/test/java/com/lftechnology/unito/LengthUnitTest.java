package com.lftechnology.unito;

import com.lftechnology.unito.conversions.Length;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 3/16/16.
 */
public class LengthUnitTest {

    @Test
    public void length_conversion_is_correct() throws Exception {
        Length length = new Length(1.0, "Nautical Mile", "Kilometre (km)");
        assertEquals(length.convert(), 1.852, 0.0000000001);
    }

    @Test
    public void length_conversion_kilometer_to_nautical_mile_is_correct() throws Exception {
        Length length = new Length(1.0, "Kilometre (km)", "Nautical Mile");
        assertEquals(length.convert(), 0.5399568034, 0.0000000001);
    }
}
