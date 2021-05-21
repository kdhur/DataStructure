import java.io.*;

public class TestBR {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        double sum = 0;
        int counter;
        long time = System.currentTimeMillis();
        counter = Integer.parseInt(in.readLine());

        for (int i = 0; i < counter; i++) {
            sum += Integer.parseInt(in.readLine());
        }

        System.out.println("Time " + (System.currentTimeMillis() - time) + "ms");
        System.out.println("Sum: " + sum);
    }
}
