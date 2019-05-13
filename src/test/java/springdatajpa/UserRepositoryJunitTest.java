package springdatajpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import springdatajpa.model.User;
import springdatajpa.repository.UserRepository;
import static org.junit.Assert.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ContextConfiguration(classes = { Initializer.class })
@RunWith(SpringRunner.class)
@Transactional
public class UserRepositoryJunitTest {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private UserRepository userDao;

	@Test
	public void notNull() {
		assertNotNull(jdbcTemplate);
		assertNotNull(em);
		assertNotNull(userDao);
	}

	@Test
	public void saveUser() {
		User user = new User();
		user.setName("Jenny");
		user.setAge(20);
		user.setSalary(1000);
		user = userDao.save(user);
		assertNotNull(user.getId());
	}

}
