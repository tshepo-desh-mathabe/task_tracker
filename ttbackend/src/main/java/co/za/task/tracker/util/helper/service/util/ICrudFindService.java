package co.za.task.tracker.util.helper.service.util;

import org.springframework.transaction.annotation.Transactional;

/**
 * For DB read, of CRUD "R"
 * @param <P> the payload
 * @param <R> the return type
 */
@FunctionalInterface
public interface  ICrudFindService<P, R> {

    /**
     * Read DB data
     * @param data request attribute
     */
    @Transactional(readOnly = true)
    R readData(P data);

}
