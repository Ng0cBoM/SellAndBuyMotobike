package official.sellandbuymotobike.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private String email;
    private String name;
    private String password;
    private String checkPassword;

    public UserDto(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }
}
