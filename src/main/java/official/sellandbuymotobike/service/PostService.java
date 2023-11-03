package official.sellandbuymotobike.service;

import official.sellandbuymotobike.dto.PostDto;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
    void save(PostDto postDto);
}
