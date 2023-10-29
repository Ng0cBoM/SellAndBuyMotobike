package official.sellandbuymotobike.service.implement;

import official.sellandbuymotobike.entity.User;
import official.sellandbuymotobike.model.dto.UserDto;
import official.sellandbuymotobike.reponsitory.UserRepository;
import official.sellandbuymotobike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userReponsitory;

    @Override
    public void save(UserDto userDto) {
        LocalDateTime Date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String creationDate = Date.format(formatter);
        User user = new User(userDto.getName(),
                userDto.getEmail(),
                userDto.getPhone(),
                userDto.getUsername(),
                userDto.getPassword(),
                creationDate
        );
        userReponsitory.save(user);
    }
    @Override
    public Boolean checkPasswordUser(String username, String password) {
        User user = userReponsitory.findUserByUsername(username);
        if (user.getPassword().equals(password)) return true;
        return false;
    }

    @Override
    public Boolean checkUserByEmail(String email) {
        User user = userReponsitory.findUserByEmail(email);
        if(user==null) return false;
        return true;
    }

    @Override
    public Boolean checkUserByPhone(String phone) {
        User user = userReponsitory.findUserByPhone(phone);
        if(user==null) return false;
        return true;
    }

    @Override
    public Boolean checkUserByUsername(String username) {
        User user = userReponsitory.findUserByUsername(username);
        if(user==null) return false;
        return true;
    }

    @Override
    public User getUserbyUsername(String username) {
        return  userReponsitory.getUserByUsername(username);
    }
}
