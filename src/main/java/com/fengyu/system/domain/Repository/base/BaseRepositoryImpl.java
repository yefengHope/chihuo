package com.fengyu.system.domain.repository.base;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * BaseRepository实现类
 * Created by 韩峰 on 2016/8/10.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
public class BaseRepositoryImpl <T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
    }

    public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

   /* @Override
    public boolean support(String modelType) {
        return domainClass.getName().equals(modelType);
    }*/
}
