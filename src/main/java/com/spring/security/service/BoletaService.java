package com.spring.security.service;

import com.spring.security.entity.Boleta;
import com.spring.security.repository.BoletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoletaService {
    @Autowired
    private BoletaRepository repobol;

    public void grabarboleta(Boleta bol) {

        repobol.save(bol);
    }
}
