package practice.guolin.dao;


import practice.guolin.domain.Student;
import practice.guolin.util.DbUtilts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * dao层
 *
 * @author
 * @create 2019-03-13 11:09
 **/
public class StudentDao {
    /**
     * @param student
     * 添加数据库
     */
    public void save(Student student){
        Connection connection = DbUtilts.getConnection();
        PreparedStatement pre=null;
        try {
            String sql="insert into student_guolin (sname,age) values (?,?)";
            connection.setAutoCommit(false);
             pre = connection.prepareStatement(sql);
            pre.setString(1,student.getName());
            pre.setInt(2,student.getAge());
            pre.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            DbUtilts.close(connection,pre,null);
        }
    }

    /**
     * @param student
     * 修改数据库
     */
    public void update(Student student){
        Connection connection = DbUtilts.getConnection();
        PreparedStatement pre=null;
        try {
            String sql="update student_guolin set sname=?,age=? where sid=?";
            connection.setAutoCommit(false);
            pre = connection.prepareStatement(sql);
            pre.setString(1,student.getName());
            pre.setInt(2,student.getAge());
            pre.setInt(3,student.getId());
            pre.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            DbUtilts.close(connection,pre,null);
        }
    }

    /**
     * @return List<Student>
     *查询全部
     */
    public List<Student> findAll(){
        Connection connection = DbUtilts.getConnection();
        PreparedStatement pre=null;
        ResultSet resultSet=null;
        try {
            String sql="select sid,sname,age from student_guolin";
            pre = connection.prepareStatement(sql);
            resultSet= pre.executeQuery();
            List<Student> list=new ArrayList<Student>();
            while(resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt("sid"));
                student.setName(resultSet.getString("sname"));
                student.setAge(resultSet.getInt("age"));
                list.add(student);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtilts.close(connection,pre,resultSet);
        }
        return null;
    }

    /**
     * @param sid
     * @return Student
     * 根据id查询
     */
    public Student findById(int sid){
        Connection connection = DbUtilts.getConnection();
        PreparedStatement pre=null;
        ResultSet resultSet=null;
        try {
            String sql="select sid,sname,age from student_guolin where sid=?";
            pre= connection.prepareStatement(sql);
            pre.setInt(1,sid);
            resultSet = pre.executeQuery();
            while(resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt("sid"));
                student.setName(resultSet.getString("sname"));
                student.setAge(resultSet.getInt("age"));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtilts.close(connection,pre,resultSet);
        }
        return null;
    }

    /**
     * @param sid
     * 根据id删除数据
     */
    public void deleteById(int sid){
        Connection connection = DbUtilts.getConnection();
        PreparedStatement pre=null;
        ResultSet resultSet=null;
        try {
            connection.setAutoCommit(false);
            String sql="delete from student_guolin where sid=?";
            pre=connection.prepareStatement(sql);
            pre.setInt(1,sid);
            pre.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            DbUtilts.close(connection,pre,resultSet);
        }
    }
}
