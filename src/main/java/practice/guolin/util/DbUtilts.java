package practice.guolin.util;

import java.sql.*;

/**
 * jdbc工具类
 *
 * @author
 * @create 2019-03-13 11:44
 **/
public class DbUtilts {
    private static String url;
    private static String password;
    private static String username;
    private static Connection con;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            url="jdbc:mysql://10.0.13.99:3306/practice?useUnicode=true&characterEncoding=utf-8";
            username="practice";
            password="!QAZxsw2";
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void close(Connection con, Statement statement,ResultSet resultSet){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
