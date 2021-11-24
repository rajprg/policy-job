package com.assignment.policyjob.service;

import com.assignment.policyjob.dto.request.CreateJobDto;
import com.assignment.policyjob.dto.request.CreatePolicyDto;
import com.assignment.policyjob.exceptions.DataException;
import com.assignment.policyjob.model.JobEntity;
import com.assignment.policyjob.model.PolicyEntity;
import com.assignment.policyjob.repo.JobRepo;
import com.assignment.policyjob.repo.PolicyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PolicyJobServiceImpl implements PolicyJobService{

    @Autowired
    PolicyRepo policyRepo;

    @Autowired
    JobRepo jobRepo;

    private DataException notFound() {
        return new DataException("Fail","Not Found", HttpStatus.NOT_FOUND, "Exception");
    }


    @Override
    public Object savePolicy(CreatePolicyDto createPolicyDto) throws DataException {

        PolicyEntity policyEntity =  new PolicyEntity();

        policyEntity.setName(createPolicyDto.getName());
        policyEntity.setPolicyDefinition(createPolicyDto.getPolicyDefinition());

        policyRepo.save(policyEntity);

        return policyEntity;
    }

    @Override
    public Object saveJob(CreateJobDto createJobDto) throws DataException {
        JobEntity jobEntity =  new JobEntity();
        PolicyEntity policyEntity =  new PolicyEntity();

        jobEntity.setName(createJobDto.getName());
        jobEntity.setPolicyId(createJobDto.getPolicyId());

        jobRepo.save(jobEntity);

        return jobEntity;
    }

    @Override
    public Object getPolicyById(Long policyId) throws DataException {

        PolicyEntity policyEntity =
                policyRepo
                        .findById(policyId)
                        .orElseThrow(() -> notFound());

        return policyEntity;


    }


    @Override
    public Object getJobById(Long jobId) throws DataException {

        JobEntity jobEntity =
                    jobRepo
                        .findById(jobId)
                        .orElseThrow(() -> notFound());
        return jobEntity;

    }

    @Override
    public Object updatePolicy(Long policyId, CreatePolicyDto createPolicyDto) throws DataException {
        PolicyEntity policyEntity =
                  policyRepo
                        .findById(policyId)
                        .orElseThrow(() -> notFound());

        policyEntity.setName(createPolicyDto.getName());
        policyEntity.setPolicyDefinition(createPolicyDto.getPolicyDefinition());

        policyRepo.save(policyEntity);

        return policyEntity;

    }

    @Override
    public Object updateJob(Long jobId, CreateJobDto createJobDto) throws DataException {
       JobEntity jobEntity =
                   jobRepo
                        .findById(jobId)
                        .orElseThrow(() -> notFound());

        jobEntity.setName(createJobDto.getName());
        jobEntity.setPolicyId(createJobDto.getPolicyId());

        jobRepo.save(jobEntity);

        return jobEntity;
    }

    @Override
    public String deletePolicyById(Long policyId) throws DataException {
        PolicyEntity policyEntity =
                policyRepo
                        .findById(policyId)
                        .orElseThrow(() -> notFound());

        policyRepo.deleteById(policyId);
        return "Deletion Done of id :" + policyId;
    }

    @Override
    public String deleteJobById(Long jobId) throws DataException {
        JobEntity jobEntity =
                    jobRepo
                        .findById(jobId)
                        .orElseThrow(() -> notFound());
        jobRepo.deleteById(jobId);
        return "Deletion Done of id :" + jobId;
    }

    @Override
    public Object getJobByPolicyId(Long policyId) throws DataException {
        JobEntity jobEntity =
                jobRepo
                        .findByPolicyId(policyId)
                        .orElseThrow(() -> notFound());
        return jobEntity;
    }

    @Override
    public Object getPolicyByJobId(Long jobId) throws DataException {
        JobEntity jobEntity =
                    jobRepo
                        .findById(jobId)
                        .orElseThrow(() -> notFound());
        PolicyEntity policyEntity =
                          policyRepo
                                  .findById(jobEntity.getPolicyId())
                                  .orElseThrow(() -> notFound());
        return policyEntity;
    }

    @Override
    public List<PolicyEntity> getAllPolicies()  {
        List<PolicyEntity> policyEntities = policyRepo.findAll();
        return policyEntities;
    }

    @Override
    public List<JobEntity> getAllJobs() {
        List<JobEntity> jobEntities = jobRepo.findAll();
        return jobEntities;
    }
}
