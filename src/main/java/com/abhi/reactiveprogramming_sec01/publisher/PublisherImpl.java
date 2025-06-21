package com.abhi.reactiveprogramming_sec01.publisher;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public class PublisherImpl implements Publisher<String> {

/**
 * This code in publisherimpl is mainly used to connect subscriptionimpl to subscriber
 * the subscribe method below is first called in  after creating publisher and subscriber in the demo class
 *this subscribe method is used to connect the subscriber to the publisher.
 *  var publisher = new PublisherImpl();
 * var subscriber = new SubscriberImpl();
 * publisher.subscribe(subscriber);
 * * The subscribe method creates a new instance of SubscriptionImpl and passes the subscriber to it.
 * * The subscriber's onSubscribe method is then called with the subscription instance.
 * * This establishes the connection between the publisher and the subscriber, allowing the subscriber to receive data from the publisher.
 *
 */
    public void subscribe(Subscriber<? super String> subscriber) {
        var subscription = new SubscriptionImpl(subscriber);
        subscriber.onSubscribe(subscription);
    }
}
