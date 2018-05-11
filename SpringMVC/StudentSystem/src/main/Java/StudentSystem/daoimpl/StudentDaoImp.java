package StudentSystem.daoimpl;

import StudentSystem.dao.*;
import StudentSystem.model.Student;
import StudentSystem.util.MysqlConnection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class StudentDaoImp implements StudentDao {
	private MysqlConnection myConnection = new MysqlConnection();
	private Connection conn = null;

	@Override
	public void addStudent(Student student) {
		/*conn = myConnection.getConnction();
		PreparedStatement ps = null;
		String sql = "INSERT INTO Student(Name,Age,Gender,Grade,Img)VALUES(?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, student.getName());
			ps.setInt(2, student.getAge());
			ps.setString(3, student.getGender());
			ps.setString(4, student.getGrade());
			ps.setString(5, student.getUrl());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}

	@Override
	public void deleteStudent(String name,String path) {
		/*PreparedStatement ps = null;
		conn = myConnection.getConnction();
		String sql = "select Img from Student where Name=?";
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while (rs.next()) {
				String url = rs.getString(1);
				File file = new File(path+url);
				file.delete();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		sql = "DELETE FROM Student WHERE  Name=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.execute();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}*/
	}

	@Override
	public Student selectStudentByName(String Name) {
		Student student = new Student();
		conn = myConnection.getConnction();
		String sql = "select * from Student where Name = ?";
		ResultSet rs = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Name);
			rs = ps.executeQuery();
			while (rs.next()) {
				String names = rs.getString(1);
				int age = rs.getInt(2);
				String gender = rs.getString(3);
				String grade = rs.getString(4);
				String url = rs.getString(5);
				student.setName(names);
				student.setAge(age);
				student.setSex(gender);
				student.setUrl(url);
				student.setGrade(grade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public ArrayList<Student> selectAllStudent() {
		ArrayList<Student> studentlist = new ArrayList<Student>();
		/*conn = myConnection.getConnction();
		String sql = "select * from Student";
		ResultSet rs = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			// ps.setString(1, grade);
			rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				String name = rs.getString(1);
				int age = rs.getInt(2);
				String gender = rs.getString(3);
				String grade = rs.getString(4);
				String url = rs.getString(5);
				student.setName(name);
				student.setAge(age);
				student.setGender(gender);
				student.setGrade(grade);
				student.setUrl(url);
				studentlist.add(student);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		return studentlist;
	}

	@Override
	public void updateStudent(Student student, String name) {
		/*PreparedStatement ps = null;
		if (student.getUrl().equals("")) {
			String url = selectStudentImg(name);
			student.setUrl(url);
		}

		try {
			conn = myConnection.getConnction();
			String sql = "update Student set Name=?, Age=?,Gender=?,Grade=?,Img=? where Name=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, student.getName());
			ps.setInt(2, student.getAge());
			ps.setString(3, student.getGender());
			ps.setString(4, student.getGrade());
			ps.setString(5, student.getUrl());
			ps.setString(6, name);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}

	public String selectStudnetimg(String name) {
		String path = null;
		/*conn = myConnection.getConnction();
		String sql = "select img from Student where Name=?";
		ResultSet rs = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while (rs.next()) {
				path = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		return path;
	}

	@Override
	public boolean studentchek(String name) {
		boolean chek = false;
		/*conn = myConnection.getConnction();
		String sql = "select * from Student where Name=?";
		ResultSet rs = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if (rs.next()) {
				chek = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		return chek;
	}

	@Override
	public String selectStudentImg(String name) {
		String chek = "";
		/*conn = myConnection.getConnction();
		String sql = "select Img from Student where Name=?";
		ResultSet rs = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if (rs.next()) {
				chek = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		return chek;
	}

	public void deleteFile(String path, String name) {
		/*PreparedStatement ps = null;
		conn = myConnection.getConnction();
		String sql = "select Img from Student where Name=?";
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while (rs.next()) {
				String url = rs.getString(1);
				File file = new File(path + url);
				file.delete();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}*/

	}

	@Override
	public void uploadFile(String fileFileName, String root, File file) {
		/*fileFileName = "/" + fileFileName;
		File saveFile = new File(root, fileFileName);
		InputStream in;
		OutputStream os;
		try {
			in = new FileInputStream(file);
			os = new FileOutputStream(saveFile);// 保存文件到本地
			byte[] bytes = new byte[512];
			int len = 0;
			while ((len = in.read(bytes)) != -1) {// 写入文件到本地
				os.write(bytes, 0, len);
			}
			os.close();
			in.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}

}
