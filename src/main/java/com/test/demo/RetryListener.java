package com.test.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.listener.RetryListenerSupport;
import org.springframework.stereotype.Component;


@Slf4j
@Component
class RetryListener extends RetryListenerSupport {

    @Override
    public <T, E extends Throwable> void close(RetryContext context,
                                               RetryCallback<T, E> callback, Throwable throwable) {

        System.out.println("Unable to recover from  Exception");
        System.out.println("Error ");
        super.close(context, callback, throwable);
    }

    @Override
    public <T, E extends Throwable> void onError(RetryContext context, 
        RetryCallback<T, E> callback, Throwable throwable) {
            
        System.out.println("Exception Occurred, Retry Count " + context.getRetryCount());
        super.onError(context, callback, throwable);
    }

    @Override
    public <T, E extends Throwable> boolean open(RetryContext context,
                                                 RetryCallback<T, E> callback) {
        System.out.println("Exception Occurred, Retry Session Started ");
        return super.open(context, callback);
    }
}