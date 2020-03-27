package com.shiyanlou.mall.dao;/**
 * @Author jettx
 * @Date 3/24/2020 3:49 PM
 */

import com.shiyanlou.mall.entity.User;

import java.util.List;

/**
 * @author Jettx
 * @date 3/24/2020 3:49 PM
 */
public interface UserDao {
    /**
     * 返回数据列表
     *
     * @return
     */
    List<User> findAllUsers();

    /**
     * 添加
     *
     * @param User
     * @return
     */
    int insertUser(User User);

    /**
     * 修改
     *
     * @param User
     * @return
     */
    int updUser(User User);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int delUser(Integer id);
}
