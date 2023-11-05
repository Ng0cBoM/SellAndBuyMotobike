package official.sellandbuymotobike.reponsitory;


import official.sellandbuymotobike.entity.MotorbikeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotorbikeModelRepository extends JpaRepository<MotorbikeModel,Integer> {
    MotorbikeModel getMotorbikeModelByID(Integer id);
}
