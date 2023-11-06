package official.sellandbuymotobike.dto.mapper;

import official.sellandbuymotobike.dto.PostDto;
import official.sellandbuymotobike.entity.Post;

public class PostMapper {
        public  static Post PostDtoToPost(PostDto postDto){
            Post tmp = new Post();
            tmp.setTitle(postDto.getTitle());
            tmp.setDescription(postDto.getDescription());
            tmp.setAddress(postDto.getAddress());
            tmp.setState(postDto.isState());
            return  tmp;
        }
}
