package jvaicekauskas.backend.service;

import jvaicekauskas.backend.model.User;
import jvaicekauskas.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // RASTI PAGAL USERNAME
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // issaugoti nauja useri
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // gauti visus userius
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // istrinti useri pagal id
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("User with ID " + id + " not found");
        }
    }
}
