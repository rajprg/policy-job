package com.assignment.policyjob.service;

import com.assignment.policyjob.dto.request.CreateJobDto;
import com.assignment.policyjob.dto.request.CreatePolicyDto;
import com.assignment.policyjob.exceptions.DataException;
import com.assignment.policyjob.model.JobEntity;
import com.assignment.policyjob.model.PolicyEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PolicyJobService {
    Object savePolicy(CreatePolicyDto createPolicyDto) throws DataException;

    Object saveJob(CreateJobDto createJobDto) throws DataException;

    Object getPolicyById(Long policyId) throws DataException;

    Object getJobById(Long jobId) throws DataException;

    Object updatePolicy(Long policyId, CreatePolicyDto createPolicyDto) throws DataException;

    Object updateJob(Long jobId, CreateJobDto createJobDto) throws DataException;

    String deletePolicyById(Long policyId) throws DataException;

    String deleteJobById(Long jobId) throws DataException;

    Object getJobByPolicyId(Long policyId) throws DataException;

    Object getPolicyByJobId(Long jobId) throws DataException;

    List<PolicyEntity> getAllPolicies();

    List<JobEntity> getAllJobs();
}
