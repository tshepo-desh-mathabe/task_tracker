package co.za.task.tracker.util.helper.service.util;

import co.za.task.tracker.entity.dto.TaskDto;
import co.za.task.tracker.util.payload.PagedGetDataPayload;
import co.za.task.tracker.util.response.ApiResponse;
import org.springframework.http.ResponseEntity;

/**
 * Here is lies the backbone of the command pattern
 */
public interface IServiceHelper {

    ResponseEntity<ApiResponse> findDataWithId(Long id);
    ResponseEntity<ApiResponse> getAllByPagination(PagedGetDataPayload pageData);
    ResponseEntity<ApiResponse> deleteById(Long id);
    ResponseEntity<ApiResponse> saveData(TaskDto taskDto) throws Exception;

}
