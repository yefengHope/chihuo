package com.fengyu.system.domain.repository.base;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by 韩峰 on 2016/8/10.
 */
public class BaseRepositoryImpl <T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {


    private final Class<T> domainClass;

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.domainClass = domainClass;
    }

    @Override
    public boolean support(String modelType) {
        return domainClass.getName().equals(modelType);
    }
}
