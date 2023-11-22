package official.sellandbuymotobike.service.implement;

import official.sellandbuymotobike.dto.MotorbikeDto;
import official.sellandbuymotobike.entity.*;
import official.sellandbuymotobike.reponsitory.MotorbikeRepository;
import official.sellandbuymotobike.service.MotorbikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotorbikeServiceImpl  implements MotorbikeService {
    @Autowired
    private MotorbikeRepository motorbikeRepository;
    @Override
    public Motorbike save(MotorbikeDto motorbikeDto,
                               MotorbikeBrand brand,
                               MotorbikeModel model,
                               MotorbikeType type,
                               MotorbikeEngineCapacity engineCapacity)
    {
        Motorbike motorbike = new Motorbike(
                motorbikeDto.getPrice(),
                motorbikeDto.getStatus(),
                motorbikeDto.getLicensePlates(),
                motorbikeDto.getOdometer(),
                brand,
                model,
                type,
                engineCapacity);
        Motorbike savedMotorbike = motorbikeRepository.save(motorbike);
        return savedMotorbike ;
    }
}
