package official.sellandbuymotobike.reponsitory;

import official.sellandbuymotobike.entity.MotorbikeEngineCapacity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotorbikeEngineCapacityRepository extends JpaRepository<MotorbikeEngineCapacity,Integer> {
    MotorbikeEngineCapacity getMotorbikeEngineCapacityByID(Integer id);
}
