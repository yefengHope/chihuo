package com.fengyu.system.domain;

import com.fengyu.system.domain.repository.base.BaseRepository;

/**
 * Created by 韩峰 on 2016/8/10.
 */
public interface UserRepository extends BaseRepository<User,Long> {

    User findUserById(Long id);
    User findUserByName(String name);
}
