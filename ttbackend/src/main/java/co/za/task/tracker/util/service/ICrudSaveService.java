package co.za.task.tracker.util.service;

/**
 * For DB save, of CRUD "C"
 * @param <P> the payload
 * @param <R> the return type
 */
@FunctionalInterface
public interface ICrudSaveService<P, R> {

    /**
     * Data will be persisted into the DB here
     */
    R saveData(P data);
}
