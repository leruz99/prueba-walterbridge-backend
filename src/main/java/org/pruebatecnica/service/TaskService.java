package org.pruebatecnica.service;

import org.pruebatecnica.domain.dto.TaskDto;
import org.pruebatecnica.domain.dto.TaskCreateRequestDto;
import org.pruebatecnica.domain.dto.TaskUpdateRequestDto;

import java.util.List;

public interface TaskService {
    String getRandomQuote();
    TaskDto createTask(TaskCreateRequestDto taskCreateRequestDto);
    TaskDto updateTask(TaskUpdateRequestDto taskUpdateRequestDto, Long id);
    TaskDto getTask(Long id);
    void deleteTask(Long id);
    List<TaskDto> getAllTasks();
    void changeState(Long id);
}
