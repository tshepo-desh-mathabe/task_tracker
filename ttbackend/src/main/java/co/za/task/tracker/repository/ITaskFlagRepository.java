package co.za.task.tracker.repository;

import co.za.task.tracker.entity.TaskFlag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskFlagRepository extends CrudRepository<TaskFlag, Long> {
}
