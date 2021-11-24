
*HAVE USED POSTGRES DATABASE TO CONNECT TO SPRING BOOT PROJECT*

# SCRIPTS TO CREATE POLICY AND JOB TABLES IN POSTGRES

*Policy Table :*

 -- Table: public.policy

-- DROP TABLE public.policy;

CREATE TABLE IF NOT EXISTS public.policy
(
    id integer NOT NULL DEFAULT nextval('policy_id_seq'::regclass),
    name character varying COLLATE pg_catalog."default",
    policy_definition character varying COLLATE pg_catalog."default",
    created_at character varying COLLATE pg_catalog."default",
    updated_at character varying COLLATE pg_catalog."default",
    CONSTRAINT policy_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.policy
    OWNER to postgres;

*Job Table :*

-- Table: public.job

-- DROP TABLE public.job;

CREATE TABLE IF NOT EXISTS public.job
(
    id integer NOT NULL DEFAULT nextval('job_id_seq'::regclass),
    policy_id integer,
    name character varying COLLATE pg_catalog."default",
    created_at character varying COLLATE pg_catalog."default",
    updated_at character varying COLLATE pg_catalog."default",
    CONSTRAINT job_pkey PRIMARY KEY (id),
    CONSTRAINT job_policy_id_fkey FOREIGN KEY (policy_id)
        REFERENCES public.policy (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.job
    OWNER to postgres;
    
    
    
# END POINTS USED 

1. CREATE POLICY
POST : localhost:8080/create-policy

Request:
{
    "name": "Crypto",
    "policyDefinition": "Crypto Regulations"
}

Response :
{
    "status": "OK",
    "message": "Policy Created Successfully",
    "path": null,
    "statusCode": 200,
    "data": {
        "id": 7,
        "name": "Crypto",
        "policyDefinition": "Crypto Regulations",
        "createdAt": "2021-11-23T19:37:03.486",
        "updatedAt": "2021-11-23T19:37:03.486"
    },
    "body": null
}

![](https://github.com/rajprg/policy-job/blob/main/policy-job/images/Screenshot%20from%202021-11-23%2019-37-20.png)

2.CREATE JOB
POST : localhost:8080/create-job

Request:
{
    "name": "Regulator",
    "policyId": 7
}

Response :
{
    "status": "OK",
    "message": "Job Created Successfully",
    "path": null,
    "statusCode": 200,
    "data": {
        "id": 7,
        "name": "Regulator",
        "policyId": 7,
        "createdAt": "2021-11-23T19:38:44.191",
        "updatedAt": "2021-11-23T19:38:44.191"
    },
    "body": null
}

![](https://github.com/rajprg/policy-job/blob/main/policy-job/images/Screenshot%20from%202021-11-23%2019-38-51.png)

3. FIND POLICY BY ID
GET : localhost:8080/find-policy-by-id/7

Response :
{
    "status": "OK",
    "message": "Policy Details fetched successfully",
    "path": null,
    "statusCode": 200,
    "data": {
        "id": 7,
        "name": "Crypto",
        "policyDefinition": "Crypto Regulations",
        "createdAt": "2021-11-23T19:37:03.486",
        "updatedAt": "2021-11-23T19:37:03.486"
    },
    "body": null
}
![](https://github.com/rajprg/policy-job/blob/main/policy-job/images/Screenshot%20from%202021-11-23%2019-39-42.png)

4. FIND JOB BY ID
GET : localhost:8080/find-job-by-id/7

Response :
{
    "status": "OK",
    "message": "Job Details fetched successfully",
    "path": null,
    "statusCode": 200,
    "data": {
        "id": 7,
        "name": "Regulator",
        "policyId": 7,
        "createdAt": "2021-11-23T19:38:44.191",
        "updatedAt": "2021-11-23T19:38:44.191"
    },
    "body": null
}
![](https://github.com/rajprg/policy-job/blob/main/policy-job/images/Screenshot%20from%202021-11-23%2019-40-55.png)

5. UPDATE POLICY
PUT localhost:8080/update-policy/7

Request:
{
    "name": "Crypto-update",
    "policyDefinition": "Def Updated"
}

Response :
{
    "status": "OK",
    "message": "Policy Updated Successfully",
    "path": null,
    "statusCode": 200,
    "data": {
        "id": 7,
        "name": "Crypto-update",
        "policyDefinition": "Def Updated",
        "createdAt": "2021-11-23T19:37:03.486",
        "updatedAt": "2021-11-23T19:42:37.467"
    },
    "body": null
}
![](https://github.com/rajprg/policy-job/blob/main/policy-job/images/Screenshot%20from%202021-11-23%2019-42-43.png)

6. UPDATE JOB
PUT localhost:8080/update-job/7

Request:
{
    "name": "Regulator-updated",
    "policyId": 7
}

Response :
{
    "status": "OK",
    "message": "Job Updated Successfully",
    "path": null,
    "statusCode": 200,
    "data": {
        "id": 7,
        "name": "Regulator-updated",
        "policyId": 7,
        "createdAt": "2021-11-23T19:38:44.191",
        "updatedAt": "2021-11-23T19:44:03.771"
    },
    "body": null
}
![](https://github.com/rajprg/policy-job/blob/main/policy-job/images/Screenshot%20from%202021-11-23%2019-44-05.png)

7. FIND POLICY BY JOB ID
GET : localhost:8080/find-policy-by-jobid/9

Response :
{
    "status": "OK",
    "message": "Policy Details fetched successfully",
    "path": null,
    "statusCode": 200,
    "data": {
        "id": 7,
        "name": "Crypto-update",
        "policyDefinition": "Def Updated",
        "createdAt": "2021-11-23T19:37:03.486",
        "updatedAt": "2021-11-23T19:42:37.467"
    },
    "body": null
}
![](https://github.com/rajprg/policy-job/blob/main/policy-job/images/Screenshot%20from%202021-11-23%2019-48-08.png)

7. FIND JOB BY POLICY ID
GET : localhost:8080//find-job-by-policyid/4

Response :
{
    "status": "OK",
    "message": "Job Details fetched successfully",
    "path": null,
    "statusCode": 200,
    "data": {
        "id": 6,
        "name": "Actornew",
        "policyId": 4,
        "createdAt": "2021-11-22T20:10:16.056",
        "updatedAt": "2021-11-22T20:10:16.056"
    },
    "body": null
}



8. FIND ALL JOBS
GET localhost:8080/find-all-jobs

Response :
{
    "status": "OK",
    "message": "All Jobs Details fetched successfully",
    "path": null,
    "statusCode": 200,
    "data": [
        {
            "id": 1,
            "name": "Actor-updated",
            "policyId": 1,
            "createdAt": "2021-11-19T17:34:34.537",
            "updatedAt": "2021-11-22T19:50:54.307"
        },
        {
            "id": 5,
            "name": "Actornew",
            "policyId": 3,
            "createdAt": "2021-11-22T20:10:08.823",
            "updatedAt": "2021-11-22T20:10:08.823"
        },
        {
            "id": 6,
            "name": "Actornew",
            "policyId": 4,
            "createdAt": "2021-11-22T20:10:16.056",
            "updatedAt": "2021-11-22T20:10:16.056"
        },
        {
            "id": 7,
            "name": "Regulator-updated",
            "policyId": 7,
            "createdAt": "2021-11-23T19:38:44.191",
            "updatedAt": "2021-11-23T19:44:03.771"
        },
        {
            "id": 8,
            "name": "Job new",
            "policyId": 8,
            "createdAt": "2021-11-23T19:46:54.917",
            "updatedAt": "2021-11-23T19:46:54.917"
        },
        {
            "id": 9,
            "name": "Actornew",
            "policyId": 7,
            "createdAt": "2021-11-23T19:47:49.919",
            "updatedAt": "2021-11-23T19:47:49.919"
        }
    ],
    "body": null
}
![](https://github.com/rajprg/policy-job/blob/main/policy-job/images/Screenshot%20from%202021-11-23%2019-57-27.png)

10. FIND ALL POLICIES
GET localhost:8080/find-all-policies

Response :
{
    "status": "OK",
    "message": "All Policy Details fetched successfully",
    "path": null,
    "statusCode": 200,
    "data": [
        {
            "id": 5,
            "name": "Crypto",
            "policyDefinition": "Crypto Regulations",
            "createdAt": "2021-11-23T19:35:54.302",
            "updatedAt": "2021-11-23T19:35:54.302"
        },
        {
            "id": 6,
            "name": "Crypto",
            "policyDefinition": "Crypto Regulations",
            "createdAt": "2021-11-23T19:36:34.096",
            "updatedAt": "2021-11-23T19:36:34.096"
        },
        {
            "id": 7,
            "name": "Crypto-update",
            "policyDefinition": "Def Updated",
            "createdAt": "2021-11-23T19:37:03.486",
            "updatedAt": "2021-11-23T19:42:37.467"
        },
        {
            "id": 8,
            "name": "New",
            "policyDefinition": "Def",
            "createdAt": "2021-11-23T19:46:31.386",
            "updatedAt": "2021-11-23T19:46:31.386"
        },
        {
            "id": 1,
            "name": "Eg",
            "policyDefinition": "Eg def",
            "createdAt": "2021-11-19T17:06:10.397",
            "updatedAt": "2021-11-23T19:51:32.593"
        },
        {
            "id": 3,
            "name": "Eg1",
            "policyDefinition": "Eg def1",
            "createdAt": "2021-11-22T20:09:18.341",
            "updatedAt": "2021-11-23T19:51:52.11"
        },
        {
            "id": 4,
            "name": "Eg2",
            "policyDefinition": "Eg def2",
            "createdAt": "2021-11-22T20:09:41.194",
            "updatedAt": "2021-11-23T19:52:15.592"
        }
    ],
    "body": null
}
![](https://github.com/rajprg/policy-job/blob/main/policy-job/images/Screenshot%20from%202021-11-23%2019-57-11.png)

11. DELETE JOB BY ID
DELETE : localhost:8080/delete-job-by-id/6

Response :
{
    "status": "OK",
    "message": "Job Details deleted successfully",
    "path": null,
    "statusCode": 200,
    "data": "Deletion Done of id :6",
    "body": null
}
![](https://github.com/rajprg/policy-job/blob/main/policy-job/images/Screenshot%20from%202021-11-23%2019-54-18.png)

12. DELETE POLICY ID
DELETE : localhost:8080/delete-policy-by-id/4

Response :
{
    "status": "OK",
    "message": "Policy Details deleted successfully",
    "path": null,
    "statusCode": 200,
    "data": "Deletion Done of id :4",
    "body": null
}
![](https://github.com/rajprg/policy-job/blob/main/policy-job/images/Screenshot%20from%202021-11-23%2019-54-51.png)



