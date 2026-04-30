package com.osantos.springboot.springmvc.app.controllers;

import com.osantos.springboot.springmvc.app.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app") //Para agregar un prefijo es decir de primer nivel localhost:8080/app/view
public class UserController {

    //@GetMapping({"/view", "/", "/another"})
    //@GetMapping({"/view", "/"}) -> Así se mapea para la raíz es decir localhost:8080 y en /view
    @GetMapping({"/view", "/", "/another"}) //Aquí se asigna la ruta url. localhost:8080/view
    public String viewData(Model model){
        model.addAttribute("title","Hola mundo Spring Boot!!!");
        model.addAttribute("message","Esta es una aplicación de ejemplo usando Spring Boot!!!");
        model.addAttribute("user",new User("Oswaldo", "de los Santos"));
        return "view"; // Aquí se debe poner el mismo nombre que se asignó al templete de html
    }
}
