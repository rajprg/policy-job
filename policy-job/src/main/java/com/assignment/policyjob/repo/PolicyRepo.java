package com.assignment.policyjob.repo;

import com.assignment.policyjob.model.PolicyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PolicyRepo extends JpaRepository<PolicyEntity, Long> {

    Optional<PolicyEntity> findById(Long policyId);
}
