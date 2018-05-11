package StudentSystem.model;

public class User {
	private String username;
	private String password;
	private String passwordvalid;

	public User(String username, String password, String name,String passwordvalid) {
		super();
		this.username = username;
		this.password = password;
		this.passwordvalid = passwordvalid;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordvalid() {
		return passwordvalid;
	}

	public void setPasswordvalid(String passwordvalid) {
		this.passwordvalid = passwordvalid;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
}