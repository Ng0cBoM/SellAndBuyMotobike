package official.sellandbuymotobike.dto.mapper;


import official.sellandbuymotobike.dto.MotorbikeDto;
import official.sellandbuymotobike.entity.*;

public class MotorbikeMapper {
☺    public static Motorbike MotorbikeDtoToMotorbike(MotorbikeDto motorbikeDto,
                                                     MotorbikeBrand brand,
                                                     MotorbikeModel model,
                                                     MotorbikeType type,
                                                     MotorbikeEngineCapacity capacity){
        Motorbike tmp = new Motorbike();
        tmp.setPrice(motorbikeDto.getPrice());
        tmp.setStatus(motorbikeDto.getStatus());
        tmp.setLicensePlates(motorbikeDto.getLicensePlates());
        tmp.setOdometer(motorbikeDto.getOdometer());
        tmp.setMotorbikeBrand(brand);
        tmp.setMotorbikeModel(model);
        tmp.setMotorbikeType(type);
        tmp.setMotorbikeEngineCapacity(capacity);
        return tmp;
    }
}
