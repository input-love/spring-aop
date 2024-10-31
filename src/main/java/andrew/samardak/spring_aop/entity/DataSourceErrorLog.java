package andrew.samardak.spring_aop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class DataSourceErrorLog {
    @Id
    private Long id;
}
