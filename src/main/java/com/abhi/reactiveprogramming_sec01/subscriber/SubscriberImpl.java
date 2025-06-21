package com.abhi.reactiveprogramming_sec01.subscriber;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscriberImpl implements Subscriber<String> {

    private static final Logger log = LoggerFactory.getLogger(SubscriberImpl.class);
    private Subscription subscription;

    public Subscription getSubscription() {
        return subscription;
    }



    public void onSubscribe(Subscription s) {
        this.subscription =s;
    }


    public void onNext(String email) {
        log.info("value of email {}",email);
    }

    public void onError(java.lang.Throwable t) {
        log.error("error");
    }

    public void onComplete() {
        log.info("completed");
    }
}
