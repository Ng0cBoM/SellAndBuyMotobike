package official.sellandbuymotobike.service.implement;

import official.sellandbuymotobike.dto.UserDto;
import official.sellandbuymotobike.entity.Shop;
import official.sellandbuymotobike.entity.User;
import official.sellandbuymotobike.reponsitory.ShopRepository;
import official.sellandbuymotobike.reponsitory.UserRepository;
import official.sellandbuymotobike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShopRepository shopRepository;

    @Override
    public void save(UserDto userDto) {
        LocalDateTime Date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String creationDate = Date.format(formatter);
        User user = new User(
                userDto.getEmail(),
                userDto.getName(),
                userDto.getPassword(),
                creationDate
        );
        User savedUser = userRepository.save(user);
        Shop shop = new Shop("", "", 0, savedUser);
        shopRepository.save(shop);
    }

    @Override
    public Boolean checkPasswordUser(String email, String password) {
        User user = userRepository.findUserByEmail(email);
        if (user.getPassword().equals(password)) return true;
        return false;
    }

    @Override
    public Boolean checkUserbyEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        if(user==null) return false;
        return true;
    }

    @Override
    public User getUserbyEmail(String email) {
        return userRepository.getUserByEmail(email);
    }
}

