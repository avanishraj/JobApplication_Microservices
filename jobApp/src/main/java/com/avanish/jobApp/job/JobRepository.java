package com.avanish.jobApp.job;

import com.avanish.jobApp.job.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Jobs, Long> {
}
