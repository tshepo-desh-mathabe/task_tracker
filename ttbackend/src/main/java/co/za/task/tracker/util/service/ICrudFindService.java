package co.za.task.tracker.util.service;

/**
 * For DB read, of CRUD "R"
 * @param <P> the payload
 * @param <R> the return type
 */
@FunctionalInterface
public interface ICrudFindService<P, R> {

    /**
     * Data will be persisted into the DB here
     */
    R readData(P data);
}
