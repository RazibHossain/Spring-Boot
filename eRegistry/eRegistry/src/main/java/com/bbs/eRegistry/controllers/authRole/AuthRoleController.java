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

    @GetMapping("/list")
    public String listRoles(Model model) {
        model.addAttribute("roles", roleService.findAll());
        return "role-list";
    }

    @GetMapping("/new")
    public String showRoleForm(Model model) {
        model.addAttribute("role", new AuthRole());
        return "role-form";
    }

//    @PostMapping("/save")
//    public String saveRole(@Valid @ModelAttribute AuthRole role, BindingResult result) {
//        if (result.hasErrors()) {
//            return "role-form";
//        }
//
//        if (roleService.roleExists(role.getName())) {
//            result.rejectValue("name", "error.role", "Role already exists");
//            return "role-form";
//        }
//
//        roleService.save(role);
//        return "redirect:/roles/list";
//    }

    @PostMapping("/save")
    public String saveRole(@Valid @ModelAttribute("role") AuthRole role, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "role-form";
        }

        // Check if role name already exists (for new roles)
        if (role.getId() == null && roleService.roleExists(role.getName())) {
            result.rejectValue("name", "error.role", "Role already exists");
            return "role-form";
        }

        // For existing roles, check if name changed and if it's unique
        if (role.getId() != null) {
            Optional<AuthRole> existingRole = roleService.findById(role.getId());
            if (existingRole.isPresent()) {
                AuthRole currentRole = existingRole.get();

                // Check if role name changed and if new name exists
                if (!currentRole.getName().equals(role.getName()) &&
                        roleService.roleExists(role.getName())) {
                    result.rejectValue("name", "error.role", "Role already exists");
                    return "role-form";
                }
            }
        }

        roleService.save(role);
        return "redirect:/roles/list";
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
        return "redirect:/roles/list";
    }
}
