package com.abhi.reactiveprogramming_sec05_fluxhotcoldpublisher;

import com.abhi.common.Util;
import reactor.core.publisher.Flux;

public class FluxColdPublisher {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(FluxColdPublisher.class);

    public static void main(String[] args) {


       var flux =  Flux.create(fluxSink -> {
            log.info("invoked");
            for (int i = 0; i < 3; i++) {
                fluxSink.next(i);
            }
            fluxSink.complete();
        });

        flux.subscribe(Util.subscribe("subscriber 1"));

        flux.subscribe(Util.subscribe("subscriber 2"));
    //So here each subscriber receives its own set of data.
    }




}
