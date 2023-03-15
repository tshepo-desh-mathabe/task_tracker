package co.za.task.tracker.util.mapper;

import co.za.task.tracker.entity.Defect;
import co.za.task.tracker.entity.Task;
import co.za.task.tracker.entity.dto.DefectDto;
import co.za.task.tracker.entity.dto.TaskDto;
import co.za.task.tracker.util.helper.IFieldPropertyMapper;
import co.za.task.tracker.util.helper.IModelMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@AllArgsConstructor
@Component
public class DefectMapperImpl implements IModelMapper<Defect, DefectDto> {
    private final IModelMapper<Task, TaskDto> taskMapper;

    @Override
    public Defect toEntity(DefectDto dto) {
        return convertToEntity(dto);
    }

    @Override
    public DefectDto toDto(Defect entity) {
        return convertToDto(entity);
    }

    private DefectDto convertToDto(Defect defect) {
        if (defect != null) {
            IFieldPropertyMapper<DefectDto> mapper = destination -> {
                destination.setId(defect.getDefectId());
                destination.setTaskDto(taskMapper.toDto(defect.getTask()));

                return destination;
            };

            return mapper.mapTo(new DefectDto());
        } else {
            return null;
        }
    }

    private Defect convertToEntity(DefectDto defectDto) {
        if (defectDto != null) {
            IFieldPropertyMapper<Defect> mapper = destination -> {
                destination.setDefectId(defectDto.getId());
                destination.setTask(taskMapper.toEntity(defectDto.getTaskDto()));

                return destination;
            };

            return mapper.mapTo(new Defect());
        } else {
            return null;
        }
    }
}
