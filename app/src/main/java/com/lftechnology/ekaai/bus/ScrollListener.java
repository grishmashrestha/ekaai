package com.lftechnology.ekaai.bus;

/**
 * A class to represent data involved when listening to scroll while using {@link EventBus}
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
