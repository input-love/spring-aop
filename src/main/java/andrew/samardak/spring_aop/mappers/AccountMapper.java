package andrew.samardak.spring_aop.mappers;

import andrew.samardak.spring_aop.dto.request.AccountRequestDto;
import andrew.samardak.spring_aop.dto.response.AccountResponseDto;
import andrew.samardak.spring_aop.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    Account toEntity(AccountRequestDto dto);

    AccountResponseDto toDto(Account entity);
}
