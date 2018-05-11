package StudentSystem.serviceimpl;

import java.util.List;

import StudentSystem.dao.UserDao;
import StudentSystem.daoimpl.UserDaoImp;
import StudentSystem.model.User;
import StudentSystem.service.UserService;

public class UserServerImp implements UserService {
	private final UserDao dao = new UserDaoImp();

	@Override
	public boolean UserChek(User user) {
		return dao.UserCheck(user);
	}

	@Override
	public List<User> showAllUser() {

		return dao.showAllUser();
	}

	@Override
	public void deleteUser(int id) {
		dao.deleteUer(id);
	}

	@Override
	public void updateUser(User user, int id) {
dao.updateUser(user, id);
	}

	@Override
	public boolean addUser(User user) {
		dao.addUser(user);
		return true;
	}

}
