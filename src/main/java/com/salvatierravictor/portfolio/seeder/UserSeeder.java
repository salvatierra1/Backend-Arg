package com.salvatierravictor.portfolio.seeder;

import com.salvatierravictor.portfolio.auth.entity.UserEntity;
import com.salvatierravictor.portfolio.model.About;
import com.salvatierravictor.portfolio.model.Profile;
import com.salvatierravictor.portfolio.model.RoleEntity;
import com.salvatierravictor.portfolio.repository.AboutRepository;
import com.salvatierravictor.portfolio.repository.ProfileRepository;
import com.salvatierravictor.portfolio.repository.RoleRepository;
import com.salvatierravictor.portfolio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;

@Component
public class UserSeeder implements CommandLineRunner {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public void run(String... args) throws Exception {
        loadUser();
        loadProfile();

    }

    private void loadUser() {
        if(userRepository.count() == 0){
            loadUserEntity();
        }
    }

    private void loadProfile() {
        if(profileRepository.count() == 0){
           loadUserProfile();
        }
    }

    private void loadUserEntity() {

        Collection<RoleEntity> admins = new ArrayList();
        if (roleRepository.count() == 0) {
            RoleEntity role = new RoleEntity(
                    "ROLE_ADMIN",
                    "Has the privileges from both roles");
            roleRepository.save(role);
            admins.add(role);
        }

        createUser("admin@mail.com","123456", admins);

    }

    private void createUser(String username, String password,  Collection<RoleEntity> roles) {

        UserEntity user = new UserEntity(
                username,
                passwordEncoder.encode(password),
                roles

        );
        userRepository.save(user);
    }

    private void loadUserProfile() {
        createProfile("Salvatierra Victor","Developer Java", "Ushuaia", "https://acortar.link/RCOXiu");

    }

    private void createProfile(String name, String title, String location, String imageUrl) {

        Profile profile = new Profile(
                name,
                title,
                location,
                imageUrl

        );
        profileRepository.save(profile);
    }


}
