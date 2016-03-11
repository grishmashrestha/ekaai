package com.lftechnology.unito.bus;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 3/2/16.
 */
public class ConvertedValue {
    public String  value;
    public String from;
    public int position;

    public ConvertedValue(String val, String frm, int pos) {
        value = val;
        from = frm;
        position = pos;
    }
}
