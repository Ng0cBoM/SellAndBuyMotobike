package official.sellandbuymotobike.service.implement;

import official.sellandbuymotobike.entity.Motorbike;
import official.sellandbuymotobike.entity.Post;
import official.sellandbuymotobike.entity.User;
import official.sellandbuymotobike.entity.relationship.UserPostMotorbike;
import official.sellandbuymotobike.reponsitory.UserPostMotorbikeRepository;
import official.sellandbuymotobike.service.UserPostMotorbikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPostMotorbikeServiceImpl  implements UserPostMotorbikeService {

    @Autowired
    private UserPostMotorbikeRepository userPostMotorbikeRepository;
    @Override
    public void save(User user, Post post, Motorbike motorbike) {
        UserPostMotorbike userPostMotorbike = new UserPostMotorbike(user, post, motorbike);
        userPostMotorbikeRepository.save(userPostMotorbike);
    }
}
