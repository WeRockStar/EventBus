package com.cskku.werockstar.eventbusotto;

/**
 * Created by Kotchaphan on 5/10/2558.
 */
public class MessageEvent {
    private String message;

    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
