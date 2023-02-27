package co.za.task.tracker.util.mapper;

import co.za.task.tracker.entity.Priority;
import co.za.task.tracker.entity.Status;
import co.za.task.tracker.entity.Task;
import co.za.task.tracker.entity.User;
import co.za.task.tracker.entity.dto.PriorityDto;
import co.za.task.tracker.entity.dto.StatusDto;
import co.za.task.tracker.entity.dto.TaskDto;
import co.za.task.tracker.entity.dto.UserDto;
import co.za.task.tracker.util.helper.IFieldPropertyMapper;
import co.za.task.tracker.util.helper.IModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements IModelMapper<Task, TaskDto> {
    @Autowired
    private IModelMapper<User, UserDto> userMapper;
    @Autowired
    private IModelMapper<Status, StatusDto> statusMapper;
    @Autowired
    private IModelMapper<Priority, PriorityDto> priorityMapper;

    @Override
    public Task toEntity(TaskDto dto) {
        return convertToEntity(dto);
    }

    @Override
    public TaskDto toDto(Task entity) {
        return convertToDto(entity);
    }

    private TaskDto convertToDto(Task task) {
        if (task != null) {
            IFieldPropertyMapper<TaskDto> mapper = destination -> {
                destination.setId(task.getTaskId());
                destination.setDesc(task.getDescription());
                destination.setComments(task.getAdditionalComments());
                destination.setIsBackend(task.getIsBackend());
                destination.setIsDatabase(task.getIsDatabase());
                destination.setEta(task.getEstimatedTimeOfArrival());
                destination.setAllocatedAt(task.getAssignedAt());
                destination.setAssignedTo(userMapper.toDto(task.getAssignedTo()));
                destination.setStatus(statusMapper.toDto(task.getStatus()));
                destination.setPriority(priorityMapper.toDto(task.getPriority()));

                destination.setAuditCreatedAt(task.getAuditCreatedAt());
                destination.setAuditUpdatedAt(task.getAuditUpdatedAt());
                destination.setAuditCreatedBy(task.getAuditCreatedBy());
                destination.setAuditUpdatedBy(task.getAuditUpdatedBy());

                return destination;
            };

            return mapper.mapTo(new TaskDto());
        } else {
            return null;
        }
    }

    private Task convertToEntity(TaskDto taskDto) {
        if (taskDto != null) {
            IFieldPropertyMapper<Task> mapper = destination -> {
                destination.setTaskId(taskDto.getId());
                destination.setDescription(taskDto.getDesc());
                destination.setAdditionalComments(taskDto.getComments());
                destination.setIsBackend(taskDto.getIsBackend());
                destination.setIsDatabase(taskDto.getIsDatabase());
                destination.setEstimatedTimeOfArrival(taskDto.getEta());
                destination.setAssignedAt(taskDto.getAllocatedAt());
                destination.setAssignedTo(userMapper.toEntity(taskDto.getAssignedTo()));
                destination.setStatus(statusMapper.toEntity(taskDto.getStatus()));
                destination.setPriority(priorityMapper.toEntity(taskDto.getPriority()));

                destination.setAuditCreatedAt(taskDto.getAuditCreatedAt());
                destination.setAuditUpdatedAt(taskDto.getAuditUpdatedAt());
                destination.setAuditCreatedBy(taskDto.getAuditCreatedBy());
                destination.setAuditUpdatedBy(taskDto.getAuditUpdatedBy());

                return destination;
            };

            return mapper.mapTo(new Task());
        } else {
            return null;
        }
    }
}
