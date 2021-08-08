package org.example.user_crud.controller;


import org.example.user_crud.dao.UserDAO;
import org.example.user_crud.model.User;
import org.example.user_crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

    @Controller
    @RequestMapping("/users")
    public class UserController {
        private final UserService userService;
        private final UserDAO userDao;

        @Autowired
        public UserController(UserService userService, @Qualifier("userDAOImpl") UserDAO userDao) {
            this.userService = userService;
            this.userDao = userDao;
        }
        @GetMapping()
        public String listForAdmin(Model model, Authentication authentication) {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = userDao.findByUserName(userDetails.getUsername());
            model.addAttribute("user", user);
            model.addAttribute("authentication", authentication);
            return "users";
        }



    }
