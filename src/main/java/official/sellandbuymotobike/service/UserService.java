package official.sellandbuymotobike.service;

import official.sellandbuymotobike.entity.User;
import official.sellandbuymotobike.model.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public UserDto getUserByUsername(String username);
}
