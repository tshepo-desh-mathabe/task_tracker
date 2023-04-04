package co.za.task.tracker.util.mapper;

import co.za.task.tracker.entity.EmailAddress;
import co.za.task.tracker.entity.SecureAccount;
import co.za.task.tracker.entity.User;
import co.za.task.tracker.entity.UserRole;
import co.za.task.tracker.entity.dto.EmailAddressDto;
import co.za.task.tracker.entity.dto.SecureAccountDto;
import co.za.task.tracker.entity.dto.UserDto;
import co.za.task.tracker.entity.dto.UserRoleDto;
import co.za.task.tracker.util.helper.mapper.AListMapperHelper;
import co.za.task.tracker.util.helper.mapper.IFieldPropertyMapper;
import co.za.task.tracker.util.helper.mapper.IModelMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@AllArgsConstructor
@Component
public class UserMapperImpl extends AListMapperHelper<User, UserDto> {
    private final IModelMapper<EmailAddress, EmailAddressDto> emailMapper;
    private final IModelMapper<UserRole, UserRoleDto> userRoleMapper;
    private final IModelMapper<SecureAccount, SecureAccountDto> secureAccountMapper;

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
                destination.setId(user.getId());
                destination.setName(user.getFirstName());
                destination.setSurname(user.getLastName());
                destination.setPwd(user.getPassword());
                destination.setEmailAddress(emailMapper.toDto(user.getEmailAddress()));
                destination.setRoles(userRoleMapper.toDto(user.getRoles()));
                destination.setSecureAccountDetails(secureAccountMapper.toDto(user.getSecureAccount()));

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
                destination.setId(userDto.getId());
                destination.setFirstName(userDto.getName());
                destination.setLastName(userDto.getSurname());
                destination.setPassword(userDto.getPwd());
                destination.setEmailAddress(emailMapper.toEntity(userDto.getEmailAddress()));
                destination.setRoles(userRoleMapper.toEntity(userDto.getRoles()));
                destination.setSecureAccount(secureAccountMapper.toEntity(userDto.getSecureAccountDetails()));

                return destination;
            };

            return mapper.mapTo(new User());
        } else {
            return null;
        }
    }
}
