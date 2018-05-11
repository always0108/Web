package StudentSystem.model;

public class Student {
	private int num;
	private String name;
	private int age;
	private String sex;
	private String cla;
	private String grade;
	private String url;


	public Student( int num, String name, int age, String sex, String cla,String grade, String url) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.cla = cla;
		this.grade = grade;
		this.url = url;

	}
	public Student(String name, int age, String sex, String cla,String grade, String url) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.cla = cla;
		this.grade = grade;
		this.url = url;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNum() {
		return num; }
	public void setNum(int num) {
		this.num = num; }

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCla() {
		return cla;
	}

	public void setCla(String cla) {
		this.cla = cla;
	}

	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}













	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", gender=" + sex + ", grade=" + grade + ", url=" + url
				+ ", num=" + num + "]";
	}
	
}