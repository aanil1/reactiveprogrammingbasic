package com.abhi.common;

import com.abhi.reactiveprogramming_sec01.subscriber.SubscriberImpl;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultSubscriber<T> implements Subscriber<T> {
    private String name;
    private static final Logger log = LoggerFactory.getLogger(DefaultSubscriber.class);
    public DefaultSubscriber(String name)
    {
        this.name = name;
    }

    @Override
    public void onSubscribe(Subscription s) {

        s.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(T item) {
        log.info("{} received value of item {}",this.name,item);

    }

    @Override
    public void onError(Throwable t) {
        log.error("{} received error {}",this.name,t.getMessage());
    }

    @Override
    public void onComplete() {
        log.info("{} completed",this.name);
    }
}
