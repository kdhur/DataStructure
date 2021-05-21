import java.io.*;

public class hindex {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //test case

        while (n-- > 0) {
            String line = br.readLine();
            String[] IntStr = line.trim().split("\\s+"); //정렬되지 않은 논문 인용 횟수

            int result = Integer.MIN_VALUE;
            int count = 0;
            int temp_hindex = 0;

            int input[] = new int[IntStr.length];
            for (int i = 0; i < IntStr.length; i++) {
                input[i] = Integer.parseInt(IntStr[i]);
            } //인용 횟수 정수로 변환
            
            //정렬하지 않고 hindex 찾기
            for (int i = 0; i < input.length; i++) {
                count = 0;
                temp_hindex = input[i];
                for (int j = 0; j < input.length; j++) {
                    if(temp_hindex <= input[j]) {
                        count++;
                    }
                }
                temp_hindex = Math.min(temp_hindex, count);
                result = Math.max(result, temp_hindex);
            }
            System.out.println(result);
        }
    }
}