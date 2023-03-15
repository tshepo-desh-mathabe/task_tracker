package co.za.task.tracker.util.mapper;

import co.za.task.tracker.entity.ChangeRequest;
import co.za.task.tracker.entity.Task;
import co.za.task.tracker.entity.dto.ChangeRequestDto;
import co.za.task.tracker.entity.dto.TaskDto;
import co.za.task.tracker.util.helper.IFieldPropertyMapper;
import co.za.task.tracker.util.helper.IModelMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@AllArgsConstructor
@Component
public class ChangeRequestMapperImpl implements IModelMapper<ChangeRequest, ChangeRequestDto> {
    private IModelMapper<Task, TaskDto> taskMapper;

    @Override
    public ChangeRequest toEntity(ChangeRequestDto dto) {
        return convertToEntity(dto);
    }

    @Override
    public ChangeRequestDto toDto(ChangeRequest entity) {
        return convertToDto(entity);
    }

    private ChangeRequestDto convertToDto(ChangeRequest changeRequest) {
        if (changeRequest != null) {
            IFieldPropertyMapper<ChangeRequestDto> mapper = destination -> {
                destination.setId(changeRequest.getChangeRequestId());
                destination.setTaskDto(taskMapper.toDto(changeRequest.getTask()));

                return destination;
            };

            return mapper.mapTo(new ChangeRequestDto());
        } else {
            return null;
        }
    }

    private ChangeRequest convertToEntity(ChangeRequestDto changeRequestDto) {
        if (changeRequestDto != null) {
            IFieldPropertyMapper<ChangeRequest> mapper = destination -> {
                destination.setChangeRequestId(changeRequestDto.getId());
                destination.setTask(taskMapper.toEntity(changeRequestDto.getTaskDto()));

                return destination;
            };

            return mapper.mapTo(new ChangeRequest());
        } else {
            return null;
        }
    }
}
