package com.celltrack.dto;

import lombok.Data;

@Data
public class UserRequest {

    private String nombre;

    private String apellido;

    private String correo;

    private String password;

    private String telefono;

    private String rol;

    private String estado;

}