package week9;

import java.io.*;
import java.util.*;

class Status {
    public String opener;
    public Map<String, Integer> wordCount;
    public long value;

    Status(String opener) {
        this.opener = opener;
        this.wordCount = new HashMap<>();
        this.value = 0;
    }
}

public class Problem2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Status> stack = new Stack<>();
        stack.push(new Status(""));

        String line;

        while ((line = br.readLine()) != null) {
            String[] words = line.split(" ");

            for (int i = 0; i < words.length; i++) {

                if (words[i].length() == 0) {
                    continue;
                }

                if (words[i].equals("[") || words[i].equals("(") || words[i].equals("{")) {
                    stack.push(new Status(words[i]));
                }
                else if (words[i].equals("]") || words[i].equals(")") || words[i].equals("}")) {
                    if (!(words[i].equals("]") && stack.peek().opener.equals("[")) && !(words[i].equals(")") && stack.peek().opener.equals("(")) && !(words[i].equals("}") && stack.peek().opener.equals("{"))) {
                        System.out.println(-1);
                        return;
                    }
                    Status val = stack.pop();

                    int max = 0;
                    for (String s : val.wordCount.keySet()) {
                        max = Math.max(val.wordCount.get(s), max);
                    }

                    long temp = max + val.value;
                    if (words[i].equals("]")) {
                        temp = temp * 4;
                    }
                    else if (words[i].equals("}")) {
                        temp = temp * 3;
                    }
                    else if (words[i].equals(")")) {
                        temp = temp * 2;
                    }

                    stack.peek().value += temp;
                }
                else {
                    if (stack.peek().wordCount.get(words[i]) == null) {
                        stack.peek().wordCount.put(words[i], 1);
                    } else {
                        stack.peek().wordCount.put(words[i], stack.peek().wordCount.get(words[i]) + 1);
                    }

                }
            }

        }

        Status val = stack.pop();

        int max = 0;
        for (String s : val.wordCount.keySet()) {
            max = Math.max(val.wordCount.get(s), max);
        }

        long temp = max + val.value;

        System.out.println(temp);
    }
}
