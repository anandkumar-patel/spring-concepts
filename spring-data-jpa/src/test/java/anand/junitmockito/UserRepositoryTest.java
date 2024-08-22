package anand.junitmockito;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import anand.entity.User;
import anand.repository.UserRepository;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUsername() {
    	User user = new User("anand patel", "anand@gmail.com", 25);
        userRepository.save(user);

        User foundUser = userRepository.findByEmail("anand@gmail.com");

        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getName()).isEqualTo("anand patel");
    }
}
