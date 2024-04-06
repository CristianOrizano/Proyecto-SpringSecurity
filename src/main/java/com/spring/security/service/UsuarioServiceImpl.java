package com.spring.security.service;

import com.spring.security.entity.Usuario;
import com.spring.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
    @Autowired
    private UsuarioRepository repository;

    @Override
    public void grabar(Usuario usu) {
        repository.save(usu);

    }

    @Override
    public List<Usuario> listarusua() {
        return repository.findAll();
    }

    @Override
    public Usuario buscarUser(int cod) {
        return  repository.findById(cod).orElse(null);
    }

    @Override
    public void eliminar(int cod) {
        repository.deleteById(cod);

    }

    @Override
    public Usuario findBynombreusuario(String username) {
        return repository.findByUsername(username);
    }


}
