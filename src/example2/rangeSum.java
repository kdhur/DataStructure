import java.io.*;
import java.util.*;

public class rangeSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[][] sum = new int[10 + 1][10 + 1];

        for(int i = 1; i < n + 1; i++) {
            for(int j = i; j < n + 1; j++) {
                sum[i][j] = sum[i][j - 1] + Integer.parseInt(input[j - 1]);
            }
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(sum[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }
}