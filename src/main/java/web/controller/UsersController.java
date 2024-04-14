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

    //ПРОСМОТР
    @GetMapping(value = "/posts")
    //@GetMapping
    public String getUsers(ModelMap model) {
        model.addAttribute("users", userService.index());
        return "users";
    }

    //@GetMapping()
    @GetMapping("/{id}")
    //public String show(@RequestParam(name = "id", required = false) Long id, ModelMap model) {
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "show";
    }

    //СОЗАДНИЕ НОВОГО USER'а
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

    //РЕДАКТИРОВАНИЕ USER'a

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.show(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.updateUser(id, user);
        return "redirect:/posts";
    }

    //УДАЛЕНИЕ USER'a
	@DeleteMapping("/users/{id}")
	public String delete(@PathVariable("id") long id) {
		userService.delUser(id);
		return "redirect:/posts";
	}

}