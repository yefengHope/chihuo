package com.fengyu.system.domain.repository.base;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * 自定义基本Repository
 * Created by 韩峰 on 2016/8/10.
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {

    /**
     * @param modelType
     * @return
     */
    boolean support(String modelType);
}
