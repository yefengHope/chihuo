package com.fengyu.system.domain.repository;

import com.fengyu.system.domain.User;
import com.fengyu.system.domain.repository.base.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by 韩峰 on 2016/8/10.
 */
public interface UserRepository extends BaseRepository<User,Long> {

    User findUserById(Long id);

    User findUserByName(String name);

}
