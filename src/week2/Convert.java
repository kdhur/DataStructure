package week2;

import java.util.Scanner;

public class Convert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			double value = sc.nextDouble();
			char scale = sc.next().charAt(0);
			Temperature temperature = new MyTemperature(value, scale);
			System.out.println(temperature);
			
		}
	}

}
