package com.cskku.werockstar.eventbusotto;

import com.squareup.otto.Bus;

public class EventBus {

    private static Bus bus = new Bus();

    public static Bus getBus() {
        if (bus == null)
            bus = new Bus();
        return bus;
    }

    public EventBus() {
    }
}
