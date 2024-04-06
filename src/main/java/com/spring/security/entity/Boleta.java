package com.spring.security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Getter
@Setter
@Table(name = "tb_boleta")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Boleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bole")
    private int codigobol;

    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usu;

    @ManyToOne
    @JoinColumn(name = "codigo")
    private Producto pro;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaemei;
}
