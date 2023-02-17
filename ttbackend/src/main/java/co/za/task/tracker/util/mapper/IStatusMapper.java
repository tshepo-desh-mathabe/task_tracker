package co.za.task.tracker.util.mapper;

import co.za.task.tracker.entity.Status;
import co.za.task.tracker.entity.dto.StatusDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface IStatusMapper {
    @Mapping(source = "statusId", target = "id")
    @Mapping(source = "statusType", target = "type")
    StatusDto toDto(Status status);

    @Mapping(source = "id", target = "statusId")
    @Mapping(source = "type", target = "statusType")
    Status toEntity(StatusDto statusDto);
}
