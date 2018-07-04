package com.jiehao.tzmusic.dao;

import com.jiehao.tzmusic.pojo.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {

    User getByUsernameAndAndPassword(String username,String password);
    List<User> findByUsername(String username);
}
