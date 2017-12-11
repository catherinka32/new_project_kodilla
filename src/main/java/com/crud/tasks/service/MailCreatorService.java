package com.crud.tasks.service;


import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailCreatorService {
    @Autowired
    private AdminConfig adminConfig;
    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;
    @Autowired
    TaskRepository taskRepository;

    public String buildTrelloCardEmail(String message) {
        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allows sending tasks to Trello");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url","http://localhost:8888/tasks_frontendII");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("company_details", adminConfig.getCompanyName());
        context.setVariable("company_phone", adminConfig.getCompanyPhone());
        context.setVariable("goodbye_message", "Thank you for using our service");
        context.setVariable("show_button", false);
        context.setVariable("is_friend",false );
        context.setVariable("admin_config", adminConfig);
        context.setVariable("application_functionality",functionality);
        return templateEngine.process("mail/created-trello-card-mail", context);
    }
    public String buildEverydaysTaskStateEmail(String message){
        List<String> functionality = new ArrayList<>();
        functionality.add("What are you doing tonight ? ");
        functionality.add("Look, your 'to do list' is full");
        functionality.add("So ..go back to the first question :)");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("preview_message", " Tasks in Trello");
        context.setVariable("tasks_url","http://localhost:8888/tasks_frontendII");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_config", adminConfig);
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("company_details", adminConfig.getCompanyName());
        context.setVariable("company_phone", adminConfig.getCompanyPhone());
        context.setVariable("goodbye_message", "See you tomorrow :)");
        context.setVariable("show_button", true);
        context.setVariable("is_commonUser", false);
        context.setVariable("application_functionality",functionality);
        return templateEngine.process("mail/created-everydays-raport-email", context);
    }
}