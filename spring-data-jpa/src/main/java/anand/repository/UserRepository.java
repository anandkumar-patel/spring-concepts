package anand.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import anand.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findByName(String name);

	User findByEmail(String email);

	List<User> findByNameAndEmail(String name, String email);

	List<User> findByNameOrEmail(String name, String email);

	List<User> findByAgeGreaterThan(int age);

	List<User> findByAgeBetween(int startAge, int endAge);

	List<User> findByNameLike(String namePattern);

	List<User> findByIdIn(List<Long> ids);

	List<User> findByNameOrderByEmailAsc(String name);

	List<User> findByNameOrderByEmailDesc(String name);

	User findFirstByOrderByAgeDesc();

	List<User> findTop3ByOrderByNameAsc();

	Page<User> findByName(String name, Pageable pageable);

	List<User> findByName(String name, Sort sort);

}
