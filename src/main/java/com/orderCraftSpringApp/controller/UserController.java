package com.orderCraftSpringApp.controller;

import com.orderCraftSpringApp.model.classes.User;
import com.orderCraftSpringApp.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    String viewUsers(Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "/users/users";
    }

    @GetMapping("/add")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "/users/user_form";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }


    @GetMapping("/update/{userID}")
    public String showUpdateUserForm(@PathVariable Long userID, Model model) {
        User user = userService.findUserById(userID);
        model.addAttribute("user", user);
        return "/users/user_form";
    }

    @PostMapping("/update/{userID}")
    public String updateUser(@ModelAttribute User user, @PathVariable Long userID) {
        userService.updateUser(userID, user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{userID}")
    public String showDeleteUserForm(@PathVariable Long userID, Model model) {
        User user = userService.findUserById(userID);
        model.addAttribute("user", user);
        return "/users/user_form";
    }

    @PostMapping("/delete/{userID}")
    public String deleteUser(@PathVariable Long userID) {
        userService.deleteUser(userID);
        return "redirect:/users";
    }

    //login
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        User user = userService.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            // Login successful, redirect to user's home page
            return "redirect:/users/home";
        } else {
            // Login failed, redirect back to login page
            return "redirect:/login";
        }
    }
}