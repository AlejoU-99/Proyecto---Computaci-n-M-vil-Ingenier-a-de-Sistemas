package com.celltrack.controller;

import com.celltrack.dto.UserRequest;
import com.celltrack.dto.UserResponse;
import com.celltrack.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UserService userService;

    @GetMapping
    public List<UserResponse> obtenerTodos() {

        return userService.findAll();

    }

    @GetMapping("/{id}")
    public UserResponse obtenerPorId(

            @PathVariable Long id

    ) {

        return userService.findById(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse crear(

            @RequestBody UserRequest request

    ) {

        return userService.create(request);

    }

    @PutMapping("/{id}")
    public UserResponse actualizar(

            @PathVariable Long id,

            @RequestBody UserRequest request

    ) {

        return userService.update(id, request);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(

            @PathVariable Long id

    ) {

        userService.delete(id);

    }

}