package week11;

import java.io.*;
import java.util.*;

class Students implements Comparable<Students> {
    String name;
    double score;

    public Students(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Students s) {
        if (this.score < s.getScore()) {
            return 1;
        }
        else if (this.score > s.getScore()) {
            return -1;
        }
        return 0;
    }
}

public class Problem1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintStream out;
        try {
            out = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return;
        }

        int n = Integer.parseInt(br.readLine());
        ArrayList<Students> arr = new ArrayList<>();

        String line;
        String[] input;
        for (int i = 0; i < n; i++) {
            line = br.readLine();
            input = line.split(" ");
            arr.add(new Students(input[0], Double.parseDouble(input[1])));
        }

        Collections.sort(arr);

        for (Students s : arr) {
            out.println(s.getName());
        }
    }
}
