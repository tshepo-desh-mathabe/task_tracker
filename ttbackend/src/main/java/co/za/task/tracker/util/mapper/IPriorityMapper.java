package co.za.task.tracker.util.mapper;

import co.za.task.tracker.entity.Priority;
import co.za.task.tracker.entity.dto.PriorityDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface IPriorityMapper {
    @Mapping(source = "priorityId", target = "id")
    @Mapping(source = "priorityType", target = "type")
    PriorityDto toDto(Priority priority);

    @Mapping(source = "id", target = "priorityId")
    @Mapping(source = "type", target = "priorityType")
    Priority toEntity(PriorityDto priorityDto);
}
