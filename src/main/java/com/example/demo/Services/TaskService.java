package com.example.demo.Services;

import com.example.demo.Entity.Task;
import com.example.demo.Repositories.TaskRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    private final String FILE_PATH = "src/main/resources/static/tasks.json";
    private final ObjectMapper TO_JSON = new ObjectMapper();

    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

    public void saveTask(Task task) {
        taskRepository.save(task);
        System.out.println("Dupa");
    }

    public void deleteTask(UUID id) {
        taskRepository.deleteById(id);
    }

    public void saveTaskJSON(){
        try {
            TO_JSON.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), getTasks());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
