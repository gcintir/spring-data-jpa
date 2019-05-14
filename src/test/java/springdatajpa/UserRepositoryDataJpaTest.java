package springdatajpa;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import springdatajpa.model.User;
import springdatajpa.repository.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryDataJpaTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepository userDao;
	
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
