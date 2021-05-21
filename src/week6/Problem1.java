package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int countGroup = Integer.parseInt(input[0]);
        int nameList = Integer.parseInt(input[1]);

        List<Set> setList = new ArrayList<Set>();

        for (int i = 0; i < countGroup; i++) {
            setList.add(new HashSet<String>());
        }

        for (int i = 0; i < nameList; i++) {
            input = br.readLine().split(" ");
            setList.get(Integer.parseInt(input[0])).add(input[1]);

            }

        int query = Integer.parseInt(br.readLine());

        for (int i = 0; i < query; i++) {
            input = br.readLine().split(" ");
            if (input[0].equals("U")) {
                Set<String> temp = new HashSet<String>();
                temp.addAll(setList.get(Integer.parseInt(input[1])));
                temp.addAll(setList.get(Integer.parseInt(input[2])));
                temp.addAll(setList.get(Integer.parseInt(input[3])));
                System.out.println(temp.size());
            }
            else if (input[0].equals("I")) {
                Set<String> temp = new HashSet<String>();
                temp.addAll(setList.get(Integer.parseInt(input[1])));
                temp.retainAll(setList.get(Integer.parseInt(input[2])));
                temp.retainAll(setList.get(Integer.parseInt(input[3])));
                System.out.println(temp.size());
            }
            else if (input[0].equals("D")) {
                Set<String> temp = new HashSet<String>();
                temp.addAll(setList.get(Integer.parseInt(input[1])));
                temp.removeAll(setList.get(Integer.parseInt(input[2])));
                temp.removeAll(setList.get(Integer.parseInt(input[3])));
                System.out.println(temp.size());
            }
        }


    }
}
