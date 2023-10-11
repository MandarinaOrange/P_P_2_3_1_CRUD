package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public String printUsers(ModelMap model) {
        model.addAttribute("users", userService.showUsers());
        System.out.println("USERS");
        return "users";
    }

    @GetMapping({"/{id}"})
    public String printOnlyUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.findUser(id));
        return "user";
    }

}
