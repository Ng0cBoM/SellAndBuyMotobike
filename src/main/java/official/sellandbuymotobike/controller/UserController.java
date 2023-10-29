package official.sellandbuymotobike.controller;

import official.sellandbuymotobike.entity.User;
import official.sellandbuymotobike.model.dto.UserDto;
import official.sellandbuymotobike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("userdto") UserDto userDto){
        if(userService.checkUserByEmail(userDto.getEmail())){
            return "redirect:/registration?emailexist";
        }
        if(userService.checkUserByPhone(userDto.getPhone())){
            return "redirect:/registration?phoneexist";
        }
        if(userService.checkUserByUsername(userDto.getUsername())){
            return "redirect:/registration?usernameexist";
        }
        if(userDto.getPassword().equals(userDto.getCheckPassword())==false){
            return "redirect:/registration?checkpass";
        }
        userService.save(userDto);
        return "redirect:/registration?success";
    }
    @PostMapping("/login")
    public String Login(@ModelAttribute("userdto") UserDto userDto){
        if(userService.checkPasswordUser(userDto.getEmail(),userDto.getPassword())){
            return "redirect:/home?success";
        }
        return "redirect:/login?PasswordOrEmailWrong";
    }
}
