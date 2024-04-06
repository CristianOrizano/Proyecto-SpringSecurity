package com.spring.security.controller;

import com.spring.security.entity.Rol;
import com.spring.security.entity.Usuario;
import com.spring.security.service.IUsuarioService;
import com.spring.security.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    IUsuarioService ususervice;

    @Autowired
    RolService rolservice;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @RequestMapping("/lista")
    public String listar(Model model) {

        //enviar lista de usuarios
        List<Usuario> usuarios= ususervice.listarusua();

        //enviar lista de roles
        List<Rol> roles= rolservice.listarroles();
        //enviar objeto usuario
        Usuario usu= new Usuario();

        model.addAttribute("listaroles",roles);
        model.addAttribute("usuario",usu);
        model.addAttribute("listausu",usuarios);

        return "usuario";
    }

    //update or add
    @RequestMapping("/grabar")
    public String grabar(Model model, @ModelAttribute Usuario usu, RedirectAttributes redirect) {

        try {
            int cod= usu.getId_usuario();
            //crear lista de roles
            Set<Rol> roles= new HashSet<>();

            for (Rol role : usu.getRoles()) {

                roles.add(role);
                System.out.println("codigo==>"+ role.getId_rol()+"Nombre rol"+role.getNombre());
            }

    	/*	//objeto rol
    		Rol rol= new Rol();
    		rol.setId_rol(1);
    		//lista de roles
    		 Set<Rol> roles= new HashSet<>();
    		 roles.add(rol); */

            //agregamos los roles del usuario
            usu.setRoles(roles);
            //password encriptado
            usu.setPassword(passwordEncoder.encode(usu.getPassword()));

            ususervice.grabar(usu);
            if(cod == 0) {
                redirect.addFlashAttribute("MENSAJE","USUARIO Registrado");
            }else {
                redirect.addFlashAttribute("MENSAJE","USUARIO actualizado");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error al graba"+e.getMessage());
        }

        return "redirect:/usuario/lista";
    }

    @RequestMapping("/delete/{cod}")
    public String delete(Model model, @PathVariable("cod")int cod, RedirectAttributes redirect) {

        ususervice.eliminar(cod);
        redirect.addFlashAttribute("MENSAJE","USUARIO eliminado");

        return "redirect:/usuario/lista";
    }

    @ResponseBody
    @RequestMapping("/buscar/{cod}")
    public Usuario buscar(Model model, @ModelAttribute Usuario usu,@PathVariable("cod") int cody) {

        Usuario us= ususervice.buscarUser(cody);

        return us;
    }


}

