//package com.crud.tasks.service;
//
//import com.crud.tasks.domain.Task;
//import com.crud.tasks.repository.TaskRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class DbServiceTest {
////    @Autowired
////    DbService dbService;
//    @Autowired
//    TaskRepository repository;
//    @Test
//    public void testGetAllTasks()throws Exception{
//        //Given
//        DbService dbService = new DbService();
//        List<Task> taskList = new ArrayList<>();
//        taskList.add(new Task());
//        //When
//        List<Task> resultList = dbService.getAllTasks();
//        //Then
//        assertEquals(1, resultList.size());
//    }
//}
