package jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.ConnectionEvent;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertSource {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        DataSource dataSource = new MysqlDataSource();

        ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/school_db?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("Weng1314.");

        Connection connection = dataSource.getConnection();

        System.out.println("请输入学号:");
        int id = sc.nextInt();
        System.out.println("请输入姓名:");
        String name = sc.next();

        String sql = "insert into student values(?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,name);

        int n = preparedStatement.executeUpdate();
        System.out.println("n = " + n);

        preparedStatement.close();
        connection.close();
    }
}