package com.fengyu.util.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created by 韩峰 on 2016/8/9.
 */
@NoRepositoryBean
public interface BaseDao<T,ID extends Serializable> extends JpaRepository<T, ID>,JpaSpecificationExecutor<T> {

    void myMethod();
}
