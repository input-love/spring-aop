package andrew.samardak.spring_aop.dto.request;

import andrew.samardak.spring_aop.utils.enums.AccountType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequestDto {

    @NotNull
    @Size(
            min = 5,
            max = 255,
            message = "Account type must be between 5 and 255 characters long."
    )
    private AccountType accountType;

    @NotNull
    private BigDecimal balance;
}
