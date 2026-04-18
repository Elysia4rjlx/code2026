package jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo2 {
    public static void main(String[] args) throws SQLException {
        // 1. 创建数据源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java118?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("2222");

        // 2. 和数据库服务器建立连接
        Connection connection = dataSource.getConnection();

        // 3. 构造 SQL
        String sql = "select * from student";
        PreparedStatement statement = connection.prepareStatement(sql);

        // 4. 执行 SQL, 和服务器通信
        //    返回一个 "结果集"
        ResultSet resultSet = statement.executeQuery();

        // 5. 遍历结果集
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("student_name");
            System.out.println(id + " " + name);
        }

        // 6. 释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}