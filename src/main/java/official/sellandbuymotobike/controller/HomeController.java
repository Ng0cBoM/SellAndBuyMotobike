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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@SessionAttributes("userDto")
public class HomeController {

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
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MotorbikeRepository motorbikeRepository;
    @Autowired
    private PostRepository postRepository;

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

    @GetMapping("/home")
    public String showAllPost(@ModelAttribute("userDto") UserDto userDto,Model model,
                              @RequestParam(name = "brand", required = false) Integer brandId,
                              @RequestParam(name = "model", required = false) Integer modelId,
                              @RequestParam(name = "type", required = false) Integer typeId,
                              @RequestParam(name = "capacity", required = false) Integer capacityId,
                              @RequestParam(name = "status", required = false) String status) {
        //--------------------Bộ Lọc ------------------------------//
        List<MotorbikeBrand> brandList = brandRepository.findAll();
        List<MotorbikeModel> modelList = modelRepository.findAll();
        List<MotorbikeType> typeList = typeRepository.findAll();
        List<MotorbikeEngineCapacity> capacityList = capacityRepository.findAll();
        model.addAttribute("brands",brandList);
        model.addAttribute("models",modelList);
        model.addAttribute("types",typeList);
        model.addAttribute("capacities",capacityList);
        //--------------------Các Bài Viết -----------------------//
        List<UserPostMotorbike> userPostMotorbikeList = new ArrayList<>();

        if (brandId==null && modelId==null && typeId ==null && capacityId== null && (status==""||status==null)){
            userPostMotorbikeList = userPostMotorbikeRepository.findAll();
        }
        else {

        }
        model.addAttribute("userpostmotorbikelist",userPostMotorbikeList);
        return "/home";
    }



}
