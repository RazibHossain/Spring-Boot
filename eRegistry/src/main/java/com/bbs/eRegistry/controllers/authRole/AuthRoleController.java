package com.bbs.eRegistry.controllers.authRole;

import com.bbs.eRegistry.entities.authRole.AuthRole;
import com.bbs.eRegistry.services.authRole.AuthRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/roles")
public class AuthRoleController {

    @Autowired
    private AuthRoleService roleService;

    @GetMapping
    public String listRoles(Model model) {
        model.addAttribute("roles", roleService.findAll());
        return "role-list";
    }

    @GetMapping("/new")
    public String showRoleForm(Model model) {
        model.addAttribute("role", new AuthRole());
        return "role-form";
    }

    @PostMapping("/save")
    public String saveRole(@Valid @ModelAttribute AuthRole role, BindingResult result) {
        if (result.hasErrors()) {
            return "role-form";
        }

        if (roleService.roleExists(role.getName())) {
            result.rejectValue("name", "error.role", "Role already exists");
            return "role-form";
        }

        roleService.save(role);
        return "redirect:/roles";
    }

    @GetMapping("/edit/{id}")
    public String editRole(@PathVariable Long id, Model model) {
        Optional<AuthRole> role = roleService.findById(id);
        if (role.isPresent()) {
            model.addAttribute("role", role.get());
            return "role-form";
        }
        return "redirect:/roles";
    }

    @GetMapping("/delete/{id}")
    public String deleteRole(@PathVariable Long id) {
        roleService.deleteById(id);
        return "redirect:/roles";
    }
}
