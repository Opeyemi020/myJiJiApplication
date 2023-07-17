package africa.semicolon.dtos.requests;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
@Data
public class PostProductRequest {
    private String name;
    private String description;
    private BigDecimal price;
}
