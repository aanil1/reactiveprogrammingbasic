package com.abhi.reactiveprogramming_sec05_fluxhotcoldpublisher;

import com.abhi.common.Util;
import reactor.core.publisher.Flux;

public class Fluxhotpublisher {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Fluxhotpublisher.class);

    public static void main(String[] args) {
        // Hot Publisher example
        // In a hot publisher, the data is produced regardless of whether there are subscribers or not.
        // Subscribers will receive the data that is emitted after they subscribe.

        var movieFlux = movieGenerate().share();
        // share() makes the Flux a hot publisher, allowing multiple subscribers to share the same source of data.
        // also share implies ref count as 1. this means as below code.
        //var movieFlux = movieGenerate().publish().refCount(1);
        // so share is equal to publish().
        // also we can increase ref count to 2 or 3 or any number
        // this means that the publisher will not start until there are at least 2 subscribers.
        // var movieFlux = movieGenerate().refCount(2); for minimum 2 subscribers to start the publisher
        Util.sleepSeconds(2);

        movieFlux.subscribe(Util.subscribe("sam"));
        Util.sleepSeconds(3);
        movieFlux.subscribe(Util.subscribe("mike"));
        Util.sleepSeconds(15);

    }

    private static Flux<String> movieGenerate()
    {
       var movieflux =   Flux.generate(
                () -> {
                log.info("received the request to generate movies");
                return 1;
                },
                (state,sink) -> {
                    var scene = "movie scene"+ state;
                    log.info("playing {}", scene);
                    sink.next(scene);
                    return ++state;
                }).take(10)
                        .delayElements(java.time.Duration.ofSeconds(1))
                        .cast(String.class);

 return movieflux;
    }
}
