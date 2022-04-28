package eu.ensup.demospringsecurity.controller;

import eu.ensup.demospringsecurity.domain.User;
import eu.ensup.demospringsecurity.service.AuthenticationService;
import eu.ensup.demospringsecurity.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class AuthenticationController {
    private static Logger LOGGER = LogManager.getLogger();

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationService authService;

    /*@GetMapping("/login")
    public String login(Model model, HttpSession session, @RequestParam(value = "error", defaultValue = "false") boolean loginError)
    {
        LOGGER.info("login");

        LOGGER.info("Password Admin: "+authService.getEncodedPassword("Admin"));

        model.addAttribute("user", new User());
        if (loginError) {
            return "redirect:/login?error";
        }
        return "redirect:/api/v1/student";
    }*/

    @GetMapping("/logout")
    public String logout(Model model, HttpSession session)
    {
        LOGGER.info("logout");

        if(session.getAttribute("error") != null)
            session.removeAttribute("error");

        if(session.getAttribute("user") != null)
            session.removeAttribute("user");

        return "logout";
    }
}
