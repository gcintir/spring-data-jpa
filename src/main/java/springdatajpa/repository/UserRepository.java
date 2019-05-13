package springdatajpa.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springdatajpa.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	long countBySalaryGreaterThanAndAge(int salary, int age);

	List<User> findByNameEndingWith(String nameEndsWith);

	List<User> findByNameLike(String nameLike);

	List<User> findTop2BySalaryLessThan(int salary);

}
