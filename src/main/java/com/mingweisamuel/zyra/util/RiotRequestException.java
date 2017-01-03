package com.mingweisamuel.zyra.util;

import java.io.IOException;

/**
 * Created by Mingw on 2017-01-02.
 */
public class RiotRequestException extends IOException {
    public RiotRequestException() { super(); }
    public RiotRequestException(Throwable cause) {
        super(cause);
    }
    public RiotRequestException(String message) {
        super(message);
    }
    public RiotRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
