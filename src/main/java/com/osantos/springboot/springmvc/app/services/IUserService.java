package com.osantos.springboot.springmvc.app.services;

import com.osantos.springboot.springmvc.app.entities.User;

import java.util.List;
import java.util.Optional;

//Unicamente para accesos de datos, consultas, operaciones a la base de datos
public interface IUserService {
    List<User> findAll();

    Optional<User> findById(Long id);

    User save(User user);

    void remove(Long id);
}
