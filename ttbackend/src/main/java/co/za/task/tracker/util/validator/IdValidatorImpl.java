package co.za.task.tracker.util.validator;

import co.za.task.tracker.repository.ITaskRepository;
import co.za.task.tracker.util.constants.Flag;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class IdValidatorImpl implements IValidator<Boolean, Long> {
    private final ITaskRepository repository;

    @Override
    public Boolean checker(Long data, Flag flag) {
        return switch (flag) {
            case TASK_ID_TAKEN -> repository.existsById(data);
            case TASK_ID_LENGTH -> String.valueOf(data).length() > 1;
            default -> throw new IllegalStateException("Unexpected value: " + flag);
        };
    }
}