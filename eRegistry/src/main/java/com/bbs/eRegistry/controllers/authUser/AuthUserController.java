package com.bbs.eRegistry.controllers.authUser;

import com.bbs.eRegistry.entities.authUser.AuthUser;
import com.bbs.eRegistry.services.authRole.AuthRoleService;
import com.bbs.eRegistry.services.authUser.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class AuthUserController {

    @Autowired
    private AuthUserService userService;

    @Autowired
    private AuthRoleService roleService;

    @GetMapping("/list")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "user-list";
    }

    @GetMapping("/new")
    public String showUserForm(Model model) {
        model.addAttribute("user", new AuthUser());
        model.addAttribute("allRoles", roleService.findAll());
        return "user-form";
    }

    @PostMapping("/save")
    public String saveUser(@Valid @ModelAttribute AuthUser user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("allRoles", roleService.findAll());
            return "user-form";
        }

        if (userService.usernameExists(user.getUsername())) {
            result.rejectValue("username", "error.user", "Username already exists");
            model.addAttribute("allRoles", roleService.findAll());
            return "user-form";
        }

        if (userService.emailExists(user.getEmail())) {
            result.rejectValue("email", "error.user", "Email already exists");
            model.addAttribute("allRoles", roleService.findAll());
            return "user-form";
        }

        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        Optional<AuthUser> user = userService.findById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            model.addAttribute("allRoles", roleService.findAll());
            return "user-form";
        }
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/reset-password/{id}")
    public String showResetPasswordForm(@PathVariable Long id, Model model) {
        Optional<AuthUser> user = userService.findById(id);
        if (user.isPresent()) {
            model.addAttribute("userId", id);
            return "password-reset";
        }
        return "redirect:/users";
    }

    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam Long userId, @RequestParam String newPassword) {
        userService.resetPassword(userId, newPassword);
        return "redirect:/users";
    }
}
