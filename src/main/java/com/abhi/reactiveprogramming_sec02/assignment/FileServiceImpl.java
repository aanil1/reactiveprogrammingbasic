package com.abhi.reactiveprogramming_sec02.assignment;

import com.abhi.reactiveprogramming_sec02.nonblockingIO.NonBlockingIODemo;
import org.slf4j.Logger;
import reactor.core.publisher.Mono;
import org.slf4j.LoggerFactory;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileServiceImpl implements  FileService{

    private static final Path FILE_DIRECTORY = Path.of("src/main/resources/sec02");
    private static final Logger log = LoggerFactory.getLogger(FileServiceImpl.class);

    @Override
    public Mono<String> getFile(String fileName) {
        return Mono.fromCallable(() ->
            Files.readString(FILE_DIRECTORY.resolve(fileName)));
    }

    @Override
    public Mono<Void> writeFile(String fileName, String content) {
        return Mono.fromRunnable( () -> this.write(fileName, content));
    }

    @Override
    public Mono<Void> deleteFile(String fileName) {
        return Mono.fromRunnable( () -> this.delete(fileName));
    }

    private void write(String fileName, String content) {
        try {
            Files.writeString(FILE_DIRECTORY.resolve(fileName), content);
            log.info("file {} written successfully", fileName);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error writing file: " + fileName, e);
        }
    }

    private void delete(String fileName) {
        try {
            Files.deleteIfExists(FILE_DIRECTORY.resolve(fileName));
            log.info("file {} deleted successfully", fileName);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error deleting file: " + fileName, e);
        }
    }
}
