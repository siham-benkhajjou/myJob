package ma.ensi.myJob.Service;

import ma.ensi.myJob.Model.User;
import ma.ensi.myJob.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


    @Service
    public class UserService {
        @Autowired
        private final UserRepo userRepository;

        @Autowired
        private final PasswordEncoder passwordEncoder;

        public UserService(UserRepo userRepository, PasswordEncoder passwordEncoder) {
            this.userRepository = userRepository;
            this.passwordEncoder = passwordEncoder;
        }

        public User registerUser(String username, String email, String password, String address, long phone) {
            User user = new User();
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode(password));
            user.setAddress(address);
            user.setPhone(phone);
            return userRepository.save(user);
        }

        public Optional<User> findByEmail(String email) {
            return userRepository.findByEmail(email);
        }

    }

