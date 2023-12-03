package official.sellandbuymotobike.controller;

import lombok.AllArgsConstructor;
import official.sellandbuymotobike.dto.MotorbikeDto;
import official.sellandbuymotobike.dto.PostDto;
import official.sellandbuymotobike.dto.UserDto;
import official.sellandbuymotobike.entity.User;
import official.sellandbuymotobike.entity.relationship.UserPostMotorbike;
import official.sellandbuymotobike.reponsitory.*;
import official.sellandbuymotobike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@AllArgsConstructor
@SessionAttributes("userDto")
public class PostController {

    private UserService userService;

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

    @GetMapping("/post/{id}")
    public String showPost(@ModelAttribute("userDto") UserDto userDto, Model model,
                              @PathVariable Integer id) {
        //--------------------Bộ Lọc ------------------------------//
        User user = userService.getUserbyEmail(userDto.getEmail());
        if(user ==null){
            return "redirect:/login";
        }
        model.addAttribute("user", user);
        UserPostMotorbike userPostMotorbike = userPostMotorbikeRepository.findUserPostMotorbikeByID(id);
        model.addAttribute("userpostmotorbike",userPostMotorbike);
        return "/motorbike";

    }
}
