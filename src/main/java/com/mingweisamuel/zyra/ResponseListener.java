package com.mingweisamuel.zyra;

import org.asynchttpclient.Response;

/**
 * Interface to listen to RiotApi request successes and failures.
 */
@FunctionalInterface
public interface ResponseListener {

    void onResponse(boolean success, Response response);
}
