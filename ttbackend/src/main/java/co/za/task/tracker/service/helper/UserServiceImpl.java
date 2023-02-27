package co.za.task.tracker.service.helper;

import co.za.task.tracker.entity.dto.UserDto;
import co.za.task.tracker.payload.LoggedInUserSummary;
import co.za.task.tracker.util.constants.AppConstant;
import co.za.task.tracker.util.property_fetcher.IPropertyFetcher;
import co.za.task.tracker.util.response.ResponseApiWrapper;
import co.za.task.tracker.util.security.JwtTokenProvider;
import co.za.task.tracker.util.security.UserPrincipal;
import co.za.task.tracker.util.service.IUserService;
import co.za.task.tracker.util.validator.IValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements IUserService {
    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    private IValidator validator;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IPropertyFetcher<AppConstant> propertyFetcher;

    public ResponseEntity<?> signIn(UserDto payload) {
        if (!validator.isValidEmailAddress(payload.getEmail().getEmail())) {
            return ResponseApiWrapper.badRequest(AppConstant.BAD_EMAIL_FORMAT);
        }

        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            payload.getEmail().getEmail(),
                            payload.getPwd()
                    )
            );
        } catch (Exception ex) {
            return ResponseApiWrapper.badRequest(propertyFetcher.getProperty(AppConstant.BAD_LOGIN_CREDENTIALS));
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken = tokenProvider.generateToken(authentication);
        return ResponseApiWrapper.okRequest(getLoggedUser(jwtToken));
    }

    private LoggedInUserSummary getLoggedUser(String token) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getPrincipal() instanceof UserPrincipal principal) {
            return new LoggedInUserSummary(principal.name(), principal.surname(), token, authentication.getAuthorities());
        }
        return null;
    }

}