package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private User user;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String printUsers(ModelMap model) {
        model.addAttribute("users", userService.showUsers());
        return "users";
    }




    @GetMapping({"/{id}"})
    public String printOnlyUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.findUser(id));
        return "findUser";
    }

    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user");
        return "addUser";
    }

    @PostMapping("/new")
    public String addUser(@RequestParam("name") String name, @RequestParam("age") int age,
                          @RequestParam("email") String email, Model model) {
        User user1 = new User();
        user1.setAge(age);
        user1.setName(name);
        user1.setEmail(email);
        model.addAttribute(user1);

        userService.addUser(user1);


        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String deleteUser(Model model) {
        model.addAttribute("user");
        return "deleteUser";
    }

    @PostMapping("/delete")
    public String deletedUser(@RequestParam("id") String id, Model model) {
        userService.deleteUser(Integer.parseInt(id));
        return "redirect:/users";
    }

    @GetMapping("/find")
    public String findUser(Model model) {
        model.addAttribute("user");
        return "findUser";
    }

    @PostMapping ("/find")
    public String foundUser(@RequestParam("id") String id, Model model) {
        user = userService.findUser(Integer.parseInt(id));
        if (user == null) return "redirect:/users";

        return"redirect:/users/found";
    }

    @GetMapping("/found")
    public String showUser(Model model) {
        model.addAttribute("user", user);
        return "foundUser";
    }

    @PostMapping("/found")
    public String updateUser(Model model, @RequestParam("name") String name, @RequestParam("age") int age,
                             @RequestParam("email") String email) {

        user.setAge(age);
        user.setName(name);
        user.setEmail(email);
        model.addAttribute(user);
        System.out.println(user);

        userService.changeUser(user);

        return "redirect:/users";
    }



}
