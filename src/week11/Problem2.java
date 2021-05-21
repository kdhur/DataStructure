package week11;
import java.io.*;
import java.util.*;

class Sniper implements Comparable<Sniper>{
    String name;
    int score;

    public Sniper(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }

    public String getName() {
        return name;
    }

    public int compareTo(Sniper s) {
        if (this.score < s.getScore()) {
            return 1;
        }
        else if (this.score > s.getScore()) {
            return -1;
        }
        return 0;
    }
}

public class Problem2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintStream out;
        try {
            out = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return;
        }

        String line;
        ArrayList<Sniper> candidate = new ArrayList<>();
        while((line = br.readLine()) != null) {
            String[] input = line.split(" ");

            int record[] = new int[input.length];
            for (int i = 1; i < input.length; i++) {
                record[i - 1] = Integer.parseInt(input[i]);
            }
            Arrays.sort(record);

            int result = Integer.MIN_VALUE;
            int temp_score = 0;
            for (int i = 0; i < record.length; i++) {
                temp_score = Math.min(record[i], record.length - i);
                result = Math.max(result, temp_score);
            }
            candidate.add(new Sniper(input[0], result));
        }

        Collections.sort(candidate);

        out.println(candidate.get(0).getName() + " " + candidate.get(0).getScore());
    }
}
