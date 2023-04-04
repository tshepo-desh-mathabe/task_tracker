package co.za.task.tracker.util.helper.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ServiceHelperImpl<R, E, D> {
//    private final IPropertyFetcher<AppConstant> propertyFetcher;
//    private final IValidator<Boolean, LocalDateTime> dateTimeIValidator;
//
//    @Override
//    public ResponseEntity<ApiResponse> findByDataWithId(R repository, Long id, AListMapperHelper<E, D> mapper) {
//        var repo = getRepository(repository).findById(id);
//        if (repo.isPresent()) {
//            var dto = mapper.toDto((E) repo.get());
//            return ResponseApiWrapper.okRequest(dto);
//        }
//        return ResponseApiWrapper.badRequest(null);
//    }
//
//    @Override
//    public ResponseEntity<ApiResponse> getAllByPagination(R repository, ReadDataPayload pageData, AListMapperHelper<E, D> mapper) {
//        Pageable paging = PageRequest.of(pageData.pageNumber(), pageData.pageSize());
//        Page<?> pagedData = getRepository(repository).findAll(paging);
//
//        if (pagedData.hasContent()) {
//            Page<D> dtoPagedData = pagedData.map(e -> mapper.toDto((E) e));
//            return ResponseApiWrapper.okRequest(dtoPagedData);
//        }
//
//        return ResponseApiWrapper.badRequest(null);
//    }
//
//    @Override
//    public ResponseEntity<ApiResponse> deleteById(R repository, Long data) {
//        var id = (Long) data;
//        var repo = getRepository(repository);
//        if (repo.existsById(id)) {
//            repo.deleteById(id);
//            return ResponseApiWrapper.okRequest(propertyFetcher.getProperty(AppConstant.SUCCESS_DELETE_MESSAGE));
//        }
//        return ResponseApiWrapper.badRequest(propertyFetcher.getProperty(AppConstant.WENT_WRONG_MESSAGE));
//    }
//
//    @Override
//    public ResponseEntity<ApiResponse> saveData(R repository, D data, AListMapperHelper<E, D> mapper) {
//        var repo = getRepository(repository);
//        try {
//            var entity = mapper.toEntity((D) data);
//            repo.save(entity);
//        } catch (Exception e) {
//            return ResponseApiWrapper.badRequest(propertyFetcher.getProperty(AppConstant.WENT_WRONG_MESSAGE));
//        }
//        return ResponseApiWrapper.okRequest(propertyFetcher.getProperty(AppConstant.SAVE_SUCCESS_MESSAGE));
//    }
//
//    private ResponseEntity<ApiResponse> dataChecker(D data) {
//        if (data instanceof Defect defect) {
//
//        }
//    }
//
//    // todo - not type safe
//    private JpaRepository getRepository(Object repository) {
//        if (repository instanceof JpaRepository repo) {
//            return repo;
//        }
//        return null;
//    }
}
