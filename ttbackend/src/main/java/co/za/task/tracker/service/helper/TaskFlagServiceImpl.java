package co.za.task.tracker.service.helper;

import co.za.task.tracker.entity.TaskFlag;
import co.za.task.tracker.entity.dto.PriorityDto;
import co.za.task.tracker.entity.dto.TaskFlagDto;
import co.za.task.tracker.repository.ITaskFlagRepository;
import co.za.task.tracker.util.helper.mapper.IModelMapper;
import co.za.task.tracker.util.helper.service.util.IFindAll;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Component
public class TaskFlagServiceImpl implements IFindAll<Set<TaskFlagDto>> {
    private final ITaskFlagRepository repository;
    private final IModelMapper<TaskFlag, TaskFlagDto> mapper;

    @Override
    public Set<TaskFlagDto> readAll() {
        var priorities = repository.findAll();
        var data = StreamSupport.stream(priorities.spliterator(), false)
                .collect(Collectors.toSet());
        return mapper.toDto(data);
    }
}
