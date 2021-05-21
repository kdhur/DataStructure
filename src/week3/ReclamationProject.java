package week3;

import java.io.*;

public class ReclamationProject {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 2];
		long sum = 0, max = 0;


		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			String[] input = br.readLine().split(" ");
			int fr = Integer.parseInt(input[0]);
			int to = Integer.parseInt(input[1]);
			int value = Integer.parseInt(input[2]);
			arr[fr] += value;
			arr[to + 1] -= value;
		}
		
		for (int i = 1; i < arr.length; i++) {
			sum += arr[i];
			max = Math.max(max, sum);
		}

		bw.write(Long.toString(max));
		bw.close();
	}

}
