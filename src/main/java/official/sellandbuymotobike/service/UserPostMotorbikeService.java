package official.sellandbuymotobike.service;

import official.sellandbuymotobike.dto.PostDto;
import official.sellandbuymotobike.entity.Motorbike;
import official.sellandbuymotobike.entity.Post;
import official.sellandbuymotobike.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserPostMotorbikeService {
    void save(User user, Post post, Motorbike motorbike);
}
