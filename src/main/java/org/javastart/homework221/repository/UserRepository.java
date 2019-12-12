package org.javastart.homework221.repository;

import org.javastart.homework221.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
        users.add(new User("Kasia", "abc", 22));
        users.add(new User("Asia", "cde", 12));
        users.add(new User("Basia", "efg", 32));
        users.add(new User("Maciej", "hij", 25));
        users.add(new User("Rafał", "klm", 28));
    }

    public List<User> getAll() {
        return users;
    }

    public void add(User user) {
        users.add(user);
    }

    public void delete(List<User> usersToDelete) {
        users.removeAll(usersToDelete);
    }
}