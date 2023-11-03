package official.sellandbuymotobike.reponsitory;

import official.sellandbuymotobike.entity.Motorbike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotorbikeRepository extends JpaRepository<Motorbike,Integer> {

}
