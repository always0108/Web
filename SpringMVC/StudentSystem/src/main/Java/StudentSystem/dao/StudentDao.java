package StudentSystem.dao;

import StudentSystem.model.Student;
import java.io.File;
import java.util.ArrayList;


public interface StudentDao {
	void addStudent(Student student);// 添加学生

	void deleteStudent(String name,String path);// 根据学生姓名删除学生

	Student selectStudentByName(String name);// 根据学生姓名查询学生

	ArrayList<Student> selectAllStudent();// 查询所有学生

	void updateStudent(Student student, String name);// 更新学生信息

	boolean studentchek(String name);// 学生是否存在

	String selectStudentImg(String name);// 获取学生Img

	void deleteFile(String path,String name);// 删除学生头像文件

	void uploadFile(String filename,String path,File file);// 上传头像文件
}
