package co.za.task.tracker.util.response;

import org.springframework.http.ResponseEntity;

/**
 * Wrapper object for HTTP responses
 */
public class ResponseApiWrapper {

    /**
     * HTTP.OK_REQUEST (non-bad) response wrapper
     * @param message message to be returned
     * @return returns API response wrapped
     */
    public static ResponseEntity<ApiResponse> okRequest(Object message) {
        return ResponseEntity.ok(new ApiResponse(true, message));
    }

    /**
     * HTTP.BAD_REQUEST response wrapper
     * @param message message to be returned
     * @return returns API response wrapped
     */
    public static ResponseEntity<ApiResponse> badRequest(Object message) {
        return ResponseEntity.badRequest().body(new ApiResponse(false, message));
    }

}