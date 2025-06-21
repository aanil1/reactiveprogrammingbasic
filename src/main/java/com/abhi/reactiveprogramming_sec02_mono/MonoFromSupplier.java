package com.abhi.reactiveprogramming_sec02_mono;

import com.abhi.common.DefaultSubscriber;
import com.abhi.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class MonoFromSupplier {
    private static final Logger log = LoggerFactory.getLogger(MonoFromSupplier.class);
    public static void main(String[] args) {
        var list = List.of(1, 2, 3);
       // Mono.just(sum(list));
        //Mono.fromSupplier(() -> sum(list));
        Mono.fromSupplier(() -> sum(list)).subscribe(Util.subscribe());
    }

    private static int sum(List<Integer> intList)
    {
        log.info("finding sum of {}", intList);
        return intList.stream().mapToInt(a -> a).sum();
    }
}
