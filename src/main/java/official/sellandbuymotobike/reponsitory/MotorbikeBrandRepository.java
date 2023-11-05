package official.sellandbuymotobike.reponsitory;

import official.sellandbuymotobike.entity.MotorbikeBrand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotorbikeBrandRepository extends JpaRepository<MotorbikeBrand,Integer> {
    MotorbikeBrand getMotorbikeBrandByID(Integer id);
}
