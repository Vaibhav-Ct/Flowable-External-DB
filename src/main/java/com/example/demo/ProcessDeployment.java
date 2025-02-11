package com.example.demo;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.ProcessEngines;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Deployment;

public class ProcessDeployment {
    public static void main(String[] args) {
//        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        ProcessEngine processEngine = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("flowable.cfg.xml")
                .buildProcessEngine();

        System.out.println("ProcessEngine: " + processEngine);

        RepositoryService repositoryService = processEngine.getRepositoryService();

        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("processes/my-process.bpmn20.xml")
                .name("My Process Deployment")
                .deploy();

        System.out.println("Deployment ID: " + deployment.getId());
    }
}
