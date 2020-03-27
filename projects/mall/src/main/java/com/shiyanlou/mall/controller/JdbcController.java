package com.shiyanlou.mall.controller;/**
 * @Author jettx
 * @Date 3/24/2020 1:46 PM
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

/**
 * @author Jettx
 * @date 3/24/2020 1:46 PM
 */
@Controller
public class JdbcController {
    public String dbconnect() {
        //第一步，注册驱动程序
        //com.MySQL.jdbc.Driver
        try {
            Class.forName("com.MySQL.jdbc.Driver");
            //第二步，获取一个数据库的连接
            Connection conn = DriverManager.getConnection("数据库地址", "用户名", "密码");
            //第三步，创建一个会话
            Statement stmt = conn.createStatement();
            //第四步，执行SQL语句
            stmt.executeUpdate("SQL语句");
            //或者查询记录
            ResultSet rs = stmt.executeQuery("查询记录的SQL语句");
            //第五步，对查询的结果进行处理
            while (rs.next()) {
                //操作
            }
            //第六步，关闭连接
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    //自动配置，因此可以直接通过 @Autowired 注入进来
    @Autowired
    JdbcTemplate jdbcTemplate;

    // 查询所有记录
    @GetMapping("/users/queryAll")
    public List<Map<String, Object>> queryAll() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from tb_user");
        return list;
    }

    // 新增一条记录
    @GetMapping("/users/insert")
    public Object insert(String name, String password) {
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
            return false;
        }
        jdbcTemplate.execute("insert into tb_user(`name`,`password`) value (\"" + name + "\",\"" + password + "\")");
        return true;
    }
}
