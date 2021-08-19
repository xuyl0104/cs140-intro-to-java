package lab09;

public class Course implements Cloneable {
	private int credits;
	private double grade;
	private String title;
	public Course(int credits, String title) {
		super();
		this.credits = credits;
		this.title = title;
	}
	public int getCredits() {
		return credits;
	}
	public double getGrade() {
		return grade;
	}
	public String getTitle() {
		return title;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	@Override
	 public Course clone() {
	     try {
	        return (Course)super.clone();
	     } catch (CloneNotSupportedException e) {
	        // cannot happen
	        return null;
	     }
	 }
	
	public String toString() {
		return title + "\t" + credits + "\t" + grade;
	}

}
