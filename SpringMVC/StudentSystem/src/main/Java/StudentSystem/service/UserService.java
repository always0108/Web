package StudentSystem.service;

import StudentSystem.model.User;
import java.util.List;

public interface UserService {
	boolean UserChek(User user);

	List<User> showAllUser();// 显示所有管理

	void deleteUser(int id);// 删除管理员

	void updateUser(User user, int id);// 修改管理员信息
	
	boolean addUser(User user);//AddUser;
}
