package co.za.task.tracker.service.helper;

import co.za.task.tracker.entity.UserRole;
import co.za.task.tracker.entity.dto.UserRoleDto;
import co.za.task.tracker.repository.IUserRoleRepository;
import co.za.task.tracker.util.helper.mapper.IModelMapper;
import co.za.task.tracker.util.helper.service.util.ICrudFindService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
@Component
public class UserRoleServiceImpl implements ICrudFindService<Set<UserRoleDto>, Set<UserRoleDto>> {
    private final IUserRoleRepository repository;
    private final IModelMapper<UserRole, UserRoleDto> mapper;

    @Override
    public Set<UserRoleDto> readData(Set<UserRoleDto> type) {
        Set<UserRole> roles = new HashSet<>();
        var userRoles = repository.findAll().iterator();

        // todo - roles not adding, java seems to beak it some how!
        type.forEach(e -> {
            while (userRoles.hasNext()) {
                var role = userRoles.next();
                if (e.getType().equals(role.getRoleType().name())) { // when it gets here, this does not check (break is here)
                    roles.add(role);
                    break;
                }
            }
        });

        return mapper.toDto(roles);
    }
}
