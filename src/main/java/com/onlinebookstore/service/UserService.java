package com.onlinebookstore.service;

import com.onlinebookstore.dto.request.LoginRequest;
import com.onlinebookstore.dto.request.RegisterRequest;
import com.onlinebookstore.entity.User;
import com.onlinebookstore.enums.UserRole;
import com.onlinebookstore.exception.BusinessException;
import com.onlinebookstore.exception.ResourceNotFoundException;
import com.onlinebookstore.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HexFormat;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new BusinessException("USER_ALREADY_EXISTS", "Username already exists");
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new BusinessException("USER_ALREADY_EXISTS", "Email already registered");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(hashPassword(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setRole(UserRole.CUSTOMER);
        return userRepository.save(user);
    }

    public User login(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new BusinessException("AUTH_FAILED", "Invalid username or password"));

        String hashed = hashPassword(request.getPassword());
        if (!hashed.equals(user.getPassword())) {
            throw new BusinessException("AUTH_FAILED", "Invalid username or password");
        }
        return user;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("USER_NOT_FOUND", "User not found with id: " + id));
    }

    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public User updateUser(Long id, User updates) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("USER_NOT_FOUND", "User not found with id: " + id));

        if (updates.getEmail() != null) user.setEmail(updates.getEmail());
        if (updates.getPhone() != null) user.setPhone(updates.getPhone());
        if (updates.getAddress() != null) user.setAddress(updates.getAddress());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("USER_NOT_FOUND", "User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }

    private String hashPassword(String raw) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return HexFormat.of().formatHex(md.digest(raw.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            throw new RuntimeException("Password hashing failed", e);
        }
    }
}