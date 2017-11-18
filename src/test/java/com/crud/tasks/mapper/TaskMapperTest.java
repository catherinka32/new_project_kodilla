package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTest {
    @Autowired
    TaskMapper taskMapper;
    @Test
    public void testMapToTask(){
        //Given
        TaskMapper taskMapper1 = new TaskMapper();
        TaskDto taskDto = new TaskDto(5l,"Walls painting","Kitchen and livingroom" );
        //When
        Task resultTask = taskMapper1.mapToTask(taskDto);
        //Then
        assertEquals(taskDto.getId(),resultTask.getId());
        assertEquals(taskDto.getContent(),resultTask.getContent());
        assertEquals(taskDto.getTitle(),resultTask.getTitle());
    }
    @Test
    public void testMapToTaskDto(){
        //Given
        TaskMapper taskMapper2 = new TaskMapper();
        Task task2 = new Task(4l,"Roof painting","Be careful!" );
        //When
        TaskDto resultTaskDto = taskMapper2.mapToTaskDto(task2);
        //Then
        assertEquals(task2.getId(),resultTaskDto.getId());
        assertEquals(task2.getContent(),resultTaskDto.getContent());
        assertEquals(task2.getTitle(),resultTaskDto.getTitle());
    }
    @Test
    public void testMapToTaskDtoList(){
        //Given
        TaskMapper taskMapper3 = new TaskMapper();
        List<Task> taskList = new ArrayList<>();
        Task task = new Task(5l,"Walls painting","Kitchen and livingroom" );
        taskList.add(task);
        //When
        List <TaskDto> resultDtoList = taskMapper3.mapToTaskDtoList(taskList);
        //Then
        assertEquals(taskList.get(0).getId(),resultDtoList.get(0).getId());
        assertEquals(resultDtoList.get(0).getTitle(),resultDtoList.get(0).getTitle());
        assertEquals(resultDtoList.get(0).getContent(),resultDtoList.get(0).getContent());
    }
}
