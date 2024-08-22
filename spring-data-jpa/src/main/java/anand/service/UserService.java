package anand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import anand.entity.User;
import anand.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(Long id, User userDetails) {
		User user = userRepository.findById(id).orElse(null);
		if (user != null) {
			user.setName(userDetails.getName());
			user.setEmail(userDetails.getEmail());
			user.setAge(userDetails.getAge());
			return userRepository.save(user);
		}
		return null;
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	// repository added methods
	public List<User> findByName(String name) {
		return userRepository.findByName(name);
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public List<User> findByNameAndEmail(String name, String email) {
		return userRepository.findByNameAndEmail(name, email);
	}

	public List<User> findByNameOrEmail(String name, String email) {
		return userRepository.findByNameOrEmail(name, email);
	}

	public List<User> findByAgeGreaterThan(int age) {
		return userRepository.findByAgeGreaterThan(age);
	}

	public List<User> findByAgeBetween(int startAge, int endAge) {
		return userRepository.findByAgeBetween(startAge, endAge);
	}

	public List<User> findByNameLike(String namePattern) {
		return userRepository.findByNameLike(namePattern);
	}

	public List<User> findByIdIn(List<Long> ids) {
		return userRepository.findByIdIn(ids);
	}

	public List<User> findByNameOrderByEmailAsc(String name) {
		return userRepository.findByNameOrderByEmailAsc(name);
	}

	public List<User> findByNameOrderByEmailDesc(String name) {
		return userRepository.findByNameOrderByEmailDesc(name);
	}

	public User findFirstByOrderByAgeDesc() {
		return userRepository.findFirstByOrderByAgeDesc();
	}

	public List<User> findTop3ByOrderByNameAsc() {
		return userRepository.findTop3ByOrderByNameAsc();
	}

	public Page<User> findByName(String name, Pageable pageable) {
		return userRepository.findByName(name, pageable);
	}

	public List<User> findByName(String name, Sort sort) {
		return userRepository.findByName(name, sort);
	}
}
