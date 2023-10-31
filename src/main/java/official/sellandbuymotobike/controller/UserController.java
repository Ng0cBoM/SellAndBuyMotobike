package official.sellandbuymotobike.controller;

import lombok.AllArgsConstructor;
import official.sellandbuymotobike.dto.UserDto;
import official.sellandbuymotobike.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class UserController {

    private UserService userService;
    @ModelAttribute("userdto")
    public UserDto userResgistrationDto(){
        return new UserDto();
    }
    @GetMapping("/registration")
    public String showRegistrationForm(){
        return "/registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("userdto") UserDto userDto){
        if(userService.checkUserbyEmail(userDto.getEmail())){
            return "redirect:/registration?emailexist";
        }
        if(userDto.getPassword().equals(userDto.getCheckPassword())==false){
            return "redirect:/registration?checkpass";
        }
        userService.save(userDto);
        return "redirect:/registration?success";
    }
}