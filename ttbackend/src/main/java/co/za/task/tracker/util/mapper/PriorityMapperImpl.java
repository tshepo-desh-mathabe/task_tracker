package co.za.task.tracker.util.mapper;

import co.za.task.tracker.entity.Priority;
import co.za.task.tracker.entity.dto.PriorityDto;
import co.za.task.tracker.util.constants.PriorityType;
import co.za.task.tracker.util.helper.mapper.AListMapperHelper;
import co.za.task.tracker.util.helper.mapper.IFieldPropertyMapper;
import org.springframework.stereotype.Component;

@Component
public class PriorityMapperImpl extends AListMapperHelper<Priority, PriorityDto> {

    @Override
    public Priority toEntity(PriorityDto dto) {
        return convertToEntity(dto);
    }

    @Override
    public PriorityDto toDto(Priority entity) {
        return convertToDto(entity);
    }

    private PriorityDto convertToDto(Priority priority) {
        if (priority != null) {
            IFieldPropertyMapper<PriorityDto> mapper = destination -> {
                destination.setId(priority.getId());
                destination.setType(String.valueOf(priority.getPriorityType()));

                return destination;
            };

            return mapper.mapTo(new PriorityDto());
        } else {
            return null;
        }
    }

    private Priority convertToEntity(PriorityDto priorityDto) {
        if (priorityDto != null) {
            IFieldPropertyMapper<Priority> mapper = destination -> {
                destination.setId(priorityDto.getId());
                destination.setPriorityType(PriorityType.valueOf(priorityDto.getType()));

                return destination;
            };

            return mapper.mapTo(new Priority());
        } else {
            return null;
        }
    }
}
