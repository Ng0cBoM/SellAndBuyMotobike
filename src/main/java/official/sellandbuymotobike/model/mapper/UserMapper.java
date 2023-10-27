package official.sellandbuymotobike.model.mapper;

import official.sellandbuymotobike.entity.User;
import official.sellandbuymotobike.model.dto.UserDto;

public class UserMapper {
    public  static UserDto toUserDto(User user){
        UserDto tmp = new UserDto();
        tmp.setId(user.getId());
        tmp.setEmail(user.getEmail());
        tmp.setName(user.getName());
        tmp.setPhone(user.getPhone());
        tmp.setUsername(user.getUsername());
        return  tmp;
    }
}
