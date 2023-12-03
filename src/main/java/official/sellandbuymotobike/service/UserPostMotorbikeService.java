package official.sellandbuymotobike.service;

import official.sellandbuymotobike.dto.PostDto;
import official.sellandbuymotobike.entity.*;
import official.sellandbuymotobike.entity.relationship.UserPostMotorbike;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserPostMotorbikeService {
    void save(User user, Post post, Motorbike motorbike);

    List<UserPostMotorbike> filter(Integer brandId,
                                  Integer modelId,
                                  Integer typeId,
                                  Integer capacityId,
                                  String motorbikeStatus,
                                   String order);

}
