package com.org.threadpoolexecutor.service;

import com.org.threadpoolexecutor.dto.SampleDto;
import com.org.threadpoolexecutor.entity.Sample;
import com.org.threadpoolexecutor.exception.CompletableFutureExceptions;
import com.org.threadpoolexecutor.repo.ISampleRepo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

@Service
public class ThreadpoolService {

    private final ISampleRepo sampleRepo;
    private final Executor executor;

    public ThreadpoolService(ISampleRepo sampleRepo, @Qualifier("taskExecutor") Executor executor) {
        this.sampleRepo = sampleRepo;
        this.executor = executor;
    }

    @Async("taskExecutor")
    public CompletableFuture<List<Sample>> getSampleDto() throws ExecutionException, InterruptedException {

      /*  try {
            System.out.println("Thread Name: " + Thread.currentThread().getName());
            Thread.sleep(5000);
        } catch(Exception e) {
            Thread.currentThread().interrupt();
            System.out.println(e.getMessage());
        }*/

        CompletableFuture<List<Sample>> future = CompletableFuture.supplyAsync(sampleRepo::findAll, executor);

        return future;

        /*return CompletableFuture.completedFuture(sampleRepo.findAll())
                .exceptionally(ex -> {
                    throw new CompletableFutureExceptions(ex.getMessage());
                });*/
    }

    public List<Sample> getSampleDtoSync() {
        return sampleRepo.findAll();
    }

    public String createSampleDto(SampleDto sampleDto) {

        Sample sample = new Sample();
        sample.setName(sampleDto.getName());
        Sample sample1 = sampleRepo.save(sample);

        return "Sample entity Created with Id "+sample1.getId();
    }
}
