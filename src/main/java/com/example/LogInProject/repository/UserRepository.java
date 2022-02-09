package com.example.LogInProject.repository;

import com.example.LogInProject.GUI.SignUp;
import com.example.LogInProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAllByLogin(String login);
}
