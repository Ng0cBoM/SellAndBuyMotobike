package official.sellandbuymotobike.controller;

import lombok.AllArgsConstructor;
import official.sellandbuymotobike.dto.MotorbikeDto;
import official.sellandbuymotobike.dto.PostDto;
import official.sellandbuymotobike.dto.UserDto;
import official.sellandbuymotobike.entity.*;
import official.sellandbuymotobike.entity.relationship.UserPostMotorbike;
import official.sellandbuymotobike.reponsitory.*;
import official.sellandbuymotobike.service.MotorbikeService;
import official.sellandbuymotobike.service.PostService;
import official.sellandbuymotobike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@SessionAttributes("userDto")
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
    @Autowired
    private UserPostMotorbikeRepository userPostMotorbikeRepository;

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
    public String showCreatePostForm(@ModelAttribute("userDto") UserDto userDto, Model model) {
        List<MotorbikeBrand> brandList = brandRepository.findAll();
        List<MotorbikeModel> modelList = modelRepository.findAll();
        List<MotorbikeType> typeList = typeRepository.findAll();
        List<MotorbikeEngineCapacity> capacityList = capacityRepository.findAll();
        model.addAttribute("brands",brandList);
        model.addAttribute("models",modelList);
        model.addAttribute("types",typeList);
        model.addAttribute("capacities",capacityList);
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
        MotorbikeBrand brand = brandRepository.getMotorbikeBrandByID(Integer.parseInt(String.valueOf(brandId)));
        MotorbikeModel model = modelRepository.getMotorbikeModelByID(Integer.parseInt(String.valueOf(modelId)));
        MotorbikeType type = typeRepository.getMotorbikeTypeByID(Integer.parseInt(String.valueOf(typeId)));
        MotorbikeEngineCapacity capacity = capacityRepository.getMotorbikeEngineCapacityByID(Integer.parseInt(String.valueOf(capacityId)));

        Post savedPost = postService.save(postDto);

        Motorbike savedMotorbike = motorbikeService.save(motorbikeDto,brand,model,type,capacity);

        UserPostMotorbike userPostMotorbike = new UserPostMotorbike();
        userPostMotorbike.setUser(user);
        userPostMotorbike.setPost(savedPost);
        userPostMotorbike.setMotorbike(savedMotorbike);
        userPostMotorbikeRepository.save(userPostMotorbike);
        return "redirect:/home";
    }


}
