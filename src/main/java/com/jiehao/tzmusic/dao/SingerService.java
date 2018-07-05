package com.jiehao.tzmusic.dao;

import com.jiehao.tzmusic.pojo.Singer;
import org.springframework.data.repository.CrudRepository;

public interface SingerService extends CrudRepository<Singer,Long> {
}
