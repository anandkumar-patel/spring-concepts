package anand.junitonly;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import anand.entity.User;
import anand.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserService userService;

    @Test
    public void testCreateUser() {
    	User user = new User("anand patel", "anand@gmail.com", 25);
        ResponseEntity<User> responseEntity = restTemplate.postForEntity("/api/users", user, User.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        User found = userService.findByEmail(user.getEmail());
        assertThat(found).isNotNull();
        assertThat(found.getName()).isEqualTo(user.getName());
    }
}
