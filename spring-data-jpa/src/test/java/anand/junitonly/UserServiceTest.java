package anand.junitonly;



import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import anand.entity.User;
import anand.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testCreateUser() {
    	User user = new User("anand patel", "anand@gmail.com", 25);
        userService.createUser(user);

		User found = userService.findByEmail(user.getEmail());

        assertThat(found).isNotNull();
        assertThat(found.getName()).isEqualTo(user.getName());
    }
}
