package co.za.task.tracker.util.validator;

import co.za.task.tracker.repository.IEmailAddressRepository;
import co.za.task.tracker.util.constants.Flag;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidatorImpl implements IValidator<Boolean, String> {
    @Autowired
    private IEmailAddressRepository emailAddressRepository;

    @Override
    public Boolean checkData(String email, Flag flag) {
        return switch (flag) {
            case CORRECT_EMAIL_FORMAT -> validateEmailAddress(email);
            case IS_EXISTING_EMAIL -> emailAddressRepository.existsByAddress(email);
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