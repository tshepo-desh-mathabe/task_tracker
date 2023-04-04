package co.za.task.tracker.service.helper;

import co.za.task.tracker.entity.Task;
import co.za.task.tracker.entity.dto.TaskDto;
import co.za.task.tracker.entity.dto.UserDto;
import co.za.task.tracker.repository.ITaskRepository;
import co.za.task.tracker.util.constants.AppConstant;
import co.za.task.tracker.util.constants.Flag;
import co.za.task.tracker.util.helper.mapper.AListMapperHelper;
import co.za.task.tracker.util.helper.service.AUserService;
import co.za.task.tracker.util.helper.service.util.IServiceHelper;
import co.za.task.tracker.util.helper.service.util.IServiceValidator;
import co.za.task.tracker.util.payload.PagedGetDataPayload;
import co.za.task.tracker.util.payload.client.TaskPayload;
import co.za.task.tracker.util.property_fetcher.IPropertyFetcher;
import co.za.task.tracker.util.response.ApiResponse;
import co.za.task.tracker.util.response.ResponseApiWrapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@AllArgsConstructor
@Component
public class TaskServiceImpl implements IServiceHelper {
    private final IPropertyFetcher<AppConstant> propertyFetcher;
    private final ITaskRepository repository;
    private final AListMapperHelper<Task, TaskDto> taskMapper;
    private final AListMapperHelper<Task, TaskPayload> taskPayloadMapper;
    private final IServiceValidator serviceValidator;
    private final AUserService userService;

    @Override
    public ResponseEntity<ApiResponse> findDataWithId(Long id) {
        var repo = repository.findById(id);
        if (repo.isPresent()) {
            var dto = taskPayloadMapper.toDto(repo.get());
            return ResponseApiWrapper.okRequest(dto);
        }
        return ResponseApiWrapper.badRequest(propertyFetcher.getProperty(AppConstant.NO_DATA_MESSAGE));
    }

    @Override
    public ResponseEntity<ApiResponse> getAllByPagination(PagedGetDataPayload pageData) {
        Pageable paging = PageRequest.of(pageData.pageNumber(), pageData.pageSize());
        Page<Task> pagedData = repository.findByTaskFlagFlag(Flag.valueOf(pageData.flag()), paging);

        if (pagedData.hasContent()) {
            Page<TaskPayload> dtoPagedData = pagedData.map(e -> taskPayloadMapper.toDto(e));
            return ResponseApiWrapper.okRequest(dtoPagedData);
        }
        return ResponseApiWrapper.badRequest(propertyFetcher.getProperty(AppConstant.NO_DATA_MESSAGE));
    }

    @Override
    public ResponseEntity<ApiResponse> deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseApiWrapper.okRequest(propertyFetcher.getProperty(AppConstant.SUCCESS_DELETE_MESSAGE));
        }
        return ResponseApiWrapper.badRequest(propertyFetcher.getProperty(AppConstant.WENT_WRONG_MESSAGE));
    }

    @Override
    public ResponseEntity<ApiResponse> saveData(TaskDto taskDto) throws Exception {
        var validateData = validateTaskBeforeStore(taskDto);
        if (validateData != null) return validateData;

        taskDto.setAssignedTo(getAssignedTo(taskDto.getAssignedTo()));
        taskDto.setAllocatedAt(LocalDateTime.now());
        var entity = taskMapper.toEntity(taskDto);
        repository.save(entity);

        return ResponseApiWrapper.okRequest(propertyFetcher.getProperty(AppConstant.SAVE_SUCCESS_MESSAGE));
    }

    private UserDto getAssignedTo(UserDto userDto) throws Exception {
        if (Objects.nonNull(userDto) && userDto.getId() != null) {
            var data = userService.readData(userDto.getId());
            return data;
        }
        throw new Exception("User data not set");
    }

    private ResponseEntity<ApiResponse> validateTaskBeforeStore(TaskDto taskDto) {
        var dateTimeChecker = serviceValidator.dateTimeChecker(taskDto.getEta(), propertyFetcher);
        if (dateTimeChecker != null) return dateTimeChecker;
        var idChecker = serviceValidator.idChecker(taskDto.getId(), propertyFetcher);
        if (idChecker != null) return idChecker;

        return null;
    }

}
