package official.sellandbuymotobike.service;

import official.sellandbuymotobike.dto.PostDto;
import official.sellandbuymotobike.entity.Post;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
    public Post save(PostDto postDto);
}
