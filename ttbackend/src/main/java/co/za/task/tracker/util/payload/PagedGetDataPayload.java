package co.za.task.tracker.util.payload;

public record PagedGetDataPayload(Integer pageNumber, Integer pageSize, String flag) {
}
