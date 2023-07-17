package africa.semicolon.dtos.requests;

import lombok.Data;

@Data
public class RegisterSellerRequest {
    String password;
    String username;
}
