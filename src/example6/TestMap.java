import java.util.*;

public class TestMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int itemCounter = scanner.nextInt();
        scanner.nextLine();

        HashMap<String, String> map = new HashMap<String, String>();
        
        String line = scanner.nextLine();
        String[] nameStr = line.split(" ");
        line = scanner.nextLine();
        String[] numberStr = line.split(" ");

        for (int i = 0; i < itemCounter ; i++) {
            map.put(nameStr[i], numberStr[i]);
        }

        int searchCounter = scanner.nextInt();
        scanner.nextLine();
        line = scanner.nextLine();
        String[] searchStr = line.split(" ");
        for (int i = 0; i < searchCounter; i++) {
            System.out.println(map.get(searchStr[i]));
        }
        scanner.close();
    }
}
