package official.sellandbuymotobike.controller;

import lombok.AllArgsConstructor;
import official.sellandbuymotobike.dto.UserDto;
import official.sellandbuymotobike.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

@Controller
@AllArgsConstructor
@SessionAttributes("userdto")
public class UserController {

    private UserService userService;
    @ModelAttribute("userdto")
    public UserDto userDto(){
        return new UserDto();
    }

    // registration
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

    // login
    @GetMapping("/login")
    public String showLoginForm(){
        return "/login";
    }
    @PostMapping("/login")
    public String Login(@ModelAttribute("userdto") UserDto userDto){
        if(userService.checkUserbyEmail(userDto.getEmail())==false){
            return "redirect:/login?emailwrong";
        }
        if(userService.checkPasswordUser(userDto.getEmail(),userDto.getPassword())){
            return "redirect:/home?success";
        }

        return "redirect:/login?passwordwrong";
    }

    //logout
    @GetMapping("/logout")
    public String Logout(@ModelAttribute("userdto") UserDto userDto, WebRequest request, SessionStatus status){
        status.setComplete();
        request.removeAttribute("userdto",WebRequest.SCOPE_SESSION);
        return "redirect:/login";
    }
}