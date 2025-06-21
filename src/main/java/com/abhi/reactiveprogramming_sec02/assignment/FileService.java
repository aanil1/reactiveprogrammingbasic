package com.abhi.reactiveprogramming_sec02.assignment;

import reactor.core.publisher.Mono;

public interface FileService {

    public Mono<String> getFile(String fileName);
    public Mono<Void> writeFile(String fileName,String content);
    public Mono<Void> deleteFile(String fileName);
}
