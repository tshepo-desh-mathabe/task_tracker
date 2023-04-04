package co.za.task.tracker.util.mapper.client;

import co.za.task.tracker.entity.User;
import co.za.task.tracker.util.helper.mapper.IFieldPropertyMapper;
import co.za.task.tracker.util.helper.mapper.IModelMapper;
import co.za.task.tracker.util.payload.client.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@AllArgsConstructor
@Component
public class UserClientTaskMapperImpl implements IModelMapper<User, UserResponse> {

    @Override
    public User toEntity(UserResponse dto) {
        return null;
    }

    @Override
    public UserResponse toDto(User entity) {
        return convertToDto(entity);
    }

    private UserResponse convertToDto(User user) {
        if (user != null) {
            IFieldPropertyMapper<UserResponse> mapper = destination -> {
                destination.setId(user.getId());
                destination.setFirstName(user.getFirstName());
                destination.setLastName(user.getLastName());
                destination.setEmail(user.getEmailAddress().getAddress());

                return destination;
            };

            return mapper.mapTo(new UserResponse());
        } else {
            return null;
        }
    }
}
