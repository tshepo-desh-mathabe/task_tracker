package co.za.task.tracker.util.mapper;

import co.za.task.tracker.entity.SecureAccount;
import co.za.task.tracker.entity.dto.SecureAccountDto;
import co.za.task.tracker.util.helper.mapper.IFieldPropertyMapper;
import co.za.task.tracker.util.helper.mapper.IModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SecureAccountMapperImpl implements IModelMapper<SecureAccount, SecureAccountDto> {

    @Override
    public SecureAccount toEntity(SecureAccountDto dto) {
        return convertToEntity(dto);
    }

    @Override
    public SecureAccountDto toDto(SecureAccount entity) {
        return convertToDto(entity);
    }

    private SecureAccountDto convertToDto(SecureAccount secureAccount) {
        if (secureAccount != null) {
            IFieldPropertyMapper<SecureAccountDto> mapper = destination -> {
                destination.setId(secureAccount.getId());
                destination.setIsEnabled(secureAccount.getIsEnabled());
                destination.setIsAccountExpired(secureAccount.getIsAccountExpired());
                destination.setIsAccountNonLocked(secureAccount.getIsAccountNonLocked());
                destination.setIsCredentialsExpired(secureAccount.getIsCredentialsExpired());

                return destination;
            };

            return mapper.mapTo(new SecureAccountDto());
        } else {
            return null;
        }
    }

    private SecureAccount convertToEntity(SecureAccountDto secureAccountDto) {
        if (secureAccountDto != null) {
            IFieldPropertyMapper<SecureAccount> mapper = destination -> {
                destination.setId(secureAccountDto.getId());
                destination.setIsEnabled(secureAccountDto.getIsEnabled());
                destination.setIsAccountExpired(secureAccountDto.getIsAccountExpired());
                destination.setIsAccountNonLocked(secureAccountDto.getIsAccountNonLocked());
                destination.setIsCredentialsExpired(secureAccountDto.getIsCredentialsExpired());

                return destination;
            };

            return mapper.mapTo(new SecureAccount());
        } else {
            return null;
        }
    }
}
