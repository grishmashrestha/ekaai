package com.lftechnology.NaapTol.bus;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 3/2/16.
 */
public class EventBus {
    private static Bus eventBus;

    private static Bus getBus() {
        if (eventBus == null) {
            eventBus = new Bus(ThreadEnforcer.MAIN);
        }

        return eventBus;
    }

    /**
     * Wrapper method to register event
     */
    public static void register(Object event) {
        getBus().register(event);
    }

    /**
     * Wrapper method to unregister event
     */
    public static void unregister(Object event) {
        getBus().unregister(event);
    }

    /**
     * Wrapper method to post event
     */
    public static void post(Object event) {
        getBus().post(event);
    }
}
