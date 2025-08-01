package com.app.spring_todo_app.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.spring_todo_app.entities.Task;
import com.app.spring_todo_app.services.TaskService;


@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping  
    public String getTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "task";
    }

    @PostMapping
    public String createTask(@RequestParam String title) {
        taskService.createTask(title);

        return "redirect:/";
    }

    @GetMapping("/{id}/delete")  
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
         return "redirect:/";
    }

    @GetMapping("/{id}/toggle")  
    public String toggleTask(@PathVariable Long id) {
        taskService.toggleTask(id);
         return "redirect:/";
    }
}
