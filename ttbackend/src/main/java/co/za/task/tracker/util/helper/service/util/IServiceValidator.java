package co.za.task.tracker.util.helper.service.util;

import co.za.task.tracker.util.constants.AppConstant;
import co.za.task.tracker.util.property_fetcher.IPropertyFetcher;
import co.za.task.tracker.util.response.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

/**
 * Here we validate data that comes down to services
 */
public interface IServiceValidator {

    /**
     * Validate the id before and/or after performing actions
     */
    ResponseEntity<ApiResponse> idChecker(Long id, IPropertyFetcher<AppConstant> propertyFetcher);

    /**
     * Validate the date-time before and/or after performing actions
     */
    ResponseEntity<ApiResponse> dateTimeChecker(LocalDateTime dateTime, IPropertyFetcher<AppConstant> propertyFetcher);
}
