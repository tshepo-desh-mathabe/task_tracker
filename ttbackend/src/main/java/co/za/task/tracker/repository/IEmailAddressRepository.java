package co.za.task.tracker.repository;

import co.za.task.tracker.entity.EmailAddress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmailAddressRepository extends CrudRepository<EmailAddress, Long> {
  boolean existsByAddress(String address);
}