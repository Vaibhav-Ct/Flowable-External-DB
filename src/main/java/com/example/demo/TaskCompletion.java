package com.example.demo;

import org.flowable.engine.*;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;

import java.util.List;

public class TaskCompletion {
    public static void main(String[] args) {

//        Process Engine initializes the Flowable engine.
//        Repository Service is accessed to handle process definition deployments.
//        Deployment uploads the process model to the Flowable engine.
//        Runtime Service is used to start process instances.
//        Process Instance tracks the execution of the running process.
//        Task Service allows you to interact with tasks in the running process.





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

        RuntimeService runtimeService = processEngine.getRuntimeService();

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess");
        System.out.println("Process Instance ID: " + processInstance.getId());

        TaskService taskService = processEngine.getTaskService();

        // Get all tasks for the process instance
        List<Task> tasks = taskService.createTaskQuery().list();

        for (Task task : tasks) {
            System.out.println("Task Name: " + task.getName());
            System.out.println("Task ID: " + task.getId());

            // Complete the task
            taskService.complete(task.getId());
            System.out.println("Task completed!");
        }
//        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//
//        // Get Flowable Services
//        RepositoryService repositoryService = processEngine.getRepositoryService();
//        RuntimeService runtimeService = processEngine.getRuntimeService();
//        TaskService taskService = processEngine.getTaskService();
    }
}
