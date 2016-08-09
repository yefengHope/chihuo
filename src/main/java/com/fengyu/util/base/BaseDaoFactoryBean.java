package com.fengyu.util.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * 定义一个FactoryBean，接到Factory之后，把Factory扔给spring data jpa
 * Created by 韩峰 on 2016/8/9.
 */
public class BaseDaoFactoryBean<R extends JpaRepository<S, ID>, S, ID extends Serializable>
        extends JpaRepositoryFactoryBean<R, S, ID> {

    @SuppressWarnings("rawtypes")
    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        // TODO Auto-generated method stub
        return new BaseDaoFactory(entityManager);
    }
}
