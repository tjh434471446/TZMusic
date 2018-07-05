package com.jiehao.tzmusic.dao;

import com.jiehao.tzmusic.pojo.SingerCollection;
import com.jiehao.tzmusic.pojo.User;
import org.springframework.data.repository.CrudRepository;

public interface SingerCollectionService extends CrudRepository<SingerCollection,Long> {
    SingerCollection getSingerCollectionsByUser(User user);
}
