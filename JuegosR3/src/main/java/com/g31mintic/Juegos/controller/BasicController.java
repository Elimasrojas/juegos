package com.g31mintic.Juegos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("basic")
public class BasicController {
    
    //http://localhost:8084/api/basic/hello
    @GetMapping("hello")
    public String saludar() {
        return "Hola";
    }
    
    //http://localhost:8084/api/basic/games/elkin
    @GetMapping("games/{nombre}")
    public String saludarParametrico(@PathVariable("nombre") String nombre){
        return "hola "+nombre;
    }
    
     //http://localhost:8084/api/basic/listado/8
    @GetMapping("listado/{limite}")
    public String listadoNumeros(@PathVariable("limite") int limite){
        String salida = "listado: ";
        for (int i = 1; i <= limite; i++) {
            salida += i + " ";
        }
        return salida;
    }
}