package official.sellandbuymotobike.reponsitory;

import official.sellandbuymotobike.entity.MotorbikeModel;
import official.sellandbuymotobike.entity.MotorbikeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotorbikeTypeRepository extends JpaRepository<MotorbikeType,Integer> {
    MotorbikeType getMotorbikeTypeByID(Integer id);
}
