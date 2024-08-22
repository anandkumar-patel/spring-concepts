package anand.junitonly;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import anand.entity.User;
import anand.repository.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepository userRepository;

	@Test
	public void testFindByEmail() {
		User user = new User("anand patel", "anand@gmail.com", 25);
		entityManager.persist(user);
		entityManager.flush();

		User found = userRepository.findByEmail(user.getEmail());

		assertThat(found.getName()).isEqualTo(user.getName());
	}
}
