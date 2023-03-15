package co.za.task.tracker.util.mapper;

import co.za.task.tracker.entity.Other;
import co.za.task.tracker.entity.Task;
import co.za.task.tracker.entity.dto.OtherDto;
import co.za.task.tracker.entity.dto.TaskDto;
import co.za.task.tracker.util.helper.IFieldPropertyMapper;
import co.za.task.tracker.util.helper.IModelMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@AllArgsConstructor
@Component
public class OtherMapperImpl implements IModelMapper<Other, OtherDto> {
    private final IModelMapper<Task, TaskDto> taskMapper;

    @Override
    public Other toEntity(OtherDto dto) {
        return convertToEntity(dto);
    }

    @Override
    public OtherDto toDto(Other entity) {
        return convertToDto(entity);
    }

    private OtherDto convertToDto(Other changeRequest) {
        if (changeRequest != null) {
            IFieldPropertyMapper<OtherDto> mapper = destination -> {
                destination.setId(changeRequest.getOtherId());
                destination.setTaskDto(taskMapper.toDto(changeRequest.getTask()));

                return destination;
            };

            return mapper.mapTo(new OtherDto());
        } else {
            return null;
        }
    }

    private Other convertToEntity(OtherDto otherDto) {
        if (otherDto != null) {
            IFieldPropertyMapper<Other> mapper = destination -> {
                destination.setOtherId(otherDto.getId());
                destination.setTask(taskMapper.toEntity(otherDto.getTaskDto()));

                return destination;
            };

            return mapper.mapTo(new Other());
        } else {
            return null;
        }
    }
}
