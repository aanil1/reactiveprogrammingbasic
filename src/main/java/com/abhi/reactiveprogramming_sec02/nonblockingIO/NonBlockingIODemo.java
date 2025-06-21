package com.abhi.reactiveprogramming_sec02.nonblockingIO;

import com.abhi.reactiveprogramming_sec02.client.ExternalServiceClient;
import org.slf4j.Logger;
import com.abhi.common.Util;

public class NonBlockingIODemo {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(NonBlockingIODemo.class);
    public static void main(String[] args) {
       var client = new ExternalServiceClient();
        log.info("starting to call external service");
        for (int i = 0; i < 10; i++) {
            client.getProductName(i).subscribe(Util.subscribe());
        }
        Util.sleepSeconds(2);
    }
}
