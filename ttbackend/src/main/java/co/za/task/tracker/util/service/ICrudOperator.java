package co.za.task.tracker.util.service;

/**
 * Performs CRUD operations
 * @param <P> the payload
 * @param <R> the return type
 */
@Deprecated
public interface ICrudOperator<P, R> {

    /**
     * Data will be persisted into the DB here
     */
    default R saveData(P data) {
        return null;
    }

}
