package com.osantos.springboot.springmvc.app.controllers;

import com.osantos.springboot.springmvc.app.entities.User;
import com.osantos.springboot.springmvc.app.services.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/users") //Para agregar un prefijo es decir de primer nivel localhost:8080/app/view
public class UserController {
    private final IUserService service;

    public UserController(IUserService service) {
        this.service = service;
    }

    //@GetMapping({"/view", "/", "/another"})
    //@GetMapping({"/view", "/"}) -> Así se mapea para la raíz es decir localhost:8080 y en /view
    @GetMapping({"/view", "/another"}) //Aquí se asigna la ruta url. localhost:8080/view
    public String viewData(Model model) {
        model.addAttribute("title", "Hola mundo Spring Boot!!!");
        model.addAttribute("message", "Esta es una aplicación de ejemplo usando Spring Boot!!!");
        model.addAttribute("user", new User("Oswaldo", "de los Santos"));
        return "view"; // Aquí se debe poner el mismo nombre que se asignó al templete de html
    }

    //Implemetando CRUD
    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("title", "Listadode usuarios");
        model.addAttribute("users", service.findAll());
        return "list";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "Crear Usuario");
        return "form";
    }

    //Aquí ponemos un path variable porque el id de usuario pude variar
    @GetMapping("/form/{id}")
    public String form(@PathVariable Long id, Model model, RedirectAttributes redirect) {
        Optional<User> optionalUser = service.findById(id);
        if (optionalUser.isPresent()) {
            model.addAttribute("user", optionalUser.get());
            model.addAttribute("title", "Editar Usuario");
            return "form";
        } else {
            redirect.addFlashAttribute("error", "El usuario " + id +
                    " no existe en la base datos!");
            return "redirect:/users";
        }
    }

    //Para cuando se recibe el objeto
    @PostMapping
    public String form(User user, Model model, RedirectAttributes redirect) {
        String message = "";
        if (user.getId() > 0) {
            message = "Usuario: " + user.getName() + " se ha actualizado con éxito!";
        } else {
            message = "Usuario: " + user.getName() + " se ha creado con éxito!";
        }

        service.save(user); // Puede ser un INSERT o un UPDATE
        redirect.addFlashAttribute("success", message);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        Optional<User> optionalUser = service.findById(id);
        if (optionalUser.isPresent()) {
            redirect.addFlashAttribute("success", "Usuario: " + optionalUser.get().getName() + " se ha eliminado con éxito! ");
            service.remove(id);
            return "redirect:/users";
        } else {
            redirect.addFlashAttribute("error", "Error el usuario con el id: " + id + " no existe en el sistema");
            return "redirect:/users";
        }
    }
}
