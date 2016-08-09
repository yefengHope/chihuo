package com.fengyu.util.base;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by 韩峰 on 2016/8/9.
 */

public class BaseDaoImpl<T,ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseDao<T,ID> {

    private final EntityManager em;

    public BaseDaoImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.em = em;
    }

    @Override
    public void myMethod() {

    }
}
