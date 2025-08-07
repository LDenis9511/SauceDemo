package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class User {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String zip;
}