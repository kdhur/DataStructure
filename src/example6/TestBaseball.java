import java.io.*;
import java.util.*;

public class TestBaseball {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] trial = new int[n];
        int[] strikes = new int[n];
        int[] balls = new int[n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            trial[i] = Integer.parseInt(input[0]);
            strikes[i] = Integer.parseInt(input[1]);
            balls[i] = Integer.parseInt(input[2]);
        }
        br.close();

        HashSet<Integer> solutionset = new HashSet<Integer>();

        // brute force
        for (int i = 123; i <= 987; i++) {
            int[] digit = new int[3];
            digit[2] = i / 100;
            digit[1] = (i % 100) / 10;
            digit[0] = i % 10;

            if ((digit[0] == 0) || (digit[0] == digit[1]) || (digit[0] == digit[2]) || (digit[1] == digit[2])) {
                continue;
            }

            boolean isCandidate = true;
            for (int j = 0; j < n; j++) {
                isCandidate &= compareDigit(digit, trial[j], strikes[j], balls[j]);
            }

            if (isCandidate) {
                if(!solutionset.contains(i)) {
                    solutionset.add(i);
                }
            }

            
        }

        for (Integer i : solutionset) {
            System.out.println(i);
        }

        System.out.println(solutionset.size());
    }

    private static boolean compareDigit(int[] candidate_digit, int trial, int strikes, int balls) {
        int[] trial_digit = new int[3];
        trial_digit[2] = trial / 100;
        trial_digit[1] = (trial % 100) / 10;
        trial_digit[0] = trial % 10;

        int trial_strike = 0;
        int trial_ball = 0;

        for (int i = 0; i < 3; i++) {
                if (candidate_digit[i] == trial_digit[i]) {
                    trial_strike++;
                }  
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j && candidate_digit[i] == trial_digit[j]) {
                    trial_ball++;
                }

            }
        }

        return(trial_strike == strikes && trial_ball == balls);
    }
}
