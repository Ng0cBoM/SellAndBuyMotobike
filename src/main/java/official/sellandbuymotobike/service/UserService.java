package official.sellandbuymotobike.service;

import official.sellandbuymotobike.entity.User;
import official.sellandbuymotobike.model.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void save(UserDto userDto);
    Boolean checkPasswordUser(String username,String password);
    Boolean checkUserByEmail(String email);
    Boolean checkUserByPhone(String phone);
    Boolean checkUserByUsername(String username);
    User getUserbyUsername(String username);
}
