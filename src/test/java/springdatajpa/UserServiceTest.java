package springdatajpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
import springdatajpa.model.User;
import springdatajpa.repository.UserRepository;
import springdatajpa.service.UserService;

@RunWith(SpringRunner.class)
public class UserServiceTest {

	@TestConfiguration
	static class UserServiceTestConfiguration {
		@Bean
		public UserService userService() {
			return new UserService();
		}
	}

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userDao;

	@Test
	public void testFindUserById() {
		User user = new User();
		user.setId(1L);

		Mockito.when(userDao.findOne(1L)).thenReturn(user);

		user = userService.getUserById(1L);
		assertNotNull(user);
		assertEquals(Long.valueOf(1L), user.getId());
	}

}
