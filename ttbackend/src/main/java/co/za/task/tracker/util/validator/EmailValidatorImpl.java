package co.za.task.tracker.util.validator;

import co.za.task.tracker.repository.IEmailAddressRepository;
import co.za.task.tracker.util.constants.Flag;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class EmailValidatorImpl implements IValidator<Boolean, String> {
    private final IEmailAddressRepository emailAddressRepository;

    @Override
    public Boolean checker(String email, Flag flag) {
        return switch (flag) {
            case CORRECT_EMAIL_FORMAT -> validateEmailAddress(email);
            case IS_EXISTING_EMAIL -> emailAddressRepository.existsByAddress(email);
            default -> throw new IllegalStateException("Unexpected value: " + flag);
        };
    }

    private boolean validateEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress address = new InternetAddress(email);
            address.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }


}