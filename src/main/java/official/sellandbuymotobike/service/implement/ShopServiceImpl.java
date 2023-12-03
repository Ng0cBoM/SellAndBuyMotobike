package official.sellandbuymotobike.service.implement;

import official.sellandbuymotobike.entity.Shop;
import official.sellandbuymotobike.reponsitory.ShopRepository;
import official.sellandbuymotobike.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopRepository shopRepository;
    @Override
    public Shop GetShopByUserId(Integer id) {
        List<Shop> shopList = shopRepository.findAll();
        for (Shop shop: shopList) {
            if (shop.getUser().getID() == id){
                return shop;
            }
        }
        return null;
    }
}
