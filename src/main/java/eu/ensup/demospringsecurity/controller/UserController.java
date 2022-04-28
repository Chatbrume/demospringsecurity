package eu.ensup.demospringsecurity.controller;


import eu.ensup.demospringsecurity.domain.User;
import eu.ensup.demospringsecurity.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController
{
    private static Logger LOGGER = LogManager.getLogger();

    @Autowired
    private UserService userService;

    @GetMapping("/my")
    public String user(Model model, HttpSession session)
    {
        LOGGER.info("users");

        User currentUser = (User) session.getAttribute("user");

        List<User> users = new ArrayList<User>();
        for(User user : userService.getAll())
            if(user.getId() != currentUser.getId())
                users.add(user);

        model.addAttribute("usertype",  "utilisateur");
        model.addAttribute("userpath",  "user");
        model.addAttribute("users",  users);
        return "users";
    }
}