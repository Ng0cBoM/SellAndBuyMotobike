package official.sellandbuymotobike.reponsitory;

import official.sellandbuymotobike.entity.Shop;
import official.sellandbuymotobike.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop,Integer> {
}
