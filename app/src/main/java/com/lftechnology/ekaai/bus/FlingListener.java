package com.lftechnology.ekaai.bus;

/**
 * A class to represent data involved when listening to fling gesture while using {@link EventBus}
 */
public class FlingListener {
    public boolean flingedUp;

    public FlingListener(boolean flingedUp) {
        this.flingedUp = flingedUp;
    }
}
