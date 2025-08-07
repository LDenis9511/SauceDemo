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
    @Builder.Default
    private String username = "standard_user";
    @Builder.Default
    private String password = "secret_sauce";
    private String firstname;
    private String lastname;
    private String zip;
}
