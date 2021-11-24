package com.assignment.policyjob.repo;

import com.assignment.policyjob.model.JobEntity;
import com.assignment.policyjob.model.PolicyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepo extends JpaRepository<JobEntity, Long> {
    Optional<JobEntity> findById(Long jobId);
    Optional<JobEntity> findByPolicyId(Long policyId);
}
