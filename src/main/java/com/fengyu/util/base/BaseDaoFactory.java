package com.fengyu.util.base;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryMetadata;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * BaseDao的实现类扔给FactoryBean
 * Created by 韩峰 on 2016/8/9.
 */
public class BaseDaoFactory<S, ID extends Serializable> extends JpaRepositoryFactory {

    public BaseDaoFactory(EntityManager entityManager) {
        super(entityManager);
    }

    /*@SuppressWarnings({ "rawtypes", "unchecked", "hiding" })
    @Override*/
    protected <T, ID extends Serializable> SimpleJpaRepository<?, ?> getTargetRepository(RepositoryMetadata metadata,
                                                                                         EntityManager entityManager) {
        // TODO Auto-generated method stub
        return new BaseDaoImpl(metadata.getDomainType(), entityManager);
    }

    @Override
    protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
        // TODO Auto-generated method stub
        return BaseDao.class;
    }
}
