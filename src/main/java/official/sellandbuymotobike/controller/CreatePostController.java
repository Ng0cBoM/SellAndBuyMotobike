package official.sellandbuymotobike.controller;

import lombok.AllArgsConstructor;
import official.sellandbuymotobike.dto.MotorbikeDto;
import official.sellandbuymotobike.dto.PostDto;
import official.sellandbuymotobike.dto.UserDto;
import official.sellandbuymotobike.entity.MotorbikeBrand;
import official.sellandbuymotobike.entity.User;
import official.sellandbuymotobike.reponsitory.MotorbikeBrandRepository;
import official.sellandbuymotobike.reponsitory.MotorbikeEngineCapacityRepository;
import official.sellandbuymotobike.reponsitory.MotorbikeModelRepository;
import official.sellandbuymotobike.reponsitory.MotorbikeTypeRepository;
import official.sellandbuymotobike.service.MotorbikeService;
import official.sellandbuymotobike.service.PostService;
import official.sellandbuymotobike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class CreatePostController {

    private UserService userService;
    private PostService postService;
    private MotorbikeService motorbikeService;

    @Autowired
    private MotorbikeBrandRepository brandRepository;
    @Autowired
    private MotorbikeModelRepository modelRepository;
    @Autowired
    private MotorbikeTypeRepository typeRepository;
    @Autowired
    private MotorbikeEngineCapacityRepository capacityRepository;

    @ModelAttribute("postDto")
    public PostDto postDto(){
        return new PostDto();
    }
    @ModelAttribute("userDto")
    public UserDto userDto(){
        return new UserDto();
    }
    @ModelAttribute("motorbikeDto")
    public MotorbikeDto motorbikeDto(){
        return new MotorbikeDto();
    }

    @GetMapping("/post")
    public String showCreatePostForm(){
        return "/post";
    }
    @PostMapping("/post")
    public String createPost(@ModelAttribute("userDto") UserDto userDto,
                             @ModelAttribute("postDto") PostDto postDto,
                             @ModelAttribute("motorbikeDto") MotorbikeDto motorbikeDto,
                             @RequestParam int brandId,
                             @RequestParam int modelId,
                             @RequestParam int typeId,
                             @RequestParam int capacityId){
        User user = userService.getUserbyEmail(userDto.getEmail());
        //MotorbikeBrand motorbikeBrand = modelRepository.getMotorbikeModelByID(Integer.parseInt(brandId));
        postService.save(postDto);
        //motorbikeService.save(motorbikeDto);

        return null;
    }


}
