package com.egor.tasks.controller;

import com.egor.tasks.dto.TokenDto;
import com.egor.tasks.dto.UserDto;
import com.egor.tasks.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1.0/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    @Operation(summary = "Get JWT token by login and password",
                responses = {
                        @ApiResponse(description = "JWT token for user",
                                useReturnTypeSchema = true),
                        @ApiResponse(responseCode = "403",
                                description = "User is not found or incorrect password")
                })
    public TokenDto login(@Parameter(description = "Login data", required = true)
                            @RequestBody @Valid UserDto userDto) {
        return userService.login(userDto);
    }

    @PostMapping("/reg")
    @Operation(summary = "Register the user for using this service",
                responses = {
                        @ApiResponse(description = "User is registered",
                                responseCode = "200"),
                        @ApiResponse(responseCode = "409",
                                description = "Duplicate registration data")
                })
    public void reg(@Parameter(description = "Registration data", required = true)
                        @RequestBody @Valid UserDto userDto) {
        userService.reg(userDto);
    }

}
