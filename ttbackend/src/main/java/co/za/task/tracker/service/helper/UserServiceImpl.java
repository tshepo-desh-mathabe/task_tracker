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
import co.za.task.tracker.util.service.AUserService;
import co.za.task.tracker.util.service.ICrudFindService;
import co.za.task.tracker.util.validator.IValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UserServiceImpl extends AUserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IValidator<Boolean, String> validator;
    @Autowired
    private IPropertyFetcher<AppConstant> propertyFetcher;
    @Autowired
    private IModelMapper<User, UserDto> mapper;
    @Autowired
    private ICrudFindService<Set<UserRoleDto>, Set<UserRoleDto>> userRoleFindService;

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

