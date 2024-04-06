package com.spring.security.controller;

import com.spring.security.entity.Boleta;
import com.spring.security.entity.Producto;
import com.spring.security.entity.Usuario;
import com.spring.security.service.BoletaService;
import com.spring.security.service.ElectroService;
import com.spring.security.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
@RequestMapping("/electro")
public class ElectroController {

    // String URL_PRODUCTO= "http://localhost:8091/apielec/api";

    @Autowired
    ElectroService serviceelec;

    @Autowired
    IUsuarioService serusu;

    @Autowired
    BoletaService serbole;

    @RequestMapping("/lis")
    public String inicio(Model model) {

        List<Producto> productos= serviceelec.listarTodos();
		/*RestTemplate res = new RestTemplate();
		Producto[] productos = res.getForObject(URL_PRODUCTO, Producto[].class);
         System.out.println("entro aquie=========");
         for (Producto pr : productos) {
        	 System.out.println("datos "+ pr.getNombre() );
		} */


        Producto el = new Producto();

        model.addAttribute("lista", productos);
        model.addAttribute("elec", el);
        return "crud";
    }

    @RequestMapping("/catalogo")
    public String catalogo(Model model) {

        List<Producto> productos= serviceelec.listarTodos();
		/*RestTemplate res = new RestTemplate();
		Producto[] productos = res.getForObject(URL_PRODUCTO, Producto[].class); */

        model.addAttribute("lista", productos);

        return "cataloo";
    }

    @RequestMapping("/selecDeta")
    public String detalle(Model model, @RequestParam("txtcodigo") int cod) {

        Producto producto= serviceelec.buscar(cod);

		/* String ruta = URL_PRODUCTO+"/" + cod;
	     RestTemplate res = new RestTemplate();
	     Producto producto = res.getForObject(ruta, Producto.class); */

        model.addAttribute("elec",producto);

        return "detalle";
    }

    @RequestMapping("/grabarventa")
    public String ventas(@RequestParam("txtcodigo") int codi, @RequestParam("cantidad") int cant,
                         @AuthenticationPrincipal User user, RedirectAttributes redirect) {

        String usu = user.getUsername();
        Usuario u = serusu.findBynombreusuario(usu);
        Producto pro = new Producto();
        pro.setCodigo(codi);

        Usuario suario = new Usuario();
        suario.setId_usuario(u.getId_usuario());

        Boleta bol = new Boleta();
        bol.setFechaemei(new Date());
        bol.setPro(pro);
        bol.setUsu(suario);
        bol.setCantidad(cant);
        bol.setUsu(suario);

        serbole.grabarboleta(bol);
        redirect.addFlashAttribute("MENSAJE", "Compra exitosa");

        return "redirect:/electro/catalogo";
    }

    @RequestMapping("/grabar")
    public String registrar(Model model, @ModelAttribute("elec") Producto elec, RedirectAttributes redirect) {

        try {
            int cod = elec.getCodigo();

            serviceelec.grabar(elec);
			/*RestTemplate restTemplate = new RestTemplate();
			restTemplate.postForObject(URL_PRODUCTO, elec, Producto.class); */

            if (cod == 0) {
                redirect.addFlashAttribute("MENSAJE", "Registro exitoso");
            } else {

                redirect.addFlashAttribute("MENSAJE", "Actualizado exitoso");
            }

        } catch (Exception e) {
            System.out.println("error al grabar" + e.getMessage());
        }

        return "redirect:/electro/lis";
    }

    @RequestMapping("/buscar")
    @ResponseBody
    // convertir ese medicamento que retorna aun json
    public Producto buscar(@RequestParam("codigo") int cod) {
        Producto producto= serviceelec.buscar(cod);

		 /*String ruta = URL_PRODUCTO+"/" + cod;
	     RestTemplate res = new RestTemplate();
	     Producto producto = res.getForObject(ruta, Producto.class); */


        return producto;
    }

    // metodo eliminar
    @RequestMapping("/eliminar")
    public String Eliminar(@RequestParam("codigo") int cod, RedirectAttributes redirect) {
        try {
            serviceelec.eliminar(cod);
			 /*String ruta = URL_PRODUCTO+"/" + cod;
		     RestTemplate res = new RestTemplate();
		        res.delete(ruta); */
            redirect.addFlashAttribute("MENSAJE", "Eliminado exitoso");

        } catch (Exception e) {
            redirect.addFlashAttribute("MENSAJE", "error eliminar");
            System.out.println("error al eliiminar" + e.getMessage());
        }
        return "redirect:/electro/lis";
    }

    @RequestMapping("/subir-archivo")
    // recuperamos la caja data y almcaceno en archivo
    public String subirArchivo(@RequestParam("data") MultipartFile archivo, @RequestParam("codigo") Integer cod,
                               RedirectAttributes redirect) throws IOException {

        // guardo el nombre de la imagen en una varible
        String nomArchivo = archivo.getOriginalFilename();
        Producto ele = serviceelec.buscar(cod);
        // necesito los archivos de la img pero en byte(ya que las imagnes tienes byte)
        byte[] bytes = archivo.getBytes();
        //
        String ruta = "C://ZClinica//DatosImg//";
        // generar archivo
        Files.write(Paths.get(ruta + nomArchivo), bytes);
        ele.setNombreArchivo(nomArchivo);
        serviceelec.grabar(ele);
        // serviceelec.actualizarIMG(nomArchivo, cod);
        redirect.addFlashAttribute("MENSAJE", "Foto actualizada");
        return "redirect:/electro/lis";
    }

}
