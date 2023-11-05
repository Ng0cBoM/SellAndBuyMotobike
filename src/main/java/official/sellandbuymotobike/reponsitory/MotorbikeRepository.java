package official.sellandbuymotobike.reponsitory;

import official.sellandbuymotobike.entity.Motorbike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface MotorbikeRepository extends JpaRepository<Motorbike,Integer> {

}
