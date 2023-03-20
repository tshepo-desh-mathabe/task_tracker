package co.za.task.tracker.repository;

import co.za.task.tracker.entity.Priority;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPriorityRepository extends CrudRepository<Priority, Long> {
}
