package co.za.task.tracker.service.helper;

import co.za.task.tracker.repository.ITaskRepository;
import co.za.task.tracker.util.constants.AppConstant;
import co.za.task.tracker.util.constants.Flag;
import co.za.task.tracker.util.helper.service.util.IServiceValidator;
import co.za.task.tracker.util.property_fetcher.IPropertyFetcher;
import co.za.task.tracker.util.response.ApiResponse;
import co.za.task.tracker.util.response.ResponseApiWrapper;
import co.za.task.tracker.util.validator.IValidator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@AllArgsConstructor
@Component
public class ServiceHelper implements IServiceValidator {
    private final IValidator<Boolean, LocalDateTime> dateTimeIValidator;
    private final IValidator<Boolean, Long> idValidator;

    @Override
    public ResponseEntity<ApiResponse> idChecker(Long id, IPropertyFetcher<AppConstant> propertyFetcher) {
        if (!idValidator.checker(id, Flag.TASK_ID_LENGTH)) {
            return ResponseApiWrapper.badRequest(propertyFetcher.getProperty(AppConstant.ID_LENGTH));
        }
        if (idValidator.checker(id, Flag.TASK_ID_TAKEN)) {
            return ResponseApiWrapper.badRequest(propertyFetcher.getProperty(AppConstant.TASK_ID_TAKEN));
        }
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse> dateTimeChecker(LocalDateTime dateTime, IPropertyFetcher<AppConstant> propertyFetcher) {
        if (!dateTimeIValidator.checker(dateTime, Flag.CORRECT_DATE_TIME_FORMAT)) {
            return ResponseApiWrapper.badRequest(propertyFetcher.getProperty(AppConstant.DATE_TIME_FORMAT));
        }
        if (!dateTimeIValidator.checker(dateTime, Flag.IS_DATE_GREATER)) {
            return ResponseApiWrapper.badRequest(propertyFetcher.getProperty(AppConstant.DATE_TIME_GREAT_NOW));
        }
        return null;
    }
}
