package by.overone.project.controller;

import by.overone.project.Service.UserService;
import by.overone.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EditController {

    private UserService userService;

    @Autowired
    public EditController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") String id){
        userService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/user-edit/{id}")
    public String editForm(@PathVariable("id") String id, Model model){
        model.addAttribute("user", userService.findById(id));
        return "user-edit";
    }

    @PostMapping("/user-edit/{id}")
    public String editForm(@ModelAttribute(name = "user") User user,
            @PathVariable String id, Model model){
        user.setId(id);
        userService.saveUser(user);
        return "redirect:/";
    }

}
