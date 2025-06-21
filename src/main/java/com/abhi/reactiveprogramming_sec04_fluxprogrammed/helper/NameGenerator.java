package com.abhi.reactiveprogramming_sec04_fluxprogrammed.helper;

import com.abhi.common.Util;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class NameGenerator implements Consumer<FluxSink<String>>{

    private FluxSink<String>   fluxSink;

    @Override
    public void accept(FluxSink<String> fluxSink) {
        this.fluxSink = fluxSink;

    }

    public void generate()
    {
        this.fluxSink.next(Util.getFaker().name().firstName());
    }
}
