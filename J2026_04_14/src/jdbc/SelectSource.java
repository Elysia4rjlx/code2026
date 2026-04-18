package jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.mysql.cj.protocol.Resultset;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Scanner;

public class SelectSource {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        DataSource dataSource = new MysqlDataSource();

        ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/school_db?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("Weng1314.");

        Connection connection = dataSource.getConnection();

        String sql = "select * from student";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        System.out.println("---学生信息列表---");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println("学号：" + id);
            System.out.println("姓名： " + name);
        }

        resultSet.close();

        preparedStatement.close();
        connection.close();

    }

}