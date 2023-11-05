package official.sellandbuymotobike.service.implement;

import official.sellandbuymotobike.dto.MotorbikeDto;
import official.sellandbuymotobike.entity.*;
import official.sellandbuymotobike.reponsitory.MotorbikeRepository;
import official.sellandbuymotobike.service.MotorbikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class MotorbikeServiceImpl  implements MotorbikeService {
    @Autowired
    private MotorbikeRepository motorbikeRepository;
    @Override
    public void save(MotorbikeDto motorbikeDto,
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
        motorbikeRepository.save(motorbike);
    }
}
