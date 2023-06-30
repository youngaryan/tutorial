package com.login1.login1;

import com.login1.login1.entity.Role;
import com.login1.login1.entity.UserEntity;
import com.login1.login1.repository.RoleRepository;
import com.login1.login1.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepoTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void testCreateUser(){
        UserEntity user = new UserEntity();
        user.setEmail("araad@gmail.com");
        user.setPassword("123");

        UserEntity savedUser = userRepository.save(user);

        UserEntity check = userRepository.findByEmail("araad@gmail.com");

        assertThat(savedUser.getPassword()).isEqualTo(check.getPassword());

    }

    @Test
    public void testCreateNewRoleForeNewUser(){
        UserEntity user = new UserEntity();
        user.setEmail("arad7@gmail.com");
        user.setPassword("123");

        Role role = roleRepository.findByRole("user");
        user.addRole(role);

        UserEntity saved = userRepository.save(user);

        assertThat(saved.getRoles().size()).isEqualTo(1);

    }

    @Test
    public void testAddRoleToExistingUser(){
        UserEntity existingUser = userRepository.findByEmail("araad@gmail.com");

        Role userRole = roleRepository.findByRole("user");
        existingUser.addRole(userRole);

        Role adminRole = roleRepository.findByRole("admin");
        existingUser.addRole(adminRole);

        UserEntity saved = userRepository.save(existingUser);

        assertThat(saved.getRoles().size()).isEqualTo(2);
    }
}
