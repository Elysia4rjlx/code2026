package jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);
        //1.创建数据源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/school_db?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("Weng1314.");


        //2.和数据库服务器建立联系
        Connection connection = dataSource.getConnection();

        //3.用Java代码构造出通过sql语句字符串
        System.out.println("请输入学号");
        int id = sc.nextInt();
        System.out.println("请输入姓名");
        String name = sc.next();

        String sql = "insert into student values(?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        statement.setString(2,name);

        // 4. 把语句发送给服务器去执行了，n 表示影响多少行
        int n = statement.executeUpdate();
        System.out.println("n = " + n);

        statement.close();
        connection.close();

    }
}