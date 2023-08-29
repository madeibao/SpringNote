package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @ClassName UserRepository
 * @Author：Mayuan
 * @Date 2023/8/29/0029 20:02
 * @Description TODO
 * @Version 1.0
 **/

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from user where name like %?1%", nativeQuery = true)
    Page<User> findByNameLike(String name, Pageable pageRequest);
}
