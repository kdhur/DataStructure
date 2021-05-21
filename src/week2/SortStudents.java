package week2;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class SortStudents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		PrintStream out;
        try {
            out = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return;
        }        
        
		int t = sc.nextInt();
		sc.nextLine();
		List<Students> list = new ArrayList<>();
		for (int i = 0; i < t; i++) {
			String input = sc.nextLine();
			String info[] = input.split(" ");
			if(info.length == 3)
				list.add(new Android(info[0], info[1], info[2]));
			else if(info.length == 2)
				list.add(new Human(info[0], Integer.parseInt(info[1])));
		}
		
		Collections.sort(list);
		
		for (Iterator<Students> iterator = list.iterator(); iterator.hasNext();) {
			Students students = (Students) iterator.next();
			out.println(students.name);
		}
	}

}
