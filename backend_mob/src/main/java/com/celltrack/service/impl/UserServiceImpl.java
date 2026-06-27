package com.celltrack.service.impl;

import com.celltrack.dto.UserRequest;
import com.celltrack.dto.UserResponse;
import com.celltrack.entity.Usuario;
import com.celltrack.mapper.UserMapper;
import com.celltrack.repository.UserRepository;
import com.celltrack.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public List<UserResponse> findAll() {

        return repository.findAll()
                .stream()
                .map(UserMapper::toResponse)
                .toList();

    }

    @Override
    public UserResponse findById(Long id) {

        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return UserMapper.toResponse(usuario);

    }

    @Override
    public UserResponse create(UserRequest request) {

        Usuario usuario = UserMapper.toEntity(request);

        usuario.setFechaCreacion(LocalDateTime.now());

        usuario.setFechaActualizacion(LocalDateTime.now());

        usuario = repository.save(usuario);

        return UserMapper.toResponse(usuario);

    }

    @Override
    public UserResponse update(Long id, UserRequest request) {

        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuario.setNombre(request.getNombre());
        usuario.setApellido(request.getApellido());
        usuario.setCorreo(request.getCorreo());

        if (request.getPassword() != null && !request.getPassword().isBlank()) {
            usuario.setPassword(request.getPassword());
        }

        usuario.setRol(request.getRol());

        usuario.setFechaActualizacion(LocalDateTime.now());

        repository.save(usuario);

        return UserMapper.toResponse(usuario);

    }

    @Override
    public void delete(Long id) {

        repository.deleteById(id);

    }

}