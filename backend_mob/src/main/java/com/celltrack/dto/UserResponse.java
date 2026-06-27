package com.celltrack.dto;

import lombok.Data;

@Data
public class UserResponse {

    private Long id;

    private String nombre;

    private String apellido;

    private String correo;

    private String telefono;

    private String rol;

    private String estado;

}