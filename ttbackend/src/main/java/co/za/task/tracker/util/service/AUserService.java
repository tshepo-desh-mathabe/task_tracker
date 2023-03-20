package co.za.task.tracker.util.service;

import co.za.task.tracker.entity.dto.UserDto;
import co.za.task.tracker.repository.IUserRepository;
import co.za.task.tracker.util.constants.AppConstant;
import co.za.task.tracker.util.constants.Flag;
import co.za.task.tracker.util.payload.AuthenticationRequest;
import co.za.task.tracker.util.property_fetcher.IPropertyFetcher;
import co.za.task.tracker.util.response.ResponseApiWrapper;
import co.za.task.tracker.util.security.JwtService;
import co.za.task.tracker.util.validator.IValidator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Serves for User Service
 */
@Getter
@AllArgsConstructor
@Component
public abstract class AUserService implements ICrudSaveService<UserDto, ResponseEntity<?>> {
    private final IValidator<Boolean, String> validator;
    private final IPropertyFetcher<AppConstant> propertyFetcher;
    private final IUserRepository repository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public ResponseEntity<?> signIn(AuthenticationRequest payload) throws BadCredentialsException {
        String email = payload.getEmail();

        if (email != null && !validator.checkData(email, Flag.CORRECT_EMAIL_FORMAT)) {
            return ResponseApiWrapper.badRequest(AppConstant.BAD_EMAIL_FORMAT);
        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, payload.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        var jwtToken = jwtService.generateToken(authentication);
        return ResponseApiWrapper.okRequest(jwtToken);
    }
}
