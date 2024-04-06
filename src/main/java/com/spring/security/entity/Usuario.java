package com.spring.security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Table(name = "tb_usuario")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;
    private String email;
    private String nombre;
    private String apellido;
    private String username;
    private String password;

    @ManyToMany( fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_role", // nombre tb intemedia
            joinColumns = @JoinColumn(name = "id_usuario"), //nombre fk de usuario
            inverseJoinColumns = @JoinColumn(name = "id_rol") // nombre fk de rol
    )
    private Set<Rol> roles= new HashSet<>();

}
