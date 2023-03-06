package co.za.task.tracker.service.helper;

import co.za.task.tracker.entity.UserRole;
import co.za.task.tracker.entity.dto.UserRoleDto;
import co.za.task.tracker.repository.IUserRoleRepository;
import co.za.task.tracker.util.helper.IModelMapper;
import co.za.task.tracker.util.service.ICrudFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserRoleImpl implements ICrudFindService<Set<UserRoleDto>, Set<UserRoleDto>> {
    @Autowired
    private IUserRoleRepository repository;
    @Autowired
    private IModelMapper<UserRole, UserRoleDto> mapper;

    @Override
    public Set<UserRoleDto> readData(Set<UserRoleDto> type) {
        Set<UserRole> roles = new HashSet<>();
        var userRoles = repository.findAll().iterator();

        // todo - roles not adding, java seems to beak it some how!
            type.forEach(e -> {
                while (userRoles.hasNext()) {
                    var role = userRoles.next();
                    if (e.getType().equals(role.getRoleType().name())) { // when it gets here, this does not
                        roles.add(role);
                        break;
                    }
                }
            });

        return mapper.toDto(roles);
    }
}
