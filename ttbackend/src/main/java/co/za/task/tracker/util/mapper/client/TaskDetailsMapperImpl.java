package co.za.task.tracker.util.mapper.client;

import co.za.task.tracker.entity.*;
import co.za.task.tracker.entity.dto.PriorityDto;
import co.za.task.tracker.entity.dto.StatusDto;
import co.za.task.tracker.entity.dto.TaskFlagDto;
import co.za.task.tracker.util.helper.mapper.AListMapperHelper;
import co.za.task.tracker.util.helper.mapper.IFieldPropertyMapper;
import co.za.task.tracker.util.helper.mapper.IModelMapper;
import co.za.task.tracker.util.payload.client.TaskPayload;
import co.za.task.tracker.util.payload.client.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class TaskDetailsMapperImpl extends AListMapperHelper<Task, TaskPayload> {
    private final IModelMapper<Status, StatusDto> statusMapper;
    private final IModelMapper<Priority, PriorityDto> priorityMapper;
    private final IModelMapper<TaskFlag, TaskFlagDto> taskFlagMapper;
    private final IModelMapper<User, UserResponse> userMapper;

    @Override
    public Task toEntity(TaskPayload dto) {
        return null;
    }

    @Override
    public TaskPayload toDto(Task entity) {
        return convertToDto(entity);
    }

    private TaskPayload convertToDto(Task task) {
        if (task != null) {
            IFieldPropertyMapper<TaskPayload> mapper = destination -> {
                destination.setId(task.getId());
                destination.setDesc(task.getDescription());
                destination.setComments(task.getAdditionalComments());
                destination.setIsBackend(task.getIsBackend());
                destination.setIsDatabase(task.getIsFrontend());
                destination.setEta(task.getEstimatedTimeOfArrival());
                destination.setAllocatedAt(task.getAssignedAt());
                destination.setAssignedTo(userMapper.toDto(task.getAssignedTo()));
                destination.setTaskType(taskFlagMapper.toDto(task.getTaskFlag()));
                destination.setStatusDetails(statusMapper.toDto(task.getStatus()));
                destination.setPriorityDetails(priorityMapper.toDto(task.getPriority()));

                destination.setAuditCreatedAt(task.getAuditCreatedAt());
                destination.setAuditUpdatedAt(task.getAuditUpdatedAt());
                destination.setAuditCreatedBy(task.getAuditCreatedBy());
                destination.setAuditUpdatedBy(task.getAuditUpdatedBy());

                return destination;
            };

            return mapper.mapTo(new TaskPayload());
        } else {
            return null;
        }
    }
}
