package com.mingweisamuel.zyra.test.util;

import org.asynchttpclient.Response;

import java.io.IOException;

/**
 * Created by Mingw on 2017-01-02.
 */
public class RiotResponseException extends RuntimeException {

    private final Response response;

    public RiotResponseException(Response response) {
        super();
        this.response = response;
    }
    public RiotResponseException(Throwable cause, Response response) {
        super(cause);
        this.response = response;
    }
    public RiotResponseException(String message, Response response) {
        super(message);
        this.response = response;
    }
    public RiotResponseException(String message, Throwable cause, Response response) {
        super(message, cause);
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }
}
