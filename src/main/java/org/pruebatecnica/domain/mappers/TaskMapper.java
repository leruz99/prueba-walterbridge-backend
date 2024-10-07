package org.pruebatecnica.domain.mappers;

import org.pruebatecnica.domain.dto.TaskDto;
import org.pruebatecnica.domain.dto.TaskCreateRequestDto;
import org.pruebatecnica.domain.entities.Task;

public class TaskMapper {
    public static Task toTask(TaskCreateRequestDto taskCreateRequestDto) {
        Task task = new Task();
        task.setTitle(taskCreateRequestDto.title());
        task.setDescription(taskCreateRequestDto.description());
        task.setCompleted(false);
        return task;
    }
    public static TaskDto toTaskDto(Task task) {
        TaskDto taskDto = new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.isCompleted(),
                task.getQuote()
        );
        return taskDto;
    }
}
