package com.assignment.policyjob.dto.request;

import lombok.Data;


@Data
public class CreateJobDto {
    private String name;
    private Long policyId;
}

