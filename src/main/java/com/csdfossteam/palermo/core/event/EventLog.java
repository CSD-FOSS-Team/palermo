package com.csdfossteam.palermo.core.event;

import java.util.ArrayList;

/**
 * A list of all the events.
 *
 * @author Akritas Akritidis
 */
public final class EventLog {

    private final ArrayList<Event> events;

    public EventLog() {
        events = new ArrayList<>();
    }

    public void push(Event event) {
        events.add(event);
    }

    /**
     * Get a pointer to the start of the log.
     */
    public Pointer getPointer() {
        return new Pointer(0);
    }

    /**
     * A pointer to a location of the event log.
     */
    public final class Pointer {

        private int index;

        private Pointer(int index) {
            this.index = index;
        }

        public boolean has() {
            return events.size() > index;
        }

        public Event get() {
            return events.get(index);
        }

        public Event next() {
            return events.get(index++);
        }
    }
}
