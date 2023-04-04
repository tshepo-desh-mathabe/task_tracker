package co.za.task.tracker.service;

import co.za.task.tracker.entity.dto.TaskDto;
import co.za.task.tracker.util.constants.AppConstant;
import co.za.task.tracker.util.constants.Flag;
import co.za.task.tracker.util.helper.service.util.IService;
import co.za.task.tracker.util.helper.service.util.IServiceHelper;
import co.za.task.tracker.util.payload.PagedGetDataPayload;
import co.za.task.tracker.util.property_fetcher.IPropertyFetcher;
import co.za.task.tracker.util.response.ResponseApiWrapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TaskService implements IService<TaskDto> {
    private final IServiceHelper serviceHelper;
    private final IPropertyFetcher<AppConstant> propertyFetcher;

    @Override
    public ResponseEntity<?> save(TaskDto payload) {
        try {
            return serviceHelper.saveData(payload);
        } catch (Exception e) {
            return ResponseApiWrapper.badRequest(propertyFetcher.getProperty(AppConstant.WENT_WRONG_MESSAGE));
        }
    }

    @Override
    public ResponseEntity<?> findWithId(Long id) {
        return serviceHelper.findDataWithId(id);
    }

    @Override
    public ResponseEntity<?> getWithPagination(PagedGetDataPayload payload) {
        try {
            return serviceHelper.getAllByPagination(payload);
        } catch (Exception ex) {
            return ResponseApiWrapper.badRequest(propertyFetcher.getProperty(AppConstant.WENT_WRONG_MESSAGE));
        }
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return serviceHelper.deleteById(id);
    }
}
