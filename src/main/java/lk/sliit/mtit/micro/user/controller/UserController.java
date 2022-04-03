package lk.sliit.mtit.micro.user.controller;

import lk.sliit.mtit.micro.user.entity.User;
import lk.sliit.mtit.micro.user.service.UserService;
import lk.sliit.mtit.micro.user.valueObjects.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

/*    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }*/
    @GetMapping("/{id}")
    public ResponseTemplateVO  getUserWithDepartment(@PathVariable("id") Long userId){
       log.info("ResponseTemplateVO");
        return userService.gerUserWithDepartment(userId);
    }
}
