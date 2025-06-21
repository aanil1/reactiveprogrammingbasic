package com.abhi.common;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;

public class Util {

    private static final Faker faker = Faker.instance();

    public static <T> Subscriber<T> subscribe()
    {
        return new DefaultSubscriber<>("");
    }

    public static <T> Subscriber<T> subscribe(String name)
    {
        return new DefaultSubscriber<>(name);
    }

    public static Faker getFaker()
    {
        return faker;
    }

    public static void sleepSeconds(int seconds){
        sleepMillis(seconds * 1000);
    }

    public static void sleepMillis(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
