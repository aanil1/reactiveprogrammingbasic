package com.abhi.reactiveprogramming_sec01.publisher;
import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*After establishing a connection between the publisher and subscriber, the SubscriptionImpl class is responsible for
    managing the flow of data from the publisher to the subscriber. It handles requests for data,
    cancellation of the subscription, and error handling. The request method allows the subscriber to specify
    how many items it wants to receive,
    while the cancel method allows the subscriber to stop receiving data.
    If an error occurs, the onError method is called to notify the subscriber.
 */
public class SubscriptionImpl implements Subscription {
    private static final Logger log = LoggerFactory.getLogger(SubscriptionImpl.class);
    private static final int MAX_REQUESTED = 10; // Maximum number of items that can be requested
    private final Subscriber<? super String> subscriber;
    private final Faker faker;
    private boolean isCancelled;
    private  int count;
    public SubscriptionImpl(Subscriber<? super String> subscriber) {
        this.subscriber = subscriber;
        this.faker = Faker.instance();
    }


    @java.lang.Override
    public void request(long requested) {
    if (isCancelled)
    {
        return;
    }
    if(requested > MAX_REQUESTED)
    {
        this.subscriber.onError(new RuntimeException("Requested items exceed maximum limit of " + MAX_REQUESTED));
       this.isCancelled=true;
       return;
    }
    log.info("subscriber has requested {} items", requested);
    for (int i = 0; i < requested && count < MAX_REQUESTED; i++) {
        count++;
        // Simulating sending an email

        this.subscriber.onNext(this.faker.internet().emailAddress());
    }
    if(this.count == MAX_REQUESTED)
    {
        log.info("no more data to produce");
        this.subscriber.onComplete();
        this.isCancelled = true;
    }
    }
    /**
     * This method is called when the subscriber cancels the subscription.
     * It sets the isCancelled flag to true and logs a message.
     */
    @java.lang.Override
    public void cancel() {
        log.info("subscriber has cancelled");
        this.isCancelled=true;
    }
}
