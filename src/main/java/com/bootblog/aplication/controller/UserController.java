package com.bootblog.aplication.controller;

import com.bootblog.aplication.entity.User;
import com.bootblog.aplication.repository.RoleRepository;
import com.bootblog.aplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/userForm")

        public String userForm (Model model){
            model.addAttribute("userForm", new User());
            model.addAttribute("userList", userService.getAllUsers());
            model.addAttribute("roles", roleRepository.findAll());
            model.addAttribute("listTab", "active");
            return "user-form/user-view";
        }

//    @GetMapping("/userForm")
//    public String userForm() {
//        return "user-form/user-view";
//    }
    }
