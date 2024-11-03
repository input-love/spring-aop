package andrew.samardak.spring_aop.controller;

import andrew.samardak.spring_aop.aspect.LogDataSourceError;
import andrew.samardak.spring_aop.dto.request.AccountRequestDto;
import andrew.samardak.spring_aop.dto.response.AccountResponseDto;
import andrew.samardak.spring_aop.entity.Account;
import andrew.samardak.spring_aop.service.AccountService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@LogDataSourceError
@RequiredArgsConstructor
@RequestMapping("/api/v1/accounts")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountController {

    AccountService service;

    @PostMapping
    public ResponseEntity<AccountResponseDto> create(
            @RequestBody AccountRequestDto dto
    ) {
        Account request = service.accountRequestDtoToAccount(dto);
        Account account = service.create(request);
        AccountResponseDto response = service.accountToAccountResponseDto(account);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponseDto> read(
            @PathVariable Long id
    ) {
        Account account = service.read(id);
        AccountResponseDto response = service.accountToAccountResponseDto(account);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AccountResponseDto> update(
            @PathVariable Long id,
            @RequestBody AccountRequestDto dto
    ) {
        Account request = service.accountRequestDtoToAccount(dto);
        request.setId(id);

        Account account = service.update(request);

        AccountResponseDto response = service.accountToAccountResponseDto(account);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
