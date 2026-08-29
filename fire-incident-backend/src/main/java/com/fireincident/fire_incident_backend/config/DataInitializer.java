package com.fireincident.fire_incident_backend.config;

import com.fireincident.fire_incident_backend.entity.User;
import com.fireincident.fire_incident_backend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        String adminEmail = "soumya@456.com";
        if (!userRepository.existsByEmail(adminEmail)) {
            User admin = new User();
            admin.setName("Soumya");
            admin.setEmail(adminEmail);
            admin.setPassword(passwordEncoder.encode("soumya13"));
            admin.setRole(User.Role.ADMIN);
            userRepository.save(admin);
            System.out.println("Default ADMIN user initialized: " + adminEmail);
        }
    }
}
