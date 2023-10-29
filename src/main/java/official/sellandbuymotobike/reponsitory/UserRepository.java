package official.sellandbuymotobike.reponsitory;

import official.sellandbuymotobike.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User,Integer> {
    User getUserByUsername(String username);
    User findUserByUsername(String username);
    User findUserByEmail (String email);
    User findUserByPhone (String phone);

}
