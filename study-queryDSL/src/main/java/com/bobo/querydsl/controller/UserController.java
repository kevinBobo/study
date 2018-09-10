package com.bobo.querydsl.controller;

import com.bobo.querydsl.dto.UserDTO;
import com.bobo.querydsl.entity.QAccount;
import com.bobo.querydsl.entity.QUser;
import com.bobo.querydsl.entity.User;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author bobo
 * @Description:
 * @date 2018/9/5下午3:13
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private EntityManager entityManager;

    private JPAQueryFactory queryFactory;

    @PostConstruct
    public void initFactory(){
        queryFactory = new JPAQueryFactory(entityManager);
    }

    @GetMapping("/queryAll")
    public List<User> queryAll(){
        QUser qUser = QUser.user;
        return queryFactory
                .selectFrom(qUser)
                .orderBy(qUser.id.desc())
                .fetch();
    }

    @RequestMapping("/queryDTO")
    public List<UserDTO> queryDTO(){
        QUser qUser = QUser.user;
        QAccount qAccount = QAccount.account;
        return queryFactory
                .select(Projections.bean(
                        UserDTO.class,
                        qUser.id,
                        qUser.username,
                        qUser.age,
                        qUser.gender,
                        qAccount.suger
                ))
                .from(qUser,qAccount)
                .where(qUser.id.eq(qAccount.userId))
                .fetch();
    }
}
