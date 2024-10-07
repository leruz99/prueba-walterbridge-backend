package org.pruebatecnica.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.pruebatecnica.domain.dto.TaskDto;
import org.pruebatecnica.domain.dto.TaskCreateRequestDto;
import org.pruebatecnica.domain.dto.TaskUpdateRequestDto;
import org.pruebatecnica.domain.entities.Task;
import org.pruebatecnica.domain.mappers.TaskMapper;
import org.pruebatecnica.exceptions.TaskNotFoundException;
import org.pruebatecnica.repository.TaskRepository;
import org.pruebatecnica.service.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final String apiUrl = "https://zenquotes.io/api/random";

    private final TaskRepository taskRepository;


    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public String getRandomQuote() {

        try {
            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(apiUrl, String.class);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response);

            // Retorna la frase motivacional del campo "q"
            return root.get(0).get("q").asText();
        } catch (Exception e) {
            return "No quote available"; // En caso de error
        }

    }

    @Override
    public TaskDto createTask(TaskCreateRequestDto taskCreateRequestDto) {
        Task task = TaskMapper.toTask(taskCreateRequestDto);
        String quote = getRandomQuote();
        task.setQuote(quote);
        return TaskMapper.toTaskDto(taskRepository.save(task));
    }

    @Override
    public TaskDto updateTask(TaskUpdateRequestDto taskUpdateRequestDto, Long id) {
        Optional<Task> taskDB = taskRepository.findById(id);
        if (taskDB.isPresent()) {
            taskDB.get().setTitle(taskUpdateRequestDto.title());
            taskDB.get().setDescription(taskUpdateRequestDto.description());
            taskDB.get().setCompleted(taskUpdateRequestDto.completed());
            taskDB.get().setQuote(taskUpdateRequestDto.quote());
            Task task = taskRepository.save(taskDB.get());
            return TaskMapper.toTaskDto(task);
        }
        throw new TaskNotFoundException("Task not found");

    }

    @Override
    public TaskDto getTask(Long id) {
        Optional<Task> taskDB = taskRepository.findById(id);
        if (taskDB.isPresent()) {
            return TaskMapper.toTaskDto(taskRepository.findById(id).get());

        }
        throw new TaskNotFoundException("Task not found");

    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<TaskDto> getAllTasks() {
        List<Task> taskList = taskRepository.findAll();
        return taskList.stream()
                .map(TaskMapper::toTaskDto)
                .collect(Collectors.toList());
    }

    @Override
    public void changeState(Long id) {
        Task task = taskRepository.findById(id).get();
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }

}
