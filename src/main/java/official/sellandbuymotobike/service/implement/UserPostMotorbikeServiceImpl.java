package official.sellandbuymotobike.service.implement;

import official.sellandbuymotobike.entity.Motorbike;
import official.sellandbuymotobike.entity.Post;
import official.sellandbuymotobike.entity.User;
import official.sellandbuymotobike.entity.relationship.UserPostMotorbike;
import official.sellandbuymotobike.reponsitory.UserPostMotorbikeRepository;
import official.sellandbuymotobike.service.UserPostMotorbikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserPostMotorbikeServiceImpl  implements UserPostMotorbikeService {

    @Autowired
    private UserPostMotorbikeRepository userPostMotorbikeRepository;
    @Override
    public void save(User user, Post post, Motorbike motorbike) {
        UserPostMotorbike userPostMotorbike = new UserPostMotorbike(user, post, motorbike);
        userPostMotorbikeRepository.save(userPostMotorbike);
    }

    @Override
    public List<UserPostMotorbike> filter(Integer brandId, Integer modelId, Integer typeId, Integer capacityId, String motorbikeStatus, String order) {

        List<UserPostMotorbike> userPostMotorbikeList = userPostMotorbikeRepository.findAll();
        List<UserPostMotorbike> itemsToRemove ;
        if (brandId!=null){
            itemsToRemove = new ArrayList<>();
            for (UserPostMotorbike userPostMotorbike: userPostMotorbikeList ) {
                if(userPostMotorbike.getMotorbike().getMotorbikeBrand().getID() != brandId.intValue()){
                    itemsToRemove.add(userPostMotorbike);
                }
            }
            userPostMotorbikeList.removeAll(itemsToRemove);
        }
        if (modelId!=null){
            itemsToRemove = new ArrayList<>();
            for (UserPostMotorbike userPostMotorbike: userPostMotorbikeList ) {
                if(userPostMotorbike.getMotorbike().getMotorbikeModel().getID() != modelId.intValue()){
                    itemsToRemove.add(userPostMotorbike);
                }
            }
            userPostMotorbikeList.removeAll(itemsToRemove);
        }
        if (typeId!=null){
            itemsToRemove = new ArrayList<>();
            for (UserPostMotorbike userPostMotorbike: userPostMotorbikeList ) {
                if(userPostMotorbike.getMotorbike().getMotorbikeType().getID() != typeId.intValue()){
                    itemsToRemove.add(userPostMotorbike);
                }
            }
            userPostMotorbikeList.removeAll(itemsToRemove);
        }
        if (capacityId!=null){
            itemsToRemove = new ArrayList<>();
            for (UserPostMotorbike userPostMotorbike: userPostMotorbikeList ) {
                if(userPostMotorbike.getMotorbike().getMotorbikeEngineCapacity().getID() != capacityId.intValue()){
                    itemsToRemove.add(userPostMotorbike);
                }
            }
            userPostMotorbikeList.removeAll(itemsToRemove);
        }
        if (!(motorbikeStatus==null || motorbikeStatus=="")){
            itemsToRemove = new ArrayList<>();
            for (UserPostMotorbike userPostMotorbike: userPostMotorbikeList ) {
                if(!userPostMotorbike.getMotorbike().getStatus().equalsIgnoreCase(motorbikeStatus)){
                    itemsToRemove.add(userPostMotorbike);
                }
            }
            userPostMotorbikeList.removeAll(itemsToRemove);
        }
        if(order.equalsIgnoreCase("date")){
            Collections.reverse(userPostMotorbikeList);
        }
        else if (order.equalsIgnoreCase("price")){
            for (int i = 0; i < userPostMotorbikeList.size() - 1; i++) {
                for (int j = 0; j < userPostMotorbikeList.size() - i - 1; j++) {
                    if (userPostMotorbikeList.get(j).getMotorbike().getPrice() > userPostMotorbikeList.get(j + 1).getMotorbike().getPrice()) {
                        UserPostMotorbike tmp = userPostMotorbikeList.get(j);
                        userPostMotorbikeList.set(j, userPostMotorbikeList.get(j + 1));
                        userPostMotorbikeList.set(j + 1, tmp);
                    }
                }
            }
        } else if (order.equalsIgnoreCase("priceDesc")) {
            for (int i = 0; i < userPostMotorbikeList.size() - 1; i++) {
                for (int j = 0; j < userPostMotorbikeList.size() - i - 1; j++) {
                    if (userPostMotorbikeList.get(j).getMotorbike().getPrice() < userPostMotorbikeList.get(j + 1).getMotorbike().getPrice()) {
                        UserPostMotorbike tmp = userPostMotorbikeList.get(j);
                        userPostMotorbikeList.set(j, userPostMotorbikeList.get(j + 1));
                        userPostMotorbikeList.set(j + 1, tmp);
                    }
                }
            }
        }
        return userPostMotorbikeList;
    }
}
