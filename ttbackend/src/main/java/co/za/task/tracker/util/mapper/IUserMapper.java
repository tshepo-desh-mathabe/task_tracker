package co.za.task.tracker.util.mapper;

import co.za.task.tracker.entity.User;
import co.za.task.tracker.entity.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface IUserMapper {
    @Mapping(source = "userId", target = "id")
    @Mapping(source = "firstName", target = "name")
    @Mapping(source = "lastName", target = "surname")
    @Mapping(source = "emailAddress", target = "email")
    UserDto toDto(User user);

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "name", target = "firstName")
    @Mapping(source = "surname", target = "lastName")
    @Mapping(source = "email", target = "emailAddress")
    User toEntity(UserDto userDto);
}
