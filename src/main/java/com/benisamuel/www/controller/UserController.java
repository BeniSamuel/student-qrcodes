package com.benisamuel.www.controller;

import com.benisamuel.www.dto.UserDto;
import com.benisamuel.www.model.User;
import com.benisamuel.www.service.UserService;
import com.benisamuel.www.util.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/smis/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<User>>> getAllUsers () {
        return ApiResponse.ok("Successfully obtained all user!!!", userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> getUserById (@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ApiResponse.ok("Successfully obtained user!!!", user);
        }
        return ApiResponse.notFound("Failed to obtain user!!!", null);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<User>> createUser (@Valid @RequestBody UserDto userDto) {
        User newUser = userService.createUser(userDto);
        if (newUser != null) {
            return ApiResponse.created("Successfully created a user!!!", newUser);
        }
        return ApiResponse.badRequest("Failed to create a user!!!", null);
    }
}
