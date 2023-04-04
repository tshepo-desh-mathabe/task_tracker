package co.za.task.tracker.repository;

import co.za.task.tracker.entity.Task;
import co.za.task.tracker.util.constants.Flag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskRepository extends JpaRepository<Task, Long> {
    Page<Task> findByTaskFlagFlag(Flag flag, Pageable pageable);
}
