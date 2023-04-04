package co.za.task.tracker.util.mapper;

import co.za.task.tracker.entity.TaskFlag;
import co.za.task.tracker.entity.dto.TaskFlagDto;
import co.za.task.tracker.util.constants.Flag;
import co.za.task.tracker.util.helper.mapper.AListMapperHelper;
import co.za.task.tracker.util.helper.mapper.IFieldPropertyMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskFlagMapperImpl extends AListMapperHelper<TaskFlag, TaskFlagDto> {

    @Override
    public TaskFlag toEntity(TaskFlagDto dto) {
        return convertToEntity(dto);
    }

    @Override
    public TaskFlagDto toDto(TaskFlag entity) {
        return convertToDto(entity);
    }

    private TaskFlagDto convertToDto(TaskFlag taskFlag) {
        if (taskFlag != null) {
            IFieldPropertyMapper<TaskFlagDto> mapper = destination -> {
                destination.setId(taskFlag.getId());
                destination.setType(String.valueOf(taskFlag.getFlag()));

                return destination;
            };

            return mapper.mapTo(new TaskFlagDto());
        } else {
            return null;
        }
    }

    private TaskFlag convertToEntity(TaskFlagDto taskFlagDto) {
        if (taskFlagDto != null) {
            IFieldPropertyMapper<TaskFlag> mapper = destination -> {
                destination.setId(taskFlagDto.getId());
                destination.setFlag(Flag.valueOf(taskFlagDto.getType()));

                return destination;
            };

            return mapper.mapTo(new TaskFlag());
        } else {
            return null;
        }
    }
}
