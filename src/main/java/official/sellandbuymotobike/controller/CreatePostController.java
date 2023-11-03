package official.sellandbuymotobike.controller;

import lombok.AllArgsConstructor;
import official.sellandbuymotobike.dto.MotorbikeDto;
import official.sellandbuymotobike.dto.PostDto;
import official.sellandbuymotobike.dto.UserDto;
import official.sellandbuymotobike.entity.Motorbike;
import official.sellandbuymotobike.service.MotorbikeService;
import official.sellandbuymotobike.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@AllArgsConstructor
public class CreatePostController {

    private PostService postService;
    private MotorbikeService motorbikeService;
    @ModelAttribute("postDto")
    public PostDto postDto(){
        return new PostDto();
    }

    /*@ModelAttribute("motorbikeDto")
    public MotorbikeDto motorbikeDto{ return new MotorbikeDto();}*/

}
