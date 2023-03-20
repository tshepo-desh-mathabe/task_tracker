package co.za.task.tracker.service.helper;

import co.za.task.tracker.entity.Priority;
import co.za.task.tracker.entity.dto.PriorityDto;
import co.za.task.tracker.repository.IPriorityRepository;
import co.za.task.tracker.util.helper.IModelMapper;
import co.za.task.tracker.util.service.APriorityService;
import org.springframework.stereotype.Component;

@Component
public class PriorityServiceImpl extends APriorityService {

    public PriorityServiceImpl(IPriorityRepository repository, IModelMapper<Priority, PriorityDto> mapper) {
        super(repository, mapper);
    }

}
