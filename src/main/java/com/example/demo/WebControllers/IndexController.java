package com.example.demo.WebControllers;

import com.example.demo.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    TaskService taskService;

    @GetMapping("")
    public String getIndex(Model model) {
        model.addAttribute("tasks", taskService.getTasks());
        return "index";
    }

    @GetMapping("/complete")
    public String completeTask(@RequestParam UUID taskId){
        taskService.deleteTask(taskId);
        return "redirect:/";
    }
}
