package official.sellandbuymotobike.service;

import official.sellandbuymotobike.dto.MotorbikeDto;
import org.springframework.stereotype.Service;

@Service
public interface MotorbikeService {

    void  save(MotorbikeDto motorbikeDto);
}
