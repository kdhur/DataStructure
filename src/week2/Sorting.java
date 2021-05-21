package week2;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class Sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintStream out;
		try {
			out = new PrintStream(System.out, true, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return;
		}
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		List<Student> s = new ArrayList<Student>();
		
		for (int i = 0; i < t; i++) {
			String name = sc.next();
			int score = sc.nextInt();
			int count = sc.nextInt();
			s.add(new Student(name, score, count));
		}
		
		Comparator<Student> myComparator = new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				if(s2.getScore() == s1.getScore())
					return s1.getCount() - s2.getCount();
				else
					return s2.getScore() - s1.getScore();
			}
		};
		Collections.sort(s, myComparator);
		
		for (int i = 0; i < 3; i++)
			s.remove(0);		
		
		Comparator<Student> myComparator2 = new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				if(s2.getCount() == s1.getCount())
					return s2.getScore() - s1.getScore();
				else
					return s2.getCount() - s1.getCount();
			}
		};
		Collections.sort(s, myComparator2);
		
		for (Iterator<Student> iterator = s.iterator(); iterator.hasNext();) {
			Student student = (Student) iterator.next();
			out.println(student.getName());
		}
	}

}
