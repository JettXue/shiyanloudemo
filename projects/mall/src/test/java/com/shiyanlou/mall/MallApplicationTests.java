package com.shiyanlou.mall;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallApplicationTests {
    // 注入数据源对象
    @Autowired
    private DataSource dataSource;

    @Test
    public void datasourceTest() throws SQLException {
        // 获取数据源类型
        System.out.println("默认数据源为：" + dataSource.getClass());
        // 获取数据库连接对象
        Connection connection = dataSource.getConnection();
        // 判断连接对象是否为空
//        System.out.println(connection != null);
        Assert.assertNotNull(connection);
        connection.close();
    }
}
