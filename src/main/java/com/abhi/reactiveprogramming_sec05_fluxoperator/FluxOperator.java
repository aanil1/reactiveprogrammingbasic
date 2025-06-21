package com.abhi.reactiveprogramming_sec05_fluxoperator;

import com.abhi.common.Util;
import reactor.core.publisher.Flux;

public class FluxOperator {

    public static void main(String[] args) {
        Flux.range(1,10).handle((item ,sink) -> {
           switch(item)
           {
               case 1 -> sink.next(1);
               case 4 -> {}
               case 7 -> sink.error(new RuntimeException("oops"));
               default -> sink.next(item);
           }
        })
                .cast(Integer.class)
                .subscribe(Util.subscribe());
    }

}
