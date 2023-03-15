package co.za.task.tracker.util.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Help format end point API response
 * @param <T> message type parameter
 */
@Getter
@AllArgsConstructor
public class ApiResponse<T> {

    private boolean success;
    private T message;

}