package com.spring.security.repository;

import com.spring.security.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectroRepository extends JpaRepository<Producto, Integer> {

}
