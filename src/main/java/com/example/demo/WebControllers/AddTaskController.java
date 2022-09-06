package com.example.demo.WebControllers;

import com.example.demo.Entity.Task;
import com.example.demo.Enums.Category;
import com.example.demo.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/new")
public class AddTaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("")
    public String getAddTask(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);
        model.addAttribute("categories", Category.values());
        return "add";
    }

    @PostMapping("/addTask")
    public String postAdd(@ModelAttribute @Validated Task task, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "add";
        }
        taskService.saveTask(task);
        taskService.saveTaskJSON();
        return "redirect:/";
    }
}
