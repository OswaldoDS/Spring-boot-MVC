package com.osantos.springboot.springmvc.app.repositories;

import com.osantos.springboot.springmvc.app.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User,Long> {

}
