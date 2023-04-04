package co.za.task.tracker.util.mapper.client;

import co.za.task.tracker.util.helper.mapper.IFieldPropertyMapper;
import co.za.task.tracker.util.helper.mapper.IModelMapper;
import co.za.task.tracker.util.payload.client.UserResponse;
import co.za.task.tracker.util.security.UserPrincipal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@AllArgsConstructor
@Component
public class SignInDataMapperImpl implements IModelMapper<UserPrincipal, UserResponse> {

    @Override
    public UserPrincipal toEntity(UserResponse dto) {
        return null;
    }

    @Override
    public UserResponse toDto(UserPrincipal entity) {
        return convertToDto(entity);
    }

    private UserResponse convertToDto(UserPrincipal userPrincipal) {
        if (userPrincipal != null) {
            IFieldPropertyMapper<UserResponse> mapper = destination -> {
                destination.setId(0l);
                destination.setFirstName(userPrincipal.getFirstName());
                destination.setLastName(userPrincipal.getLastName());
                destination.setEmail(userPrincipal.getUsername());

                return destination;
            };

            return mapper.mapTo(new UserResponse());
        } else {
            return null;
        }
    }
}
