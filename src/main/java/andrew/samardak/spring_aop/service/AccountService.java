package andrew.samardak.spring_aop.service;

import andrew.samardak.spring_aop.dto.request.AccountRequestDto;
import andrew.samardak.spring_aop.dto.response.AccountResponseDto;
import andrew.samardak.spring_aop.entity.Account;

public interface AccountService extends CRUDService<Account, Long> {

    Account accountRequestDtoToAccount(AccountRequestDto dto);

    AccountResponseDto accountToAccountResponseDto(Account entity);
}
