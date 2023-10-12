package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.ListPeople;
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

    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user");
        return "addUser";
    }

    @PostMapping()
    public String addUser(@RequestParam("name") String name, @RequestParam("age") int age,
                          @RequestParam("email") String email, Model model) {
        User user = new User();
        user.setAge(age);
        user.setName(name);
        user.setEmail(email);
        model.addAttribute(user);

        userService.addUser(user);

        User.printUsers(ListPeople.USERS);

        return "redirect:/users";
    }

}
