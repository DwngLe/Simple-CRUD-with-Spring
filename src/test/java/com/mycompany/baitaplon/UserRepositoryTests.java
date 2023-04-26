package com.mycompany.baitaplon;

import com.mycompany.baitaplon.User.User;
import com.mycompany.baitaplon.User.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {
    @Autowired private UserRepository repo;

    @Test
    public void testAddNew(){
        User user = new User();
//        user.setEmail("testing2@email.com");
//        user.setPassword("123");
        user.setFirstName("Nguyen Van");
//        user.setLastName("A");
        user.setEnable(true);

        User savedUser = repo.save(user);
        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll(){
        Iterable<User> users = repo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for (User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void  testUpdate(){
        Integer userID = 1;
        Optional<User> optionalUser = repo.findById(userID);
        User user = optionalUser.get();
//        user.setPassword("456");
        repo.save(user);

        User updateUser = repo.findById(userID).get();
//        Assertions.assertThat(updateUser.getPassword()).isEqualTo("456");
    }

    @Test
    public  void testGet(){
        Integer userID = 1;
        Optional<User> optionalUser = repo.findById(userID);
//        User user = optionalUser.get();

        Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());
    }

    @Test
    public void testDelete(){
        Integer userID = 2;
        repo.deleteById(userID);
        Optional<User> optionalUser = repo.findById(userID);
        Assertions.assertThat(optionalUser).isNotPresent();
    }
}
