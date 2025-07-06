package anand.learn.service;

import anand.learn.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import anand.learn.entity.User;
import anand.learn.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

    @Cacheable(value = "user-cache", key = "#id")
    public User getUserById(long id) {
        System.out.println("cached service method started....");
        User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("user not found with id "+ id));
        System.out.println("cached service method ended ....");
        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    @CachePut(value = "user-cache", key = "#id")
    public User updateUser(long id, User user) {
        User foundUser = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with id "+ id));
        foundUser.setName(user.getName());
        foundUser.setEmail(user.getEmail());
        foundUser.setAge(user.getAge());
        foundUser.setSalary(user.getSalary());
        return userRepository.save(foundUser);
    }

    @CacheEvict(value = "user-cache", key = "#id")
    public void deleteUser(long id) {
       userRepository.deleteById(id);
    }
}

