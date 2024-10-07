package org.pruebatecnica.controller;

import org.pruebatecnica.domain.dto.TaskDto;
import org.pruebatecnica.domain.dto.TaskCreateRequestDto;
import org.pruebatecnica.domain.dto.TaskUpdateRequestDto;
import org.pruebatecnica.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskCreateRequestDto taskCreateRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(taskCreateRequestDto));
    }
    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTasks(){
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getAllTasks());
    }
    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> updateTask(@RequestBody TaskUpdateRequestDto taskUpdateRequestDto, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.updateTask(taskUpdateRequestDto, id));
    }
    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getTask(id));
    }
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
    @PutMapping("/state/{id}")
    public void  updateSate(@PathVariable Long id){
        taskService.changeState(id);
    }

}
