package web.controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import service.UserService;
import service.UserServiceImp;

@Controller
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/posts")
    public String findAll(ModelMap model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("/new")
    public String save(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/posts";
    }

    @GetMapping("/edit")
    public String getUser(Model model, @RequestParam long id) {
        model.addAttribute("user", userService.findOne(id));
        return "edit";
    }

    @PostMapping("/posts")
    public String update(@ModelAttribute("user") User user, @RequestParam long id) {
        userService.update(id, user);
        return "redirect:/posts";
    }

    @PostMapping("/users/delete")
    public String delete(@RequestParam long id) {
        userService.delete(id);
        return "redirect:/posts";
    }
}