package co.za.task.tracker.util.constants;

public interface ResourcePath {
    String USER_ENTRY_POINT = "/auth";
    String PRIORITY_ENTRY_POINT = "/priority";
    String STATUS_ENTRY_POINT = "/status";

    String SAVE = "/save";
    String GET_BY_ID = "/get-one/{id}";
    String GET_ALL = "/get-all";
    String DELETE_BY_ID = "/delete/{id}";
    String DELETE_ALL = "/delete-all";
    String EDIT = "/edit";

    String GET_USER_LOGGED_IN = "/current-logged";
    String USER_LOGIN = "/sign-in";
    String USER_LOGOUT = "/log-out";

}
