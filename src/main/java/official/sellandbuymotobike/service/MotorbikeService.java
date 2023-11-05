package official.sellandbuymotobike.service;

import official.sellandbuymotobike.dto.MotorbikeDto;
import official.sellandbuymotobike.entity.MotorbikeBrand;
import official.sellandbuymotobike.entity.MotorbikeEngineCapacity;
import official.sellandbuymotobike.entity.MotorbikeModel;
import official.sellandbuymotobike.entity.MotorbikeType;
import org.springframework.stereotype.Service;

@Service
public interface MotorbikeService {

    void  save(MotorbikeDto motorbikeDto,
               MotorbikeBrand brand,
               MotorbikeModel model,
               MotorbikeType type,
               MotorbikeEngineCapacity engineCapacity);
}
