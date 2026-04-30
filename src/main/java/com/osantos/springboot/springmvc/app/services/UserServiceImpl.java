package com.osantos.springboot.springmvc.app.services;

import com.osantos.springboot.springmvc.app.entities.User;
import com.osantos.springboot.springmvc.app.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository repository;


    @Transactional(readOnly = true) //Si la transacción es solo lectura debe ser true
    @Override
    public List<User> findAll() {
        return (List<User>) this.repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> findById(Long id) {
        return this.repository.findById(id);
    }

    @Transactional //Aquí debe ser false (default), ya que es no solo es lectura, sino escritura también lo es
    @Override
    public User save(User user) {
        return this.repository.save(user);
    }

    @Override
    @Transactional
    public void remove(Long id) {

    }
}
