package week7;
import java.util.*;
import java.io.*;

public class Problem1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();

        String line;
        int totalCount = 0;
        while((line=br.readLine()) != null) {
            String[] words = line.split(" ");
            for(int i = 0; i < words.length; i++) {
                if (map.get(words[i].toLowerCase()) == null && !words[i].equals("")) {
                    map.put(words[i].toLowerCase(), 1);
                    totalCount++;
                } else if(!words[i].equals("")) {
                    map.put(words[i].toLowerCase(), map.get(words[i].toLowerCase()) + 1);
                    totalCount++;
                }
            }
        }

        double max = 0;
        String result = "";

        for (String key : map.keySet()) {
            if (max < map.get(key)) {
                max = map.get(key);
                result = key;
            }
        }

        double ratio = Math.round((max/totalCount)*100)/100.0;

        PrintStream out;
        try {
            out = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return;
        }
        out.println(result + " " +ratio);
    }
}
