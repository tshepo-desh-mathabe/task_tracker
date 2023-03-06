package co.za.task.tracker.repository;

import co.za.task.tracker.entity.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRoleRepository extends CrudRepository<UserRole, Long> {
}
