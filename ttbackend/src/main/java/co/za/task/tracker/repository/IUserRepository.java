package co.za.task.tracker.repository;

import co.za.task.tracker.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface IUserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmailAddressAddress(String email);
    Set<User> findAllByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailAddressAddressContainingIgnoreCase(
            String firstName, String lastName, String email
    );
}
