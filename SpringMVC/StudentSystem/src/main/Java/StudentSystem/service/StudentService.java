package StudentSystem.service;

import StudentSystem.model.Student;
import java.io.File;
import java.util.ArrayList;

public interface StudentService {
	boolean addStudent(Student student);// 添加学生

	void deleteStudent(String name,String path);// 根据学生姓名删除学生

	Student selectStudentByName(String name);// 根据学生姓名查询学生

	ArrayList<Student> selectAllStudent();// 查询所有学生

	void updateStudent(Student student, String name);// 更新学生信息

	boolean studentchek(String name);// 学生是否存在

	String selectStudentImg(String name);// h获取学生Img

	void deletefile(String path,String name);

	void uploadFile(String filename, File file, String path);
}
