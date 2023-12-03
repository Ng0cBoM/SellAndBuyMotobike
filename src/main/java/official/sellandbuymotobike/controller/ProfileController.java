package official.sellandbuymotobike.controller;

import lombok.AllArgsConstructor;
import official.sellandbuymotobike.dto.MotorbikeDto;
import official.sellandbuymotobike.dto.PostDto;
import official.sellandbuymotobike.dto.UserDto;
import official.sellandbuymotobike.entity.Shop;
import official.sellandbuymotobike.entity.User;
import official.sellandbuymotobike.entity.relationship.UserPostMotorbike;
import official.sellandbuymotobike.reponsitory.*;
import official.sellandbuymotobike.service.ShopService;
import official.sellandbuymotobike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@AllArgsConstructor
@SessionAttributes("userDto")
public class ProfileController {
    private UserService userService;
    private ShopService shopService;

    @Autowired
    private UserPostMotorbikeRepository userPostMotorbikeRepository;

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private  ShopRepository shopRepository;

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

    @GetMapping("/shop/{id}")
    public String ShowShop(@ModelAttribute("userDto") UserDto userDto, Model model, @PathVariable Integer id) {
        //--------------------Bộ Lọc ------------------------------//
        User user = userService.getUserbyEmail(userDto.getEmail());
        if(user == null){
            return "redirect:/login";
        }
        else{
            Shop shop = shopService.GetShopByUserId(id);
            model.addAttribute("shop",shop);

            User userNeedFind = userRepository.getUserByID(id);

            List<UserPostMotorbike> userPostMotorbikes= userPostMotorbikeRepository.findUserPostMotorbikeByUser(userNeedFind);
            List<UserPostMotorbike> postNew = new ArrayList<>();
            List<UserPostMotorbike> postOld = new ArrayList<>();
            for (UserPostMotorbike userPostMotorbike: userPostMotorbikes) {
                if (userPostMotorbike.getPost().isState()){
                    postNew.add(userPostMotorbike);
                }
                else {
                    postOld.add(userPostMotorbike);
                }
            }
            model.addAttribute("postnew",postNew);
            model.addAttribute("postold",postOld);
            model.addAttribute("countpostnew",postNew.size());
            model.addAttribute("countpostold",postOld.size());
            return "/shop";
        }
    }
}
