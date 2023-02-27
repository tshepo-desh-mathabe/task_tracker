package co.za.task.tracker.util.validator;

@FunctionalInterface
public interface IValidator {
    boolean isValidEmailAddress(String email);
}