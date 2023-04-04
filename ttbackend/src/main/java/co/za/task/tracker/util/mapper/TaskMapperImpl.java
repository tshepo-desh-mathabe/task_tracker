package co.za.task.tracker.util.mapper;

import co.za.task.tracker.entity.*;
import co.za.task.tracker.entity.dto.*;
import co.za.task.tracker.util.helper.mapper.AListMapperHelper;
import co.za.task.tracker.util.helper.mapper.IFieldPropertyMapper;
import co.za.task.tracker.util.helper.mapper.IModelMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class TaskMapperImpl extends AListMapperHelper<Task, TaskDto> {
    private final IModelMapper<User, UserDto> userMapper;
    private final IModelMapper<Status, StatusDto> statusMapper;
    private final IModelMapper<Priority, PriorityDto> priorityMapper;
    private final IModelMapper<TaskFlag, TaskFlagDto> taskFlagMapper;

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
                destination.setId(task.getId());
                destination.setDesc(task.getDescription());
                destination.setComments(task.getAdditionalComments());
                destination.setIsBackend(task.getIsBackend());
                destination.setIsDatabase(task.getIsFrontend());
                destination.setEta(task.getEstimatedTimeOfArrival());
                destination.setAllocatedAt(task.getAssignedAt());
                destination.setTaskType(taskFlagMapper.toDto(task.getTaskFlag()));
                destination.setAssignedTo(userMapper.toDto(task.getAssignedTo()));
                destination.setStatusDetails(statusMapper.toDto(task.getStatus()));
                destination.setPriorityDetails(priorityMapper.toDto(task.getPriority()));

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
                destination.setId(taskDto.getId());
                destination.setDescription(taskDto.getDesc());
                destination.setAdditionalComments(taskDto.getComments());
                destination.setIsBackend(taskDto.getIsBackend());
                destination.setIsFrontend(taskDto.getIsDatabase());
                destination.setEstimatedTimeOfArrival(taskDto.getEta());
                destination.setAssignedAt(taskDto.getAllocatedAt());
                destination.setTaskFlag(taskFlagMapper.toEntity(taskDto.getTaskType()));
                destination.setAssignedTo(userMapper.toEntity(taskDto.getAssignedTo()));
                destination.setStatus(statusMapper.toEntity(taskDto.getStatusDetails()));
                destination.setPriority(priorityMapper.toEntity(taskDto.getPriorityDetails()));

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
