package official.sellandbuymotobike.reponsitory;

import official.sellandbuymotobike.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {

}
