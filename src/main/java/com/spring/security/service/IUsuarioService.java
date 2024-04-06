package com.spring.security.service;

import com.spring.security.entity.Usuario;

import java.util.List;

public interface IUsuarioService {

    //update or add
    public void grabar(Usuario usu);
    //listar usuarios
    public List<Usuario> listarusua();

    //search to update
    public Usuario buscarUser(int cod);

    //delete user
    public void eliminar(int cod);

    public Usuario findBynombreusuario(String username);
}
