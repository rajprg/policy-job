package com.assignment.policyjob.dto.request;

import lombok.Data;


@Data
public class CreatePolicyDto {
    private String name;
    private String policyDefinition;
}

