package eu.ensup.demospringsecurity.service;

import eu.ensup.demospringsecurity.domain.User;
import eu.ensup.demospringsecurity.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService implements UserDetailsService {
    private static Logger LOGGER = LogManager.getLogger();

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElse(null);
    }

    public boolean save(User user) {
        return userRepository.save(user) != null;
    }

    public User getOne(Long userID) {
        User user = userRepository.findById(userID).orElse(null);
        if (user != null)
            user.setPassword(null);

        return user;
    }
}