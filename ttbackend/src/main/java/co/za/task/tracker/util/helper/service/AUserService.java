package co.za.task.tracker.util.helper.service;

import co.za.task.tracker.entity.dto.UserDto;
import co.za.task.tracker.util.constants.AppConstant;
import co.za.task.tracker.util.constants.Flag;
import co.za.task.tracker.util.constants.PayloadDetails;
import co.za.task.tracker.util.helper.mapper.IModelMapper;
import co.za.task.tracker.util.helper.service.util.ICrudFindService;
import co.za.task.tracker.util.payload.AuthenticationRequest;
import co.za.task.tracker.util.payload.client.UserResponse;
import co.za.task.tracker.util.property_fetcher.IPropertyFetcher;
import co.za.task.tracker.util.response.ApiResponse;
import co.za.task.tracker.util.response.ResponseApiWrapper;
import co.za.task.tracker.util.security.JwtService;
import co.za.task.tracker.util.security.UserPrincipal;
import co.za.task.tracker.util.validator.IValidator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Serves for User Service
 */
@AllArgsConstructor
@Component
public abstract class AUserService implements ICrudFindService<String, ResponseEntity<ApiResponse>> {
    private final IValidator<Boolean, String> validator;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final IModelMapper<UserPrincipal, UserResponse> mapper;
    private final IPropertyFetcher<AppConstant> propertyFetcher;


    public ResponseEntity<?> signIn(AuthenticationRequest payload) throws BadCredentialsException {
        String email = payload.email();

        if (email != null && !validator.checker(email, Flag.CORRECT_EMAIL_FORMAT)) {
            return ResponseApiWrapper.badRequest(AppConstant.BAD_EMAIL_FORMAT);
        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, payload.password())
        );

        return generateResponse(authentication);
    }

    private ResponseEntity<ApiResponse> generateResponse(Authentication authentication) {
        SecurityContextHolder.getContext().setAuthentication(authentication);
        var userDetails = getClientUserDetails();
        if (userDetails == null)
            return ResponseApiWrapper.badRequest(propertyFetcher.getProperty(AppConstant.WENT_WRONG_MESSAGE));
        var jwt = jwtService.generateToken(authentication);
        userDetails.put(PayloadDetails.TOKEN, jwt);
        return ResponseApiWrapper.okRequest(userDetails);
    }

    private Map<String, Object> getClientUserDetails() {
        Map<String, Object> response = new HashMap<>();
        UserPrincipal loggedInUser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        response.put(PayloadDetails.USER_DETAILS, mapper.toDto(loggedInUser));
        response.put(PayloadDetails.ROLES, loggedInUser.getAuthorities());

        return response;
    }

    public abstract UserDto readData(Long id);
}
