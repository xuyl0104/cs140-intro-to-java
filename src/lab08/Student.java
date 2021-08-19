package lab08;

public class Student {
	private int age;
	private String name;
	private String gender;
	private boolean teenager;
	public Student(int age, String name, String gender, boolean teenager) {
		super();
		this.age = age;
		this.name = name;
		this.gender = gender;
		this.teenager = teenager;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public boolean isTeenager() {
		return teenager;
	}
	public void setTeenager(boolean teenager) {
		this.teenager = teenager;
	}
	
	

}
