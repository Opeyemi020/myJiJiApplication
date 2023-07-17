package africa.semicolon.data.models;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.management.relation.Role;
import java.time.LocalDateTime;

@Document("user")
@Data
public class User {
    private String id;
    private String username;
    private String password;
    private Role userRole;
    @CreatedDate
    private LocalDateTime dateRegistered;


}
