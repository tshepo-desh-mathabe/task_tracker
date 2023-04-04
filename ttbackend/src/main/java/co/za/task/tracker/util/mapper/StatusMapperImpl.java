package co.za.task.tracker.util.mapper;

import co.za.task.tracker.entity.Status;
import co.za.task.tracker.entity.dto.StatusDto;
import co.za.task.tracker.util.constants.StatusType;
import co.za.task.tracker.util.helper.mapper.AListMapperHelper;
import co.za.task.tracker.util.helper.mapper.IFieldPropertyMapper;
import org.springframework.stereotype.Component;

@Component
public class StatusMapperImpl extends AListMapperHelper<Status, StatusDto> {

    @Override
    public Status toEntity(StatusDto dto) {
        return convertToEntity(dto);
    }

    @Override
    public StatusDto toDto(Status entity) {
        return convertToDto(entity);
    }

    private StatusDto convertToDto(Status status) {
        if (status != null) {
            IFieldPropertyMapper<StatusDto> mapper = destination -> {
                destination.setId(status.getId());
                destination.setType(String.valueOf(status.getStatusType()));

                return destination;
            };

            return mapper.mapTo(new StatusDto());
        } else {
            return null;
        }
    }

    private Status convertToEntity(StatusDto statusDto) {
        if (statusDto != null) {
            IFieldPropertyMapper<Status> mapper = destination -> {
                destination.setId(statusDto.getId());
                destination.setStatusType(StatusType.valueOf(statusDto.getType()));

                return destination;
            };

            return mapper.mapTo(new Status());
        } else {
            return null;
        }
    }
}
