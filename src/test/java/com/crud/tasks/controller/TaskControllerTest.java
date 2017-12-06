package com.crud.tasks.controller;

        import com.crud.tasks.domain.Task;
        import com.crud.tasks.domain.TaskDto;
        import com.crud.tasks.mapper.TaskMapper;
        import com.crud.tasks.service.DbService;
        import com.google.gson.Gson;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
        import org.springframework.boot.test.mock.mockito.MockBean;
        import org.springframework.http.MediaType;
        import org.springframework.test.context.junit4.SpringRunner;
        import org.springframework.test.web.servlet.MockMvc;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Optional;
        import static org.hamcrest.CoreMatchers.is;
        import static org.hamcrest.Matchers.hasSize;
        import static org.mockito.ArgumentMatchers.any;
        import static org.mockito.ArgumentMatchers.anyList;
        import static org.mockito.Mockito.when;
        import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
        import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
        import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
        import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    TaskMapper taskMapper;

    @MockBean
    DbService service;

    @Test
    public void testGetTasks() throws Exception {

        List<Task> tasks = new ArrayList<>();
        Task task1 = new Task(1L, "Homework", "Ex 21.2");
        tasks.add(task1);
        List<TaskDto> tasksDto = new ArrayList<>();
        tasksDto.add((new TaskDto(task1.getId(), task1.getTitle(), task1.getContent())));
        when(service.getAllTasks()).thenReturn(tasks);
        when(taskMapper.mapToTaskDtoList(anyList())).thenReturn(tasksDto);
        //When&Then
        mockMvc.perform(get("/v1/task/getTasks")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].title", is("Homework")))
                .andExpect(jsonPath("$[0].content", is("Ex 21.2")));
    }
    @Test
    public void testGetTask() throws Exception {
        List<Task> tasks = new ArrayList<>();
        Task task1 = new Task(1L, "Homework", "Ex 21.2");
        tasks.add(task1);
        TaskDto taskDto = new TaskDto(task1.getId(), task1.getTitle(), task1.getContent());
        when(service.getTask(1L)).thenReturn(Optional.ofNullable(task1));
        when(taskMapper.mapToTaskDto(task1)).thenReturn(taskDto);
        //When&Then
        mockMvc.perform(get("/v1/task/getTask")
                .contentType(MediaType.APPLICATION_JSON)
                .param("taskId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("Homework")))
                .andExpect(jsonPath("$.content", is("Ex 21.2")));
    }
    @Test
    public void testUpdateTask() throws Exception {
        //Given
        Task task = new Task(2L, "Task", "Something new");
        TaskDto taskDto = new TaskDto(task.getId(), task.getTitle(), task.getContent());

        when(service.saveTask(task)).thenReturn(task);
        when(taskMapper.mapToTask(any(TaskDto.class))).thenReturn(task);
        when(taskMapper.mapToTaskDto(task)).thenReturn(taskDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(taskDto);

        //When & Then
        mockMvc.perform(put("/v1/task/updateTask")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(2)))
                .andExpect(jsonPath("$.title", is("Task")))
                .andExpect(jsonPath("$.content", is("Something new")));
    }

    @Test
    public void testdDeleteTask() throws Exception {
        //Given
        //When & Then
        mockMvc.perform(delete("/v1/task/deleteTask")
                        .param("taskId", "2"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateTask() throws Exception {
        //Given
        Task task = new Task(1l, "Task", "Test task");
        TaskDto taskDto = new TaskDto(task.getId(),task.getTitle(), task.getContent());

        when(service.saveTask(task)).thenReturn(task);
        when(taskMapper.mapToTask(any(TaskDto.class))).thenReturn(task);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(taskDto);

        //When & Then
        mockMvc.perform(post("/v1/task/createTask")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }
}
