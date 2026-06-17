package com.onlinebookstore.service;

import com.onlinebookstore.dto.request.LoginRequest;
import com.onlinebookstore.dto.request.RegisterRequest;
import com.onlinebookstore.entity.User;
import com.onlinebookstore.enums.UserRole;
import com.onlinebookstore.exception.BusinessException;
import com.onlinebookstore.exception.ResourceNotFoundException;
import com.onlinebookstore.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HexFormat;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("UserService Unit Tests")
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user;
    private String hashedPassword;

    @BeforeEach
    void setUp() throws Exception {
        hashedPassword = HexFormat.of().formatHex(
                MessageDigest.getInstance("SHA-256")
                        .digest("123456".getBytes(StandardCharsets.UTF_8)));

        user = new User();
        user.setId(1L);
        user.setUsername("testuser");
        user.setPassword(hashedPassword);
        user.setEmail("test@example.com");
        user.setRole(UserRole.CUSTOMER);
    }

    @Test
    @DisplayName("Register new user success")
    void testRegister_Success() {
        RegisterRequest request = new RegisterRequest();
        request.setUsername("newuser");
        request.setPassword("password123");
        request.setEmail("newuser@example.com");

        when(userRepository.existsByUsername("newuser")).thenReturn(false);
        when(userRepository.existsByEmail("newuser@example.com")).thenReturn(false);
        when(userRepository.save(any(User.class))).thenAnswer(inv -> {
            User u = inv.getArgument(0);
            u.setId(2L);
            return u;
        });

        User result = userService.register(request);
        assertNotNull(result);
        assertEquals("newuser", result.getUsername());
        assertNotNull(result.getPassword()); // password preserved, @JsonIgnore handles serialization
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    @DisplayName("Register fails when username exists")
    void testRegister_DuplicateUsername() {
        RegisterRequest request = new RegisterRequest();
        request.setUsername("testuser");
        request.setPassword("password123");
        request.setEmail("new@example.com");

        when(userRepository.existsByUsername("testuser")).thenReturn(true);
        assertThrows(BusinessException.class, () -> userService.register(request));
    }

    @Test
    @DisplayName("Login success with correct credentials")
    void testLogin_Success() {
        LoginRequest request = new LoginRequest();
        request.setUsername("testuser");
        request.setPassword("123456");

        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(user));
        User result = userService.login(request);
        assertNotNull(result);
        assertNotNull(result.getPassword()); // password preserved, @JsonIgnore handles serialization
    }

    @Test
    @DisplayName("Login fails with wrong password")
    void testLogin_WrongPassword() {
        LoginRequest request = new LoginRequest();
        request.setUsername("testuser");
        request.setPassword("wrongpassword");

        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(user));
        assertThrows(BusinessException.class, () -> userService.login(request));
    }

    @Test
    @DisplayName("Get user by ID success")
    void testGetUserById_Success() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        User result = userService.getUserById(1L);
        assertNotNull(result);
        assertEquals("testuser", result.getUsername());
    }

    @Test
    @DisplayName("Get user by ID not found")
    void testGetUserById_NotFound() {
        when(userRepository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> userService.getUserById(99L));
    }

    @Test
    @DisplayName("Delete user success")
    void testDeleteUser_Success() {
        when(userRepository.existsById(1L)).thenReturn(true);
        doNothing().when(userRepository).deleteById(1L);
        assertDoesNotThrow(() -> userService.deleteUser(1L));
        verify(userRepository, times(1)).deleteById(1L);
    }
}