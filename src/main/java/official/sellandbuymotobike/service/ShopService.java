package official.sellandbuymotobike.service;

import official.sellandbuymotobike.entity.Shop;
import org.springframework.stereotype.Service;

@Service
public interface ShopService {
    Shop GetShopByUserId(Integer id);
}
