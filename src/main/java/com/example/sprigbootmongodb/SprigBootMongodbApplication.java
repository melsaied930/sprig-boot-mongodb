package com.example.sprigbootmongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SpringBootApplication
public class SprigBootMongodbApplication {
    @Autowired
    UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(SprigBootMongodbApplication.class, args);
    }

    @GetMapping("/")
    public String serverUp() {
        return "serverUp";
    }
    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping("/user")
    public List<User> read() {
        return userService.read();
    }

    @GetMapping("/user/{id}")
    public User readById(@PathVariable String id) {
        return userService.readById(id);
    }

    @PutMapping("/user")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestBody User user) {
        userService.delete(user);
    }
}