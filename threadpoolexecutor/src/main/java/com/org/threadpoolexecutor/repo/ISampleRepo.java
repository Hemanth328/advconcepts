package com.org.threadpoolexecutor.repo;

import com.org.threadpoolexecutor.entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISampleRepo extends JpaRepository<Sample, Integer> {
}
