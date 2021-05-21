package week11;
import java.util.*;
import java.io.*;

class Student implements Comparable<Student>{
    double location;
    double time;

    public Student(double location, double time) {
        this.location = location;
        this.time = time;
    }

    public double getLocation() {
        return location;
    }

    public double getTime() {
        return time;
    }

    public int compareTo(Student s) {
        if (this.location < s.getLocation()) {
            return -1;
        }
        else if (this.location > s.getLocation()) {
            return 1;
        }
        return 0;
    }
}

public class Problem3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] input = line.split(" ");
        int studentNum = Integer.parseInt(input[0]);
        int distance = Integer.parseInt(input[1]);

        ArrayList<Student> s = new ArrayList<>();
        for (int i = 0; i < studentNum; i++) {
            line = br.readLine();
            input = line.split(" ");
            double location = Double.parseDouble(input[0]);
            double velocity = Double.parseDouble(input[1]);

            double time = (distance - location) / velocity;
            s.add(new Student(location, time));
        }
        Collections.sort(s);

        int groupNum = s.size();
        for (int i = 0; i < s.size(); i++) {
            int isGroup = 0;
            for (int j = i + 1; j < s.size(); j++) {
                if (s.get(i).getTime() <= s.get(j).getTime()) {
                    isGroup++;
                }
            }
            if (isGroup > 0) {
                groupNum--;
            }
        }

        System.out.println(groupNum);

    }
}
