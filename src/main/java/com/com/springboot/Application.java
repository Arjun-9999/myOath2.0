package com.com.springboot;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.com.springboot.entity.User;
import com.com.springboot.repository.UserRepository;

@SpringBootApplication
public class Application {
  @Autowired
	UserRepository repository;
	@PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User(101, "javatechie", "password", "javatechie@gmail.com"),
                new User(102, "user1", "pwd1", "user1@gmail.com"),
                new User(103, "user2", "pwd2", "user2@gmail.com"),
                new User(104, "user3", "pwd3", "user3@gmail.com")
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }

	public static void main(String[] args) {
		System.out.println("    ********************************88    ");
		SpringApplication.run(Application.class, args);
	}

}
