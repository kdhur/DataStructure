package week2;

public class Student{
	private String name;
	private int score;
	private int count;
	
	public Student(String name, int score, int count) {
		setName(name);
		setScore(score);
		setCount(count);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
