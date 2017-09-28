package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
    @RequestMapping("/v1/task")
    public class TaskController {
        @Autowired
        private DbService service;
        @Autowired
        private TaskMapper taskMapper;

        @RequestMapping(method = RequestMethod.GET, value = "getTasks")
        public List<TaskDto> getTasks(){
            return taskMapper.mapToTaskDtoList(service.getAllTasks());
        }
        @RequestMapping(method = RequestMethod.GET, value = "getTask")
        public TaskDto getTask(@RequestParam Long id) throws TaskNotFoundException {
            return taskMapper.mapToTaskDto(service.getTaskWithId(id).orElseThrow(TaskNotFoundException::new));
        }
        @RequestMapping(method = RequestMethod.POST, value = "createTask",consumes = APPLICATION_JSON_VALUE)
        public void createTask(@RequestBody TaskDto taskDto){
            service.saveTask(taskMapper.mapToTask(taskDto));
        }
        @RequestMapping(method = RequestMethod.PUT, value = "updateTask")
        public TaskDto updateTask(@RequestBody TaskDto taskDto){
            return taskMapper.mapToTaskDto(service.saveTask(taskMapper.mapToTask(taskDto)));
        }
        @RequestMapping(method = RequestMethod.DELETE, value = "deleteTask")
        public void deleteTask(@RequestParam Long id)throws TaskNotFoundException {
           service.deleteTaskWithId(id);
        }

//        return new ArrayList<>();
//    }
//    @RequestMapping(method = RequestMethod.GET,value = "getTask")
//    public TaskDto getTask(String taskId){
//        return new TaskDto((long)1, "test title", "test content");
//    }
//    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTask")
//    public void deleteTask(String taskId){
//
//    }
//    @RequestMapping(method = RequestMethod.PUT, value = "updateTask")
//    public TaskDto updateTask(String taskId){
//           return new TaskDto((long)1, "Edited test title", "Test content");
//    }
//    @RequestMapping(method =  RequestMethod.POST, value = "createTask")
//    public void createTask(TaskDto taskDto){
//    }
}
