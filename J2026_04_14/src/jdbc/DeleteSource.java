package jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteSource {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/school_db?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("Weng1314.");


        Connection connection = dataSource.getConnection();

        System.out.println("请输入你要删除的学生id:");
        int id = sc.nextInt();

        String sql = "delete from student where id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1,id);
        int n = preparedStatement.executeUpdate();
        if (n > 0) {
            System.out.println("删除成功！受影响的行数 n = " + n);
        } else {
            System.out.println("删除失败，未找到该学号！");
        }

        preparedStatement.close();
        connection.close();
    }
}