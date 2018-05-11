package StudentSystem.daoimpl;

import StudentSystem.dao.UserDao;
import StudentSystem.model.User;
import StudentSystem.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao {
    private DBUtil dbUtil = DBUtil.getInstance();

    @Override
    public boolean UserCheck(User user){
        dbUtil.startConnect();
        boolean check = false;
        String sql = "select user_passwd from User where user_name = ?";
        try{
            Connection conn = dbUtil.getConn();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ResultSet res = ps.executeQuery();
            if(res.next()){
                String password = res.getString("user_passwd");
                if(password.equals(user.getPassword())){
                    check = true;
                }
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        dbUtil.stopConnect();
        return check;
    }

    @Override
    public List<User> showAllUser(){
        List<User> userList = new ArrayList<>();
        return  userList;
    }// 显示所有管理员

    @Override
    public void deleteUer(int id){}// 删除管理员

    @Override
    public void updateUser(User user, int id){}// 修改管理员信息

    @Override
    public boolean addUser(User user){dbUtil.startConnect();
        boolean check = false;
        String sql = " SELECT * FROM User WHERE user_name = ?";
        try{
            //检查用户是否存在
            Connection conn = dbUtil.getConn();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ResultSet res = ps.executeQuery();
            if(res.next()){
                check = false;
            }else{
                //添加用户
                sql = "INSERT INTO User(user_name,user_passwd) VALUES (?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1,user.getUsername());
                ps.setString(2,user.getPassword());
                ps.execute();
                check = true;
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        dbUtil.stopConnect();
        return check;
    }
}
