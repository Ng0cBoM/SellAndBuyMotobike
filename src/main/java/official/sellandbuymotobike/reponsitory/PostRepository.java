package official.sellandbuymotobike.reponsitory;

import official.sellandbuymotobike.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface PostRepository extends JpaRepository<Post,Integer> {

}
