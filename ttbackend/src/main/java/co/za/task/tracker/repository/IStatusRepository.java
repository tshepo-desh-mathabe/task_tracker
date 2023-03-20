package co.za.task.tracker.repository;

import co.za.task.tracker.entity.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStatusRepository extends CrudRepository<Status, Long> {
}
