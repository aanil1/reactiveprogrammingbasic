package com.abhi.reactiveprogramming_sec01;

import com.abhi.reactiveprogramming_sec01.publisher.PublisherImpl;
import com.abhi.reactiveprogramming_sec01.subscriber.SubscriberImpl;

public class Demo {

    /*
   1. publisher does not produce data unless subscriber requests for it.
   2. publisher will produce only <= subscriber requested items. publisher can also produce 0 items!
   3. subscriber can cancel the subscription. producer should stop at that moment as subscriber is no longer interested in consuming the data
   4. producer can send the error signal
 */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello and welcome to Reactive Programming!");
          /*
   1. publisher does not produce data unless subscriber requests for it.
   demo1(); shows this scenario.
           */
       // demo1();
         /*
   2. publisher will produce only <= subscriber requested items. publisher can also produce 0 items!
       so in below example, subscriber requests 12 items. but there are only 10 items available.
        demo2();
           */
       // demo2();


        /*   3. subscriber can cancel the subscription. producer should stop at that moment as subscriber is no longer interested in consuming the data
          Here after requesting 3 items, subscriber cancels the subscription. so after that no items will be produced even requested.
            demo3();
         */
        //demo3();

          /*   4. producer can send the error signal. Here after requesting 3 items, subscriber requests for 11 items. This exceeds the maximum limit of 10 items.
        so error will be thrown
            demo4();
         */
         demo4();
    }

    private static void demo1()
    {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
    }
    private static void demo2() throws InterruptedException {
    var publisher = new PublisherImpl();
    var subscriber = new SubscriberImpl();
    publisher.subscribe(subscriber);
    subscriber.getSubscription().request(3);
        Thread.sleep(3000);
        subscriber.getSubscription().request(3);
        Thread.sleep(3000);
        subscriber.getSubscription().request(3);
        Thread.sleep(3000);
        subscriber.getSubscription().request(3);
        Thread.sleep(3000);
        subscriber.getSubscription().request(3);
        Thread.sleep(3000);
        subscriber.getSubscription().request(3);
        Thread.sleep(3000);
    }

    private static void demo3() throws InterruptedException {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(3000);
        subscriber.getSubscription().cancel();
        subscriber.getSubscription().request(3);

    }

    private static void demo4() throws InterruptedException {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(3000);
        subscriber.getSubscription().request(11);
        // This will throw an error as it exceeds the maximum limit of 10 items
        // when requesting for items again it will not produce any items as on error we have set isCancelled to true.
        Thread.sleep(2000);
        subscriber.getSubscription().request(3);

    }
    }
