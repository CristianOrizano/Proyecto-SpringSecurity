package com.spring.security.service;

import com.spring.security.entity.Producto;
import com.spring.security.repository.ElectroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectroService {
    @Autowired
    private ElectroRepository repo;

    // graba o actualiza
    public Producto grabar(Producto bean) {
        return repo.save(bean);
    }

    public void eliminar(Integer cod) {
        repo.deleteById(cod);
    }

    public Producto buscar(Integer cod) {
        return repo.findById(cod).orElse(null);
    }

    public List<Producto> listarTodos() {
        return repo.findAll();
    }
}
