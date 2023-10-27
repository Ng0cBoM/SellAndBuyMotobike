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
    @GetMapping("/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username){
        UserDto user = userService.getUserByUsername(username);
        return  ResponseEntity.ok(user);
    }
    @PostMapping("")
    public  ResponseEntity<?> createUser(){
        return null;
    }
}
