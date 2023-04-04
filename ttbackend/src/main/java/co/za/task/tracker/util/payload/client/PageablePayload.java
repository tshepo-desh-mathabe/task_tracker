package co.za.task.tracker.util.payload.client;

import lombok.Getter;
import lombok.Setter;

@Deprecated
@Getter
@Setter
public class PageablePayload {
    Integer totalPages;
    Integer totalElements;
    Integer number;
    Integer numberOfElements;
    Boolean last;
}
