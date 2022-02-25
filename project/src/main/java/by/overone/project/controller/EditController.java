package by.overone.project.controller;

import by.overone.project.Service.UserService;
import by.overone.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
}
