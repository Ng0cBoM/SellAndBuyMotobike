package official.sellandbuymotobike.reponsitory;

import official.sellandbuymotobike.entity.User;
import official.sellandbuymotobike.entity.relationship.UserPostMotorbike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface UserPostMotorbikeRepository extends JpaRepository<UserPostMotorbike,Integer> {
    UserPostMotorbike findUserPostMotorbikeByID(Integer id);

    List<UserPostMotorbike> findUserPostMotorbikeByUser(User user);
}