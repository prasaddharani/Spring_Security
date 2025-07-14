package com.example.security.repository;

import com.example.security.model.AppUser;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class InMemoryUserStore {

    private final List<AppUser> users = new CopyOnWriteArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public void save(AppUser user) {
        user.setId(idGenerator.incrementAndGet());
        users.add(user);
    }

    public Optional<AppUser> findByUsername(String username) {
        return users.stream()
                    .filter(u -> u.getUsername().equalsIgnoreCase(username))
                    .findFirst();
    }

    public List<AppUser> findAll() {
        return users;
    }
}
