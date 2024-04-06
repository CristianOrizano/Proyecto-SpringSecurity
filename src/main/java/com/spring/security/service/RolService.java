package com.spring.security.service;

import com.spring.security.entity.Rol;
import com.spring.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {
    @Autowired
    private RolRepository repository;

    //listar roles
    public List<Rol> listarroles() {

        return repository.findAll();
    }
}
