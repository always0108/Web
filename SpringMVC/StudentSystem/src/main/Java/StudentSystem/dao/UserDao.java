package StudentSystem.dao;

import StudentSystem.model.User;

import java.util.List;


public interface UserDao {
	boolean UserCheck(User user);

	List<User> showAllUser();// 显示所有管理员

	void deleteUer(int id);// 删除管理员

	void updateUser(User user, int id);// 修改管理员信息

	boolean addUser(User user);// add管理员
}
