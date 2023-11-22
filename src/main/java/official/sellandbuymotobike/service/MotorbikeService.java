package official.sellandbuymotobike.service;

import official.sellandbuymotobike.dto.MotorbikeDto;
import official.sellandbuymotobike.entity.*;
import org.springframework.stereotype.Service;

@Service
public interface MotorbikeService {

    public Motorbike save(MotorbikeDto motorbikeDto,
                          MotorbikeBrand brand,
                          MotorbikeModel model,
                          MotorbikeType type,
                          MotorbikeEngineCapacity engineCapacity);
}
