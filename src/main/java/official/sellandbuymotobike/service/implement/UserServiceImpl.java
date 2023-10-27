package official.sellandbuymotobike.service.implement;

import official.sellandbuymotobike.entity.User;
import official.sellandbuymotobike.model.dto.UserDto;
import official.sellandbuymotobike.model.mapper.UserMapper;
import official.sellandbuymotobike.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserServiceImpl implements UserService {
    private  static ArrayList<User> users = new ArrayList<User>();
    static {
        users.add(new User(1,"name1","email1","phone1","username1","password1"));
        users.add(new User(2,"name2","email2","phone2","username2","password3"));
        users.add(new User(3,"name3","email3","phone3","username3","password3"));
    }

    @Override
    public UserDto getUserByUsername(String username) {
        for (User user : users){
            if (user.getUsername().equals(username)){
                return UserMapper.toUserDto(user);
            }
        }
        return  null;
    }
}
