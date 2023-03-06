package co.za.task.tracker.util.validator;

import co.za.task.tracker.util.constants.Flag;

/**
 * Use to check and/or validate data
 * @param <R> the return type
 * @param <D> data to be checked
 */
@FunctionalInterface
public interface IValidator<R, D> {
    R checkData(D email, Flag flag);
}