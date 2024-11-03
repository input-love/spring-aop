package andrew.samardak.spring_aop.dto.response;

import andrew.samardak.spring_aop.utils.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponseDto {

    private Long id;

    private AccountType accountType;

    private BigDecimal balance;
}
