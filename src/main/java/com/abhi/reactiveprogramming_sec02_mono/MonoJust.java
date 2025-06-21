package com.abhi.reactiveprogramming_sec02_mono;

import com.abhi.reactiveprogramming_sec01.subscriber.SubscriberImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.Arrays;

public class MonoJust {
    private static final Logger log = LoggerFactory.getLogger(MonoJust.class);

    public static void main(String[] args) {
        MonoJustDemo();
        monoMethodOverload();
    }

    public static void MonoJustDemo() {
        // Mono.just() creates a Mono that emits a single item
        // Example: Mono.just("Abhishek") will emit "Abhishek" as the only item
        // This is useful for creating a Mono from a known value
        var mono = Mono.just("Abhishek");
        var subscriber = new SubscriberImpl();
        mono.subscribe(subscriber);
        subscriber.getSubscription().request(5);
    }

    public static void monoMethodOverload()
    {
        var mon0 = Mono.just(1);
        var mon1 = Mono.just(Arrays.asList("2,5,3"));
        mon1.subscribe(
                i -> log.info("recieved {}", i),
                err -> log.error("error incurred {}",err),
                () -> log.info("completed"),
                subscription -> subscription.request(1)
        );
    }
}
