import java.io.*;
import java.util.Arrays;

public class Entrance {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());
        int result[] = new int[testCount];
        int serverCount = 0;

        for (int i = 0; i < testCount; i++) {
            String[] readInputString = br.readLine().split(" "); //server마다 업무 처리 시간 입력
            serverCount = readInputString.length;
            int serverTime[] = new int[serverCount];
            int userCount = Integer.parseInt(br.readLine()); //user 수 입력
            for (int j = 0; j < serverCount; j++) {
                serverTime[j] = Integer.parseInt(readInputString[j]); //업무 처리 시간 배열에 저장
            }

            Arrays.sort(serverTime); //binary search는 정렬해서 수행
            result[i] = BinarySearch(serverTime, userCount, serverTime[serverCount - 1]);
            System.out.println(result[i]);
        }
    }

    static int BinarySearch(int[] serverTime, int n, int max) { //(업무 처리시간, user수, 탐색최대범위값)
        int left = 1, right = max * n; //left는 최소, right는 최대로 걸리는 시간으로 초기화
        int middle = 0;
        int result = Integer.MAX_VALUE;

        while(left <= right) {
            middle = (left + right) / 2;
            if (canPass(serverTime, n, middle)) {
                result = result > middle ? middle : result;
                right = middle - 1; //점점 반으로 줄여감
            }
            else {
                left = middle + 1;
            }
        }
        return result;
    }

    static boolean canPass(int[] serverTime, int n, int middle) {
        int passUserCount = 0;
        for (int i = 0; i < serverTime.length; i++) {
            passUserCount += middle / serverTime[i];
        }

        if (passUserCount >= n) {
            return true;
        }
        else {
            return false;
        }
    }
}