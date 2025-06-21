package com.abhi.reactiveprogramming_sec02_mono;

import com.abhi.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class MonoDefer {
    private static final Logger log = LoggerFactory.getLogger(MonoDefer.class);
    public static void main(String[] args) {

        Mono.defer(MonoDefer::createPublisher);
        // no call to createPublisher  until subscribe is called
        log.info("now calling defer with subscribe");
        // call to createPublisher only when subscribe method is called
        Mono.defer(MonoDefer::createPublisher)
                .subscribe(Util.subscribe())
        ;
    }

    private static Mono<Integer> createPublisher() {
        log.info("creating publisher");
        var list = List.of(1, 2, 3);
      Util.sleepSeconds(3);
        return Mono.fromSupplier(() -> sum(list));
    }

    private static int sum(List<Integer> intList)
    {
        return intList.stream().mapToInt(a -> a).sum();
    }
}
