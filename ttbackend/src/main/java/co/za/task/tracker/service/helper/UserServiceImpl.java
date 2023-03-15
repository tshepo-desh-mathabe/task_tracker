package co.za.task.tracker.service.helper;

import co.za.task.tracker.entity.User;
import co.za.task.tracker.entity.dto.UserDto;
import co.za.task.tracker.entity.dto.UserRoleDto;
import co.za.task.tracker.repository.IUserRepository;
import co.za.task.tracker.util.constants.AppConstant;
import co.za.task.tracker.util.constants.Flag;
import co.za.task.tracker.util.helper.IModelMapper;
import co.za.task.tracker.util.property_fetcher.IPropertyFetcher;
import co.za.task.tracker.util.response.ResponseApiWrapper;
import co.za.task.tracker.util.security.JwtService;
import co.za.task.tracker.util.service.AUserService;
import co.za.task.tracker.util.service.ICrudFindService;
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
    private final IUserRepository userRepository;
    private final IValidator<Boolean, String> validator;
    private final IPropertyFetcher<AppConstant> propertyFetcher;
    private final IModelMapper<User, UserDto> mapper;
    private final ICrudFindService<Set<UserRoleDto>, Set<UserRoleDto>> userRoleFindService;

    public UserServiceImpl(IValidator<Boolean, String> validator, IPropertyFetcher<AppConstant> propertyFetcher,
                           IUserRepository repository, JwtService jwtService,
                           AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder,
                           IUserRepository userRepository, IValidator<Boolean, String> validator1,
                           IPropertyFetcher<AppConstant> propertyFetcher1, IModelMapper<User, UserDto> mapper,
                           ICrudFindService<Set<UserRoleDto>, Set<UserRoleDto>> userRoleFindService) {
        super(validator, propertyFetcher, repository, jwtService, authenticationManager);
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.validator = validator1;
        this.propertyFetcher = propertyFetcher1;
        this.mapper = mapper;
        this.userRoleFindService = userRoleFindService;
    }

    @Override
    public ResponseEntity<?> saveData(UserDto userRequest) {

        var roles = userRoleFindService.readData(userRequest.getRoles());
        if (roles.isEmpty()) return ResponseApiWrapper.badRequest("Role is required"); // todo - stop hardcoding
        else userRequest.setRoles(roles);
        if (validator.checkData(userRequest.getEmailAddress().getEmail(), Flag.IS_EXISTING_EMAIL)) {
            return ResponseApiWrapper.badRequest(propertyFetcher.getProperty(AppConstant.EMAIL_EXISTS));
        }

        userRequest.setPwd(passwordEncoder.encode(userRequest.getPwd()));
        var user = mapper.toEntity(userRequest);
        userRepository.save(user);

        return ResponseApiWrapper.okRequest(propertyFetcher.getProperty(AppConstant.SAVE_SUCCESS_MESSAGE));
    }
}

