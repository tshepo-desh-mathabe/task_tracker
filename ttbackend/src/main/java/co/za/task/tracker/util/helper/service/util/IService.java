package co.za.task.tracker.util.helper.service.util;

import co.za.task.tracker.util.payload.PagedGetDataPayload;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service are to implement functionality found here
 *
 * @param <D> data transfer object
 */
public interface IService<D> {

    /**
     * Save data service
     *
     * @param payload data to be saved
     */
    @Transactional
    ResponseEntity<?> save(D payload);

    /**
     * Find data with ID service
     *
     * @param id data to find the required with ID
     */
    @Transactional(readOnly = true)
    ResponseEntity<?> findWithId(Long id);

    /**
     * Gets data with pagination
     *
     * @param payload to control pagination of data
     */
    @Transactional(readOnly = true)
    ResponseEntity<?> getWithPagination(PagedGetDataPayload payload);


    /**
     * Deletes data with ID service
     *
     * @param id data to delete the required with ID
     */
    @Transactional
    ResponseEntity<?> delete(Long id);

}
