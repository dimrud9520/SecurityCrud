package org.example.user_crud.controller;

import org.example.user_crud.model.User;
import org.example.user_crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String listUsers(Model model) {
        model.addAttribute("listUsers", userService.getAllUsers());
        return "index";

    }

    @GetMapping(value = "newUser")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "newUser";
    }

    @PostMapping
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/{id}/edit")
    public String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.get(id));
        return "/edit";
    }

    @PatchMapping("{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("{id}")
    public String findById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.get(id));
        return "edit";
    }

    @DeleteMapping(value = "{id}")
    public String removeUserById(@PathVariable("id") int id) {
        userService.removeUserById(id);
        return "redirect:/users";
    }

}
