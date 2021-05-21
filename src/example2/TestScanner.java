import java.util.Scanner;

class TestScanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        double sum = 0;
        int counter;
        long time = System.currentTimeMillis();

        line = sc.nextLine();
        counter = Integer.parseInt(line);
        for(int i = 0; i < counter; i++) {
            line = sc.nextLine();
            sum += Integer.parseInt(line);
        }

        System.out.println("Time " + (System.currentTimeMillis() - time) + "ms");
        System.out.println("Sum: " + sum);
        sc.close();
    }
}