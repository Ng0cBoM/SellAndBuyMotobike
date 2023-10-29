package official.sellandbuymotobike.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class UserDto implements Serializable {
    private String name;
    private String email;
    private String phone;
    private String username;
    private String password;
    private String checkPassword;

    public UserDto(String name, String email, String phone, String username, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }
}
