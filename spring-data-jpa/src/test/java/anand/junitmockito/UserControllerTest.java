package anand.junitmockito;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import anand.controller.UserController;
import anand.entity.User;
import anand.service.UserService;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
	public void testGetUserById() throws Exception {
		// Prepare test data
    	User user = new User("anand patel", "anand@gmail.com", 25);

		// Mock the service method
		when(userService.getUserById(1L)).thenReturn(user);

		// Perform the request and assert the response
		mockMvc.perform(get("/api/users/id/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("anand patel"));
	}
}
