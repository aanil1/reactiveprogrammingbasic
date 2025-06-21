package com.abhi.reactiveprogramming_sec04_fluxprogrammed;

import com.abhi.common.Util;
import reactor.core.publisher.Flux;

public class FluxEmitProgramatically {

    public static void main(String[] args) {
        // This class is intended to demonstrate how to emit items programmatically using Flux.
        // The implementation details would go here, such as creating a Flux and emitting items.
        // For example, you could use Flux.create() or Flux.generate() methods.

        Flux.create(sink ->
        {
            sink.next(1);
            sink.next(2);
            sink.complete();
        }).subscribe(Util.subscribe("sink"));

        Flux.create( sink -> {
            String country;
            do {

                country = Util.getFaker().country().name();
                sink.next(country);
            }while (!"India".equalsIgnoreCase(country));
            sink.complete();
            }
        ).subscribe(Util.subscribe("country-sink"));
        // flux.subscribe(System.out::println);
    }
}
