package cn.chenjiajin.service;

import cn.chenjiajin.domain.User;
import cn.chenjiajin.domain.qo.PageResult;
import cn.chenjiajin.domain.qo.QueryObject;

import java.util.List;

/**
 * @ClassName IUserService
 * @Author：Mayuan
 * @Date 2023/8/30/0030 18:30
 * @Description TODO
 * @Version 1.0
 **/
public interface IUserService {

    void delete(Long id);

    void insert(User User);

    User select(Long id);

    List<User> selectAll();

    void update(User User);

    int selectForCount(QueryObject qo);

    PageResult<User> selectForList(QueryObject qo);
}
