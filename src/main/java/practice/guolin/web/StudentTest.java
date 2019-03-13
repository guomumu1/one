package practice.guolin.web;

import practice.guolin.dao.StudentDao;
import practice.guolin.domain.Student;

import java.util.List;

/**
 * @author Administrator
 */
public class StudentTest {

    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
        //添加数据
        //save(studentDao,new Student("小两",20));
        //修改数据
        Student stu = findById(studentDao, 5);
        stu.setName("小样");
        update(studentDao,stu);
        //根据id查询数据
        //Student stu = findById(studentDao, 1);
        // System.out.println(stu);
        //查询所有
        //findAll(studentDao);
    }
    public static void save(StudentDao studentDao,Student student){
        studentDao.save(student);
    }
    public static void update(StudentDao studentDao,Student student){
        studentDao.update(student);
    }
    public static void findAll(StudentDao studentDao){
        List<Student> studentList = studentDao.findAll();
        System.out.println(studentList);
    }
    public static Student findById(StudentDao studentDao,int id){
        Student student = studentDao.findById(id);
        return student;
    }
    public static void delete(StudentDao studentDao,int id){
        studentDao.deleteById(id);
    }
}
