package official.sellandbuymotobike.service;

import official.sellandbuymotobike.dto.UserDto;
import official.sellandbuymotobike.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void save(UserDto userDto);
    Boolean checkPasswordUser(String email,String password);
    Boolean checkUserbyEmail(String email);
    User getUserbyEmail(String email);
}
