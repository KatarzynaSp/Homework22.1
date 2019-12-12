package org.javastart.homework221.controller;

import org.javastart.homework221.model.User;
import org.javastart.homework221.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    @ResponseBody
    public String getUsers() {
        List<User> users = userRepository.getAll();
        return users.stream()
                .map(user -> user.getFirstName())
                .collect(Collectors.joining(", "));
    }

    @GetMapping("/add")
    public String addUser(@RequestParam("imie") String firstName, @RequestParam("nazwisko") String lastName, @RequestParam("wiek") int age) {
        if (firstName.isEmpty()) {
            return "redirect:/err.html";
        }
        User user = new User(firstName, lastName, age);
        userRepository.add(user);
        return "redirect:/success.html";
    }

    @GetMapping("/search")
    String search() {
        return "redirect:/search.html";
    }

    @GetMapping("/searched")
    @ResponseBody
    public List<User> searchUser(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam(value = "age", defaultValue = "0") int age) {
        List<User> users = userRepository.getAll();
        Stream<User> stream = users.stream();
        if (!firstName.isEmpty()) {
            stream = stream.filter(user -> user.getFirstName().equals(firstName));
        } else if (!lastName.isEmpty()) {
            stream = stream.filter(user -> user.getLastName().equals(lastName));
        } else {
            stream = stream.filter(user -> user.getAge() == age);
        }
        return stream.collect(Collectors.toList());
    }

    @GetMapping("/delete")
    String delete() {
        return "redirect:/delete.html";
    }

    @GetMapping("/deleted")
    @ResponseBody
    public String deleteUser(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam(value = "age", defaultValue = "0") int age) {
        List<User> usersToDelete = searchUser(firstName, lastName, age);
        userRepository.delete(usersToDelete);
        return "Usunięto użytkownika";
    }
}