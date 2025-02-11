package com.example.demo;

import org.flowable.engine.*;

public class ProcessEngineSetup {
    public static void main(String[] args) {
        // Initialize the Process Engine
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // Get Flowable Services
        RepositoryService repositoryService = processEngine.getRepositoryService();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        TaskService taskService = processEngine.getTaskService();
        IdentityService identityService = processEngine.getIdentityService();
        HistoryService historyService = processEngine.getHistoryService();
        FormService formService = processEngine.getFormService();
        ManagementService managementService = processEngine.getManagementService();
        DynamicBpmnService dynamicBpmnService = processEngine.getDynamicBpmnService();

        System.out.println("Process Engine initialized successfully!");
    }
}
