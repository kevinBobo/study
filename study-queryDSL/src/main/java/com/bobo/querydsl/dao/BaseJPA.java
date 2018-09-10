package com.bobo.querydsl.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author bobo
 * @Description:
 * @date 2018/9/5下午3:10
 */
@NoRepositoryBean
public interface BaseJPA<T> extends JpaRepository<T, Long>
        , JpaSpecificationExecutor<T>, QueryDslPredicateExecutor<T> {
}
