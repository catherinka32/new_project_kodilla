package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/v1/task")
public class TaskController {
    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
    public List<TaskDto> getTasks(){
        return new ArrayList<>();
    }
    @RequestMapping(method = RequestMethod.GET,value = "getTask")
    public TaskDto getTask(String taskId){
        return new TaskDto((long)1, "test title", "test content");
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTask")
    public void deleteTask(String taskId){

    }
    @RequestMapping(method = RequestMethod.PUT, value = "updateTask")
    public TaskDto updateTask(String taskId){
           return new TaskDto((long)1, "Edited test title", "Test content");
    }
    @RequestMapping(method =  RequestMethod.POST, value = "createTask")
    public void createTask(TaskDto taskDto){
    }
}
