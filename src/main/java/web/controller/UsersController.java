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
    //@GetMapping
    public String getUsers(ModelMap model) {
        model.addAttribute("users", userService.index());
        return "users";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/posts";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam long id) {
        model.addAttribute("user", userService.show(id));
        return "edit";
    }

    @PostMapping("/posts")
    public String update(@ModelAttribute("user") User user, @RequestParam long id) {
        userService.updateUser(id, user);
        return "redirect:/posts";
    }

    @PostMapping("/users/delete")
    public String delete(@RequestParam long id) {
        userService.delUser(id);
        return "redirect:/posts";
    }
}