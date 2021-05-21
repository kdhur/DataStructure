package week1;

import java.util.Scanner;

public class Output {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		String s = sc.nextLine();
		String[] arr = s.split(" ");
		
		for (int i = 0; i < t; i++) {
			String ss = sc.nextLine();
			for (int j = 0; j < Integer.parseInt(arr[i]); j++)
				System.out.println(ss);		
		}
		
	}

}
