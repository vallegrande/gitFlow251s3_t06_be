package vallegrande.edu.pe.gitFlow242s3_t06_be.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vallegrande.edu.pe.gitFlow242s3_t06_be.model.Task;
import vallegrande.edu.pe.gitFlow242s3_t06_be.repository.TaskRepository;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task updateTask(Long id, Task taskDetails) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setStatus(taskDetails.getStatus());
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
    taskRepository.deleteById(id);
    }
}