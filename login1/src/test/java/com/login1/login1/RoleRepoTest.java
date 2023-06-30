package com.login1.login1;

import com.login1.login1.entity.Role;
import com.login1.login1.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class RoleRepoTest {
    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void testCreateRoles(){
        Role user = new Role("user");
        Role admin = new Role("admin");

        roleRepository.saveAll(List.of(user,admin));

        List<Role> roles = roleRepository.findAll();

        assertThat (roles.size()).isEqualTo(2);
    }
}
