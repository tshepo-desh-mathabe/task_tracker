package co.za.task.tracker.service.helper;

import co.za.task.tracker.entity.User;
import co.za.task.tracker.entity.dto.UserDto;
import co.za.task.tracker.entity.dto.UserRoleDto;
import co.za.task.tracker.repository.IUserRepository;
import co.za.task.tracker.util.constants.AppConstant;
import co.za.task.tracker.util.helper.mapper.IModelMapper;
import co.za.task.tracker.util.helper.service.AUserService;
import co.za.task.tracker.util.helper.service.util.ICrudFindService;
import co.za.task.tracker.util.payload.client.UserResponse;
import co.za.task.tracker.util.property_fetcher.IPropertyFetcher;
import co.za.task.tracker.util.response.ApiResponse;
import co.za.task.tracker.util.response.ResponseApiWrapper;
import co.za.task.tracker.util.security.JwtService;
import co.za.task.tracker.util.security.UserPrincipal;
import co.za.task.tracker.util.validator.IValidator;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Getter
@Component
public class UserServiceImpl extends AUserService {
    private final PasswordEncoder passwordEncoder;
    private final IUserRepository repository;
    private final IValidator<Boolean, String> validator;
    private final IPropertyFetcher<AppConstant> propertyFetcher;
    private final IModelMapper<User, UserDto> mapper;
    private final ICrudFindService<Set<UserRoleDto>, Set<UserRoleDto>> userRoleFindService;

    public UserServiceImpl(IValidator<Boolean, String> validator, JwtService jwtService, AuthenticationManager authenticationManager,
                           IModelMapper<UserPrincipal, UserResponse> mapper, IPropertyFetcher<AppConstant> propertyFetcher, PasswordEncoder passwordEncoder, IUserRepository repository, IValidator<Boolean, String> validator1, IPropertyFetcher<AppConstant> propertyFetcher1, IModelMapper<User, UserDto> mapper1, ICrudFindService<Set<UserRoleDto>, Set<UserRoleDto>> userRoleFindService) {
        super(validator, jwtService, authenticationManager, mapper, propertyFetcher);
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
        this.validator = validator1;
        this.propertyFetcher = propertyFetcher1;
        this.mapper = mapper1;
        this.userRoleFindService = userRoleFindService;
    }

    @Override
    public ResponseEntity<ApiResponse> readData(String searchValue) {
        if (searchValue.isBlank() || searchValue.isEmpty())
            return ResponseApiWrapper.badRequest(propertyFetcher.getProperty(AppConstant.NO_DATA_MESSAGE));

        var userResponse = getUserResponse(searchValue);
        if (userResponse == null)
            return ResponseApiWrapper.badRequest(propertyFetcher.getProperty(AppConstant.NO_DATA_MESSAGE));
        return ResponseApiWrapper.okRequest(userResponse);
    }

    @Override
    public UserDto readData(Long id) {
        var data = repository.findById(id);
        return data.map(mapper::toDto).orElse(null);
    }

    private Set<UserResponse> getUserResponse(String searchValue) {
//        var users = repository.findAllByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailAddressAddressContainingIgnoreCase(
//                searchValue, searchValue, searchValue
//        );
//
//        if (users.isEmpty()) {
//            return null;
//        } else {
//            Set<UserResponse> userResponses = new HashSet<>();
//
//            users.forEach(e -> {
//                UserResponse userResponse = new UserResponse(
//                        e.getId(), e.getFirstName(), e.getLastName(),
//                        e.getEmailAddress().getAddress());
//                userResponses.add(userResponse);
//            });
//            return userResponses;
        return null;
    }

}

