package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import service.UserService;
import service.UserServiceImp;

@Controller
public class UsersController {
	private final UserService userServiceImp;

	@Autowired
	public UsersController(UserServiceImp userServiceImp) {
		this.userServiceImp = userServiceImp;
	}

	@GetMapping(value = "/")
	public String getUsers(ModelMap model) {
		model.addAttribute("users", userServiceImp.index());
		return "users";
	}
	
}