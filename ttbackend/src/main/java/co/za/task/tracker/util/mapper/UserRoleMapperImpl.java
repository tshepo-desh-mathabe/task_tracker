package co.za.task.tracker.util.mapper;

import co.za.task.tracker.entity.UserRole;
import co.za.task.tracker.entity.dto.UserRoleDto;
import co.za.task.tracker.util.constants.RoleType;
import co.za.task.tracker.util.helper.mapper.AListMapperHelper;
import co.za.task.tracker.util.helper.mapper.IFieldPropertyMapper;
import org.springframework.stereotype.Component;

@Component
public class UserRoleMapperImpl extends AListMapperHelper<UserRole, UserRoleDto> {

    @Override
    public UserRole toEntity(UserRoleDto dto) {
        return convertToEntity(dto);
    }

    @Override
    public UserRoleDto toDto(UserRole entity) {
        return convertToDto(entity);
    }

    private UserRoleDto convertToDto(UserRole userRole) {
        if (userRole != null) {
            IFieldPropertyMapper<UserRoleDto> mapper = destination -> {
                destination.setUserRoleId(userRole.getUserRoleId());
                destination.setType(String.valueOf(userRole.getRoleType()));

                return destination;
            };

            return mapper.mapTo(new UserRoleDto());
        } else {
            return null;
        }
    }

    private UserRole convertToEntity(UserRoleDto userRoleDto) {
        if (userRoleDto != null) {
            IFieldPropertyMapper<UserRole> mapper = destination -> {
                destination.setUserRoleId(userRoleDto.getUserRoleId());
                destination.setRoleType(RoleType.valueOf(userRoleDto.getType()));

                return destination;
            };

            return mapper.mapTo(new UserRole());
        } else {
            return null;
        }
    }
}
