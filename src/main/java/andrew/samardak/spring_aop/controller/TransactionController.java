package andrew.samardak.spring_aop.controller;

import andrew.samardak.spring_aop.aspect.LogDataSourceError;
import andrew.samardak.spring_aop.dto.request.TransactionRequestDto;
import andrew.samardak.spring_aop.dto.response.TransactionResponseDto;
import andrew.samardak.spring_aop.entity.Transaction;
import andrew.samardak.spring_aop.service.TransactionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@LogDataSourceError
@RequiredArgsConstructor
@RequestMapping("/api/v1/transactions")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TransactionController {

    TransactionService service;

    @PostMapping
    public ResponseEntity<TransactionResponseDto> create(
            @RequestBody TransactionRequestDto dto
    ) {
        Transaction request = service.transactionRequestDtoToTransaction(dto);
        Transaction transaction = service.create(request);
        TransactionResponseDto response = service.transactionToTransactionResponseDto(transaction);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponseDto> read(
            @PathVariable Long id
    ) {
        Transaction transaction = service.read(id);
        TransactionResponseDto response = service.transactionToTransactionResponseDto(transaction);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TransactionResponseDto> update(
            @PathVariable Long id,
            @RequestBody TransactionRequestDto dto
    ) {
        Transaction request = service.transactionRequestDtoToTransaction(dto);
        request.setId(id);

        Transaction transaction = service.update(request);

        TransactionResponseDto response = service.transactionToTransactionResponseDto(transaction);

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
