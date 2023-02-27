package co.za.task.tracker.util.mapper;

import co.za.task.tracker.entity.EmailAddress;
import co.za.task.tracker.entity.dto.EmailAddressDto;
import co.za.task.tracker.util.helper.IFieldPropertyMapper;
import co.za.task.tracker.util.helper.IModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EmailAddressMapperImpl implements IModelMapper<EmailAddress, EmailAddressDto> {

    @Override
    public EmailAddress toEntity(EmailAddressDto dto) {
        return convertToEntity(dto);
    }

    @Override
    public EmailAddressDto toDto(EmailAddress entity) {
        return convertToDto(entity);
    }

    private EmailAddressDto convertToDto(EmailAddress emailAddress) {
        if (emailAddress != null) {
            IFieldPropertyMapper<EmailAddressDto> mapper = destination -> {
                destination.setId(emailAddress.getEmailId());
                destination.setEmail(emailAddress.getAddress());

                return destination;
            };

            return mapper.mapTo(new EmailAddressDto());
        } else {
            return null;
        }
    }

    private EmailAddress convertToEntity(EmailAddressDto emailAddressDto) {
        if (emailAddressDto != null) {
            IFieldPropertyMapper<EmailAddress> mapper = destination -> {
                destination.setEmailId(emailAddressDto.getId());
                destination.setAddress(emailAddressDto.getEmail());

                return destination;
            };

            return mapper.mapTo(new EmailAddress());
        } else {
            return null;
        }
    }
}
