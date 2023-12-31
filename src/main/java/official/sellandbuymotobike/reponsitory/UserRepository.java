package official.sellandbuymotobike.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import official.sellandbuymotobike.entity.User;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User,Integer> {

    User getUserByID(Integer id);
    User getUserByEmail(String email);
    User findUserByEmail(String email);
    @Query(
            value = "select * from dbo_users",
            nativeQuery = true)
    List<User> getAllUser();
}