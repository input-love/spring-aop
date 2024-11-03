package andrew.samardak.spring_aop.service;

import andrew.samardak.spring_aop.dto.request.TransactionRequestDto;
import andrew.samardak.spring_aop.dto.response.TransactionResponseDto;
import andrew.samardak.spring_aop.entity.Transaction;

public interface TransactionService extends CRUDService<Transaction, Long> {

    Transaction transactionRequestDtoToTransaction(TransactionRequestDto dto);

    TransactionResponseDto transactionToTransactionResponseDto(Transaction entity);
}
