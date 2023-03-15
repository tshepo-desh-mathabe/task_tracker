package co.za.task.tracker.util.mapper;

import co.za.task.tracker.entity.Task;
import co.za.task.tracker.entity.UserStory;
import co.za.task.tracker.entity.dto.TaskDto;
import co.za.task.tracker.entity.dto.UserStoryDto;
import co.za.task.tracker.util.helper.IFieldPropertyMapper;
import co.za.task.tracker.util.helper.IModelMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@AllArgsConstructor
@Component
public class UserStoryMapperImpl implements IModelMapper<UserStory, UserStoryDto> {
    private final IModelMapper<Task, TaskDto> taskMapper;

    @Override
    public UserStory toEntity(UserStoryDto dto) {
        return convertToEntity(dto);
    }

    @Override
    public UserStoryDto toDto(UserStory entity) {
        return convertToDto(entity);
    }

    private UserStoryDto convertToDto(UserStory userStory) {
        if (userStory != null) {
            IFieldPropertyMapper<UserStoryDto> mapper = destination -> {
                destination.setId(userStory.getUserStoryId());
                destination.setTaskDto(taskMapper.toDto(userStory.getTask()));

                return destination;
            };

            return mapper.mapTo(new UserStoryDto());
        } else {
            return null;
        }
    }

    private UserStory convertToEntity(UserStoryDto userStoryDto) {
        if (userStoryDto != null) {
            IFieldPropertyMapper<UserStory> mapper = destination -> {
                destination.setUserStoryId(userStoryDto.getId());
                destination.setTask(taskMapper.toEntity(userStoryDto.getTaskDto()));

                return destination;
            };

            return mapper.mapTo(new UserStory());
        } else {
            return null;
        }
    }
}
