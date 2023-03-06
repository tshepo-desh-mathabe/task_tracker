package co.za.task.tracker.util.service;

import co.za.task.tracker.entity.dto.UserDto;
import co.za.task.tracker.repository.IUserRepository;
import co.za.task.tracker.service.TokenService;
import co.za.task.tracker.util.constants.AppConstant;
import co.za.task.tracker.util.constants.Flag;
import co.za.task.tracker.util.payload.AuthenticationRequest;
import co.za.task.tracker.util.payload.AuthenticationResponse;
import co.za.task.tracker.util.property_fetcher.IPropertyFetcher;
import co.za.task.tracker.util.response.ResponseApiWrapper;
import co.za.task.tracker.util.security.JwtService;
import co.za.task.tracker.util.validator.IValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

/**
 * Serves for User Service
 */
@Component
public abstract class AUserService implements ICrudSaveService<UserDto, ResponseEntity<?>> {
    @Autowired
    private IValidator<Boolean, String> validator;
    @Autowired
    private IPropertyFetcher<AppConstant> propertyFetcher;
    @Autowired
    private ITokenService tokenService;
    @Autowired
    private IUserRepository repository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private TokenService tokenProvider;
    @Autowired
    private AuthenticationManager authenticationManager;

    public ResponseEntity<?> signIn(AuthenticationRequest payload) {
        String email = payload.getEmail();

        if (email != null && !validator.checkData(email, Flag.CORRECT_EMAIL_FORMAT)) {
            return ResponseApiWrapper.badRequest(AppConstant.BAD_EMAIL_FORMAT);
        }

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            email, payload.getPassword()
                    )
            );
        } catch (Exception ex) {
            return ResponseApiWrapper.badRequest(propertyFetcher.getProperty(AppConstant.BAD_LOGIN_CREDENTIALS));
        }


        var user = repository.findByEmailAddressAddress(payload.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        tokenProvider.revokeAllUserTokens(user);
        tokenProvider.saveUserToken(user, jwtToken);

        return ResponseApiWrapper.okRequest(
                AuthenticationResponse.builder()
                        .token(jwtToken)
                        .build());
    }
}
