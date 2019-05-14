package springdatajpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springdatajpa.model.User;
import springdatajpa.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userDao;

	public User getUserById(Long id) {
		return userDao.findOne(id);
	}
	
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

}
