package com.celltrack.mapper;

import com.celltrack.dto.UserRequest;
import com.celltrack.dto.UserResponse;
import com.celltrack.entity.Usuario;

public class UserMapper {

    private UserMapper() {
    }

    public static Usuario toEntity(UserRequest request) {

        Usuario usuario = new Usuario();

        usuario.setNombre(request.getNombre());
        usuario.setApellido(request.getApellido());
        usuario.setCorreo(request.getCorreo());
        usuario.setPassword(request.getPassword());
        usuario.setTelefono(request.getTelefono());
        usuario.setRol(request.getRol());

        usuario.setActivo(
                request.getEstado() == null
                        || request.getEstado().equalsIgnoreCase("Activo")
        );

        return usuario;

    }

    public static UserResponse toResponse(Usuario usuario) {

        UserResponse response = new UserResponse();

        response.setId(usuario.getId());
        response.setNombre(usuario.getNombre());
        response.setApellido(usuario.getApellido());
        response.setCorreo(usuario.getCorreo());
        response.setTelefono(usuario.getTelefono());
        response.setRol(usuario.getRol());

        response.setEstado(
                usuario.getActivo()
                        ? "Activo"
                        : "Inactivo"
        );

        return response;

    }

}