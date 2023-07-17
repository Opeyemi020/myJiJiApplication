package africa.semicolon.data.models;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    @CreatedDate
    private BigDecimal price;
    private LocalDateTime datePosted;


}
