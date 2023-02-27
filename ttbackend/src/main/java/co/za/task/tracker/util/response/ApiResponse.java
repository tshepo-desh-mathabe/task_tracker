package co.za.task.tracker.util.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Help format end point API response
 * @param <T> message type parameter
 */
@Getter
@Setter
@AllArgsConstructor
public class ApiResponse<T> {

    private boolean success;
    private T message;

    public ApiResponse(T message) {
        this.message = message;
    }
}