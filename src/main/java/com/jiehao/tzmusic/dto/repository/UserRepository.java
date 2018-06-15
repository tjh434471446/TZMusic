package com.jiehao.tzmusic.dto.repository;

import com.jiehao.tzmusic.dto.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

    public User findByUsername(String username);
}
