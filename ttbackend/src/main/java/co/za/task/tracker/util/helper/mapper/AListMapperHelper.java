package co.za.task.tracker.util.helper.mapper;

import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Helps with mapping a collection
 * @param <E> entity
 * @param <D> dto
 */
@Component
public abstract class AListMapperHelper<E, D> implements IModelMapper<E, D> {

    @Override
    public Set<E> toEntity(Set<D> dtos) {
        return dtos.stream().map(i -> toEntity(i)).collect(Collectors.toSet());
    }

    @Override
    public Set<D> toDto(Set<E> entities) {
        return entities.stream().map(i -> toDto(i)).collect(Collectors.toSet());
    }
}
