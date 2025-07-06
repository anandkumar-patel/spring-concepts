package anand.learn.controller;

import anand.learn.entity.User;
import anand.learn.service.CacheInspectionService;
import anand.learn.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService service;
    private final CacheInspectionService cacheInspectionService;

    public UserController(UserService service, CacheInspectionService cacheInspectionService) {
        this.service = service;
        this.cacheInspectionService = cacheInspectionService;
    }

    @GetMapping("/user")
    public List<User> getAllUser() {
        return service.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable  long id) {
        System.out.println("data collection started....");
        User user = service.getUserById(id);
        System.out.println("User Name collected is :"+ user.getName());
        return user;
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return  service.createUser(user);
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable long id, @RequestBody User user) {
        return  service.updateUser(id, user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable long id) {
        service.deleteUser(id);
    }

    @GetMapping("/cache-data/{name}")
    public void getCacheData(@PathVariable String name) {
        cacheInspectionService.printCacheContent(name);
    }
}
