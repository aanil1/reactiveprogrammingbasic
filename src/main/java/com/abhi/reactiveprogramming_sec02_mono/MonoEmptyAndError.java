package com.abhi.reactiveprogramming_sec02_mono;

import com.abhi.common.Util;
import reactor.core.publisher.Mono;

public class MonoEmptyAndError {

    public static void main(String[] args)
    {
getUserName(1).subscribe(Util.subscribe());
getUserName(2).subscribe(Util.subscribe());
getUserName(3).subscribe(Util.subscribe());
    }

    private static Mono<String> getUserName(int userId)
    {
        return switch(userId)
        {
            case 1 -> Mono.just("Abhishek");
            case 2 -> Mono.empty();
            default -> Mono.error(new RuntimeException("invalid user id"));
        };
    }
}
