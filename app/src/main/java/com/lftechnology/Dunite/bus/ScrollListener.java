package com.lftechnology.Dunite.bus;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 3/28/16.
 */
public class ScrollListener {
    public boolean moveUp;
    public float y1, y2;


    public ScrollListener(boolean moveUp, float y1, float y2) {
        this.moveUp = moveUp;
        this.y1 = y1;
        this.y2 = y2;
    }
}
