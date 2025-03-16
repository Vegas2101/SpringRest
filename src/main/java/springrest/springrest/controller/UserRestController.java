package springrest.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springrest.springrest.entity.User;
import springrest.springrest.service.UserService;

import java.security.Principal;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<User> getUserInfo(Principal principal) {
        String email = principal.getName();
        User user = userService.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + email);
        }

        return ResponseEntity.ok(user);
    }
}
