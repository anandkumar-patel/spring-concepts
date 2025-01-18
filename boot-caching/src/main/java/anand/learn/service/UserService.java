package anand.learn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import anand.learn.entity.User;
import anand.learn.repository.UserRepository;


@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
    @Cacheable(value = "users", key = "#userId")
    public User getUserById(Long userId) {
        // Simulate a time-consuming operation
        return userRepository.findById(userId).orElse(null);
    }
}

