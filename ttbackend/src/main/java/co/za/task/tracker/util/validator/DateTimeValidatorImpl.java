package co.za.task.tracker.util.validator;

import co.za.task.tracker.util.constants.Flag;
import co.za.task.tracker.util.constants.Formats;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@AllArgsConstructor
@Component
public class DateTimeValidatorImpl implements IValidator<Boolean, LocalDateTime> {

    @Override
    public Boolean checker(LocalDateTime data, Flag flag) {
        return switch (flag) {
            case CORRECT_DATE_TIME_FORMAT -> isValidDateTimeFormat(data);
            case IS_DATE_GREATER -> data.isAfter(LocalDateTime.now());
            default -> throw new IllegalStateException("Unexpected value: " + flag);
        };
    }

    private boolean isValidDateTimeFormat(LocalDateTime dateTime) {
        boolean result = true;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(Formats.dateTimeFormat);

        try {
            LocalDate.parse(dateTime.toString(), dateFormatter);
        } catch (DateTimeParseException e) {
            result = false;
        }
        return result;
    }
}