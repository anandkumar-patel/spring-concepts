package anand.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import anand.entity.User;
import anand.exception.ResourceNotFoundException;
import anand.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            throw new ResourceNotFoundException("user with id "+id+" not found in our database");
        }
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
    	User createdUser = userService.createUser(user);
        return new ResponseEntity<User>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User updatedUser = userService.updateUser(id, userDetails);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    
    /* *** method added in repository ***
     * 
     */
    @GetMapping("/name/{name}")
    public List<User> findByName(@PathVariable String name) {
        return userService.findByName(name);
    }
    
    @GetMapping("/email/{email}")
    public User findByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }
    
    @GetMapping("/name-and-email/{name}/{email}")
    public List<User> findByNameAndEmail(@PathVariable String name,@PathVariable String email) {
        return userService.findByNameAndEmail(name,email);
    }
    
    @GetMapping("/name-or-email/{name}/{email}")
    public List<User> findByNameOrEmail(@PathVariable String name,@PathVariable String email) {
        return userService.findByNameOrEmail(name,email);
    }
    
    @GetMapping("/age/{age}")
    public List<User> findByAgeGreaterThan(@PathVariable int age) {
		return userService.findByAgeGreaterThan(age);
	}

    @GetMapping("/age/{startAge}/{endAge}")
	public List<User> findByAgeBetween(@PathVariable int startAge, @PathVariable int endAge) {
		return userService.findByAgeBetween(startAge, endAge);
	}

    @GetMapping("/namelike/{name}")
	public List<User> findByNameLike(String name) {
		return userService.findByNameLike(name);
	}

    @GetMapping("/ids/{ids}")
	public List<User> findByIdIn(@PathVariable List<Long> ids) {
		return userService.findByIdIn(ids);
	}

    @GetMapping("/name/{name}/order-by-email-asc")
	public List<User> findByNameOrderByEmailAsc(@PathVariable String name) {
		return userService.findByNameOrderByEmailAsc(name);
	}

    @GetMapping("/name/{name}/order-by-email-desc")
	public List<User> findByNameOrderByEmailDesc(@PathVariable String name) {
		return userService.findByNameOrderByEmailDesc(name);
	}

    @GetMapping("/oldest")
	public User findFirstByOrderByAgeDesc() {
		return userService.findFirstByOrderByAgeDesc();
	}

    @GetMapping("/top3/orderbyname/asc")
	public List<User> findTop3ByOrderByNameAsc() {
		return userService.findTop3ByOrderByNameAsc();
	}

	// GET /users/search?name=anand&page=0&size=10
	@GetMapping("/search")
	public Page<User> findByName(String name, Pageable pageable) {
		return userService.findByName(name, pageable);
	}

	// GET /users/search/sorted?name=anand&sort=age,desc
	@GetMapping("/search/sorted")
	public List<User> findByName(String name, Sort sort) {
		return userService.findByName(name, sort);
	}
}