package co.za.task.tracker.util.mapper;

import co.za.task.tracker.entity.EmailAddress;
import co.za.task.tracker.entity.dto.EmailAddressDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface IEmailAddressMapper {
    @Mapping(source = "emailId", target = "id")
    @Mapping(source = "address", target = "email")
    EmailAddressDto toDto(EmailAddress emailAddress);

    @Mapping(source = "id", target = "emailId")
    @Mapping(source = "email", target = "address")
    EmailAddress toEntity(EmailAddressDto emailAddressDto);
}
