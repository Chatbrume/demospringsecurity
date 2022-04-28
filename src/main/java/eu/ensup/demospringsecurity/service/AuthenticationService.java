package eu.ensup.demospringsecurity.service;

import eu.ensup.demospringsecurity.domain.Roles;
import eu.ensup.demospringsecurity.domain.User;
import eu.ensup.demospringsecurity.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private static Logger LOGGER = LogManager.getLogger();

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User signup(User user) {
        LOGGER.info("password: " + user.getPassword() + ", encode: " + passwordEncoder.encode(user.getPassword()));
        user.setRole(Roles.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User result = userRepository.save(user);
        return result;
    }

    public User signin(User user) {
        LOGGER.info("password: " + user.getPassword() + ", encode: " + passwordEncoder.encode(user.getPassword()));
        User result = userRepository.findByUsername(user.getUsername()).get();
        result.setPassword(passwordEncoder.encode(user.getPassword()));
        return result;
    }

    public String getEncodedPassword(String password) {
        LOGGER.info("password encode: "+passwordEncoder.encode(password));
        return passwordEncoder.encode(password);
    }
}
