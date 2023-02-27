package co.za.task.tracker.util.mapper;

import co.za.task.tracker.entity.EmailAddress;
import co.za.task.tracker.entity.User;
import co.za.task.tracker.entity.UserRole;
import co.za.task.tracker.entity.dto.EmailAddressDto;
import co.za.task.tracker.entity.dto.UserDto;
import co.za.task.tracker.entity.dto.UserRoleDto;
import co.za.task.tracker.util.helper.IFieldPropertyMapper;
import co.za.task.tracker.util.helper.IModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements IModelMapper<User, UserDto> {
    @Autowired
    private IModelMapper<EmailAddress, EmailAddressDto> emailMapper;
    @Autowired
    private IModelMapper<UserRole, UserRoleDto> userRoleMapper;

    @Override
    public User toEntity(UserDto dto) {
        return convertToEntity(dto);
    }

    @Override
    public UserDto toDto(User entity) {
        return convertToDto(entity);
    }

    private UserDto convertToDto(User user) {
        if (user != null) {
            IFieldPropertyMapper<UserDto> mapper = destination -> {
                destination.setId(user.getUserId());
                destination.setName(user.getFirstName());
                destination.setSurname(user.getLastName());
                destination.setPwd(user.getPassword());
                destination.setEmail(emailMapper.toDto(user.getEmailAddress()));
                destination.setRoles(userRoleMapper.toDto(user.getRoles()));

                return destination;
            };

            return mapper.mapTo(new UserDto());
        } else {
            return null;
        }
    }

    private User convertToEntity(UserDto userDto) {
        if (userDto != null) {
            IFieldPropertyMapper<User> mapper = destination -> {
                destination.setUserId(userDto.getId());
                destination.setFirstName(userDto.getName());
                destination.setLastName(userDto.getSurname());
                destination.setPassword(userDto.getPwd());
                destination.setEmailAddress(emailMapper.toEntity(userDto.getEmail()));
                destination.setRoles(userRoleMapper.toEntity(userDto.getRoles()));

                return destination;
            };

            return mapper.mapTo(new User());
        } else {
            return null;
        }
    }
}
