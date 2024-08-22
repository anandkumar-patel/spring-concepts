package anand.junitmockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import anand.entity.User;
import anand.repository.UserRepository;
import anand.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@Mock
    private UserRepository userRepository; // Mocking the repository

	@InjectMocks
	UserService userService;

	@Test
	public void testCreateUser() {
		User user = new User("akash patel", "akashpatel@gmail.com", 25);

		// Mocking the behavior of the repository
		Mockito.when(userRepository.save(user)).thenReturn(user);

		User createdUser = userService.createUser(user);

		// Verifying the interaction with the mock
		Mockito.verify(userRepository).save(user);

		// Asserting the expected behavior
		assertNotNull(createdUser);
		assertEquals("akash patel", createdUser.getName());
		assertEquals("akashpatel@gmail.com", createdUser.getEmail());
	}
}
