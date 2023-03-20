package co.za.task.tracker.util.service;

/**
 * For DB read, of CRUD "R"
 * @param <R> the return type
 * @param <P> the payload
 */
public interface ICrudFindService<R, P> {

    /**
     * Read DB data
     * @param data request attribute
     * @return returns data based on attribute passed
     */
    R readData(P data);

}
