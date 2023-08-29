package com.kt.gardenapp.security.config;

import com.kt.gardenapp.model.Role;
import com.kt.gardenapp.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class RoleLoader implements CommandLineRunner {

    RoleRepository roleRepository;

    public RoleLoader(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Role userRole = new Role();
        userRole.setName("USER");
        roleRepository.save(userRole);
    }
}
