package com.crud.tasks.controller;

        import com.crud.tasks.domain.Task;
        import com.crud.tasks.domain.TaskDto;
        import com.crud.tasks.domain.TrelloBoardDto;
        import com.crud.tasks.domain.TrelloListDto;
        import com.crud.tasks.mapper.TaskMapper;
        import com.crud.tasks.service.DbService;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.mockito.junit.MockitoJUnitRunner;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
        import org.springframework.boot.test.mock.mockito.MockBean;
        import org.springframework.http.MediaType;
        import org.springframework.test.context.junit4.SpringRunner;
        import org.springframework.test.web.servlet.MockMvc;

        import java.util.ArrayList;
        import java.util.List;

        import static org.hamcrest.CoreMatchers.is;
        import static org.hamcrest.Matchers.hasSize;
        import static org.mockito.Mockito.when;
        import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    TaskMapper taskMapper;

    @MockBean
    DbService service;

    @Test
    public void testGetTasks() throws Exception {

        List<Task> tasks = new ArrayList<>();
        Task task1 = new Task(1L, "Homework", "Ex 21.2");
        tasks.add(task1);
        when(service.getAllTasks()).thenReturn(tasks);
        //When&Then
        mockMvc.perform(get("/v1/task/getTasks")
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id",is("1")))
                .andExpect(jsonPath("$[0].title",is("Homework")))
                .andExpect(jsonPath("$[0].content",is("Ex 21.2")));
    }
}
