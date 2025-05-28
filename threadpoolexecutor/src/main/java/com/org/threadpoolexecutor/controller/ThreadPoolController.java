package com.org.threadpoolexecutor.controller;

import com.org.threadpoolexecutor.dto.SampleDto;
import com.org.threadpoolexecutor.entity.Sample;
import com.org.threadpoolexecutor.service.ThreadpoolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@RestController
public class ThreadPoolController {

    private ThreadpoolService threadpoolService;

    public ThreadPoolController(ThreadpoolService threadpoolService) {
        this.threadpoolService = threadpoolService;
    }

    @GetMapping("/fetch")
    public CompletableFuture<List<Sample>> fetchSampleDto() throws ExecutionException, InterruptedException {

        return threadpoolService.getSampleDto();
        
        /*List<CompletableFuture<List<Sample>>> futures = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            futures.add(threadpoolService.getSampleDto());
        }

        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(v -> futures.stream()
                        .map(CompletableFuture::join)
                        .flatMap(List::stream)
                        .collect(Collectors.toList()))
                .thenApply(ResponseEntity::ok);*/

    }

    @GetMapping("/sync")
    public ResponseEntity<List<Sample>> getSampleDto() {

        return threadpoolService.getSampleDtoSync() != null ? ResponseEntity.ok(threadpoolService.getSampleDtoSync()) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
    }

    @PostMapping("/create")
    public String createSampleDto(@RequestBody SampleDto sampleDto) {
        return threadpoolService.createSampleDto(sampleDto);
    }

}
