package com.example.TaskManager.Service;


import com.example.TaskManager.Repository.TaskRepository;
import com.example.TaskManager.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getTasksByPriority(String priority) {
        return taskRepository.findByPriority(priority);
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
    public Task updateTaskText(Long id, String newText) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            task.setText(newText);
            return taskRepository.save(task);
        }
        return null;
    }

    public Task updateTaskStatus(Long id, String newStatus) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            task.setPriority(newStatus);
            return taskRepository.save(task);
        }
        return null;
    }
    public Task updateTaskPriority( Long id, String newPriority) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setPriority(newPriority);
            return taskRepository.save(task);
        }
        throw new RuntimeException("Task not found");
    }


}