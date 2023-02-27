package co.za.task.tracker.util.validator;

import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import org.springframework.stereotype.Component;

@Component
public class ValidatorImpl implements IValidator {

    public boolean isValidEmailAddress(String email) {
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