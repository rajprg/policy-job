package com.assignment.policyjob.controller;


import com.assignment.policyjob.dto.request.CreateJobDto;
import com.assignment.policyjob.dto.request.CreatePolicyDto;
import com.assignment.policyjob.exceptions.DataException;
import com.assignment.policyjob.model.JobEntity;
import com.assignment.policyjob.model.PolicyEntity;
import com.assignment.policyjob.model.ResponseEntityBody;
import com.assignment.policyjob.service.PolicyJobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
public class PolicyJobController {


    @Autowired
    PolicyJobService policyJobService;

    //Post Api to create policy
    @PostMapping(
            value = "/create-policy",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseEntityBody> savePolicy(
            @RequestBody CreatePolicyDto createPolicyDto) {

        log.info("createPolicy Dto : {}", createPolicyDto);
        ResponseEntityBody responseEntityBody = new ResponseEntityBody();

        try {
            Object response = policyJobService.savePolicy(createPolicyDto);

                responseEntityBody.setStatus(HttpStatus.OK);
                responseEntityBody.setStatusCode(HttpStatus.OK.value());
                responseEntityBody.setMessage("Policy Created Successfully");
                responseEntityBody.setData(response);

        } catch (DataException e) {
            responseEntityBody.setStatus(e.getHttpStatus());
            responseEntityBody.setStatusCode(e.getHttpStatus().value());
            responseEntityBody.setMessage("Error saving policy");
        }
        return ResponseEntity.ok(responseEntityBody);
    }

    //Post Api to create job
    @PostMapping(
            value = "/create-job",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseEntityBody> savePolicy(
            @RequestBody CreateJobDto createJobDto) {

        log.info("createJob Dto : {}", createJobDto);
        ResponseEntityBody responseEntityBody = new ResponseEntityBody();

        try {
            Object response = policyJobService.saveJob(createJobDto);

            responseEntityBody.setStatus(HttpStatus.OK);
            responseEntityBody.setStatusCode(HttpStatus.OK.value());
            responseEntityBody.setMessage("Job Created Successfully");
            responseEntityBody.setData(response);

        } catch (DataException e) {
            responseEntityBody.setStatus(e.getHttpStatus());
            responseEntityBody.setStatusCode(e.getHttpStatus().value());
            responseEntityBody.setMessage("Error saving policy");
        }
        return ResponseEntity.ok(responseEntityBody);
    }


    //Get Api to fetch policy by id
    @GetMapping(
            value = "/find-policy-by-id/{policyId}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getPolicyById(@PathVariable("policyId") Long policyId) {

        ResponseEntityBody responseEntityBody = new ResponseEntityBody();


        try {
            Object response = policyJobService.getPolicyById(policyId);

            responseEntityBody.setStatus(HttpStatus.OK);
            responseEntityBody.setStatusCode(HttpStatus.OK.value());
            responseEntityBody.setMessage("Policy Details fetched successfully");
            responseEntityBody.setData(response);

        } catch (DataException e) {
            responseEntityBody.setStatus(e.getHttpStatus());
            responseEntityBody.setStatusCode(e.getHttpStatus().value());
            responseEntityBody.setMessage("Error fetching policy details");
        }
        return ResponseEntity.ok(responseEntityBody);
    }

    //Get Api to fetch job by id
    @GetMapping(
            value = "/find-job-by-id/{jobId}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getJobById(@PathVariable("jobId") Long jobId) {

        ResponseEntityBody responseEntityBody = new ResponseEntityBody();


        try {
            Object response = policyJobService.getJobById(jobId);
            responseEntityBody.setStatus(HttpStatus.OK);
            responseEntityBody.setStatusCode(HttpStatus.OK.value());
            responseEntityBody.setMessage("Job Details fetched successfully");
            responseEntityBody.setData(response);

        } catch (DataException e) {
            responseEntityBody.setStatus(e.getHttpStatus());
            responseEntityBody.setStatusCode(e.getHttpStatus().value());
            responseEntityBody.setMessage("Error fetching Job details");
        }
        return ResponseEntity.ok(responseEntityBody);
    }

    //Put Api to update policy by id
    @PutMapping(
            value = "/update-policy/{policyId}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updatePolicy(
            @PathVariable Long policyId, @RequestBody CreatePolicyDto createPolicyDto) {

        ResponseEntityBody responseEntityBody = new ResponseEntityBody();

        try {
            Object response = policyJobService.updatePolicy(policyId,createPolicyDto);

            responseEntityBody.setStatus(HttpStatus.OK);
            responseEntityBody.setStatusCode(HttpStatus.OK.value());
            responseEntityBody.setMessage("Policy Updated Successfully");
            responseEntityBody.setData(response);

        } catch (DataException e) {
            responseEntityBody.setStatus(e.getHttpStatus());
            responseEntityBody.setStatusCode(e.getHttpStatus().value());
            responseEntityBody.setMessage("Error updating policy");
        }
        return ResponseEntity.ok(responseEntityBody);
    }

    //Put Api to update job by id
    @PutMapping(
            value = "/update-job/{jobId}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateJob(
            @PathVariable Long jobId, @RequestBody CreateJobDto createJobDto) {

        ResponseEntityBody responseEntityBody = new ResponseEntityBody();

        try {
            Object response = policyJobService.updateJob(jobId,createJobDto);

            responseEntityBody.setStatus(HttpStatus.OK);
            responseEntityBody.setStatusCode(HttpStatus.OK.value());
            responseEntityBody.setMessage("Job Updated Successfully");
            responseEntityBody.setData(response);

        } catch (DataException e) {
            responseEntityBody.setStatus(e.getHttpStatus());
            responseEntityBody.setStatusCode(e.getHttpStatus().value());
            responseEntityBody.setMessage("Error updating job");
        }
        return ResponseEntity.ok(responseEntityBody);
    }


    //Delete Api to delete policy by id
    @DeleteMapping(
            value = "/delete-policy-by-id/{policyId}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deletePolicyById(@PathVariable("policyId") Long policyId) {

        ResponseEntityBody responseEntityBody = new ResponseEntityBody();


        try {
            String response = policyJobService.deletePolicyById(policyId);

            responseEntityBody.setStatus(HttpStatus.OK);
            responseEntityBody.setStatusCode(HttpStatus.OK.value());
            responseEntityBody.setMessage("Policy Details deleted successfully");
            responseEntityBody.setData(response);

        } catch (DataException e) {
            responseEntityBody.setStatus(e.getHttpStatus());
            responseEntityBody.setStatusCode(e.getHttpStatus().value());
            responseEntityBody.setMessage("Error deleting policy details");
        }
        return ResponseEntity.ok(responseEntityBody);
    }

    //Delete Api to delete job by id
    @DeleteMapping(
            value = "/delete-job-by-id/{jobId}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteJobById(@PathVariable("jobId") Long jobId) {

        ResponseEntityBody responseEntityBody = new ResponseEntityBody();


        try {
            String response = policyJobService.deleteJobById(jobId);

            responseEntityBody.setStatus(HttpStatus.OK);
            responseEntityBody.setStatusCode(HttpStatus.OK.value());
            responseEntityBody.setMessage("Job Details deleted successfully");
            responseEntityBody.setData(response);

        } catch (DataException e) {
            responseEntityBody.setStatus(e.getHttpStatus());
            responseEntityBody.setStatusCode(e.getHttpStatus().value());
            responseEntityBody.setMessage("Error deleting job details");
        }
        return ResponseEntity.ok(responseEntityBody);
    }


    //Get Api to find job by policy id
    @GetMapping(
            value = "/find-job-by-policyid/{policyId}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getJobByPolicyId(@PathVariable("policyId") Long policyId) {

        ResponseEntityBody responseEntityBody = new ResponseEntityBody();


        try {
            Object response = policyJobService.getJobByPolicyId(policyId);
            responseEntityBody.setStatus(HttpStatus.OK);
            responseEntityBody.setStatusCode(HttpStatus.OK.value());
            responseEntityBody.setMessage("Job Details fetched successfully");
            responseEntityBody.setData(response);

        } catch (DataException e) {
            responseEntityBody.setStatus(e.getHttpStatus());
            responseEntityBody.setStatusCode(e.getHttpStatus().value());
            responseEntityBody.setMessage("Error fetching Job details");
        }
        return ResponseEntity.ok(responseEntityBody);
    }

    //Get Api to find policy by job id
    @GetMapping(
            value = "/find-policy-by-jobid/{jobId}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getPolicyByJobId(@PathVariable("jobId") Long jobId) {

        ResponseEntityBody responseEntityBody = new ResponseEntityBody();


        try {
            Object response = policyJobService.getPolicyByJobId(jobId);
            responseEntityBody.setStatus(HttpStatus.OK);
            responseEntityBody.setStatusCode(HttpStatus.OK.value());
            responseEntityBody.setMessage("Policy Details fetched successfully");
            responseEntityBody.setData(response);

        } catch (DataException e) {
            responseEntityBody.setStatus(e.getHttpStatus());
            responseEntityBody.setStatusCode(e.getHttpStatus().value());
            responseEntityBody.setMessage("Error fetching Policy details");
        }
        return ResponseEntity.ok(responseEntityBody);
    }

    //Get Api to find all policies
    @GetMapping(
            value = "/find-all-policies",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getAllPolicies() {

        ResponseEntityBody responseEntityBody = new ResponseEntityBody();


        try {
            List<PolicyEntity> response = policyJobService.getAllPolicies();
            responseEntityBody.setStatus(HttpStatus.OK);
            responseEntityBody.setStatusCode(HttpStatus.OK.value());
            responseEntityBody.setMessage("All Policy Details fetched successfully");
            responseEntityBody.setData(response);

        } catch (Exception e) {
            responseEntityBody.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            responseEntityBody.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            responseEntityBody.setMessage("Error fetching all Policy details");
        }
        return ResponseEntity.ok(responseEntityBody);
    }

    //Get Api to find all jobs
    @GetMapping(
            value = "/find-all-jobs",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getAllJobs() {

        ResponseEntityBody responseEntityBody = new ResponseEntityBody();


        try {
            List<JobEntity> response = policyJobService.getAllJobs();
            responseEntityBody.setStatus(HttpStatus.OK);
            responseEntityBody.setStatusCode(HttpStatus.OK.value());
            responseEntityBody.setMessage("All Jobs Details fetched successfully");
            responseEntityBody.setData(response);

        } catch (Exception e) {
            responseEntityBody.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            responseEntityBody.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            responseEntityBody.setMessage("Error fetching all Job details");
        }
        return ResponseEntity.ok(responseEntityBody);
    }


}
