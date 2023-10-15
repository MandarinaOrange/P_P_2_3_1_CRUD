package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    @Autowired
    UserService userService;

    @GetMapping("/hi")
    public String printHi() {
        return "Hi";
    }


    @GetMapping( "/hello")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "hello";
    }

    @GetMapping(value = "goodbye")
    public String printGoodbye(@RequestParam(value = "name", required = false) String name,
                               @RequestParam(value = "age", required = false) Integer age, Model model) {
        model.addAttribute("age", age);
        System.out.println(name + " " + age);
        return "goodbye";
    }


}
