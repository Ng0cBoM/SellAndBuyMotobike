package official.sellandbuymotobike.service.implement;

import official.sellandbuymotobike.dto.PostDto;
import official.sellandbuymotobike.entity.Post;
import official.sellandbuymotobike.entity.User;
import official.sellandbuymotobike.reponsitory.PostRepository;
import official.sellandbuymotobike.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Override
    public void save(PostDto postDto) {
        LocalDateTime Date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String creationDate = Date.format(formatter);
        Post post = new Post(
                postDto.getTitle(),
                postDto.getDescription(),
                postDto.getAddress(),
                true,
                creationDate);
        postRepository.save(post);
    }
}
