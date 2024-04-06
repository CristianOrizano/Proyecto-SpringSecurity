package com.spring.security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_electrodomesticos")
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;

    @Column(name = "descripcion")
    private String nombre;

    @Column(name = "stock")
    private int stock;

    @Column(name = "precio")
    private double prec;

    @Column(name = "marca")
    private String marca;

    @Column(name = "nom_archivo")
    private String nombreArchivo;

}
