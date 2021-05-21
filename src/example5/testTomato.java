import java.util.*;
import java.io.*;

class testTomato {
    static int N;
    static int M;
    static int[][] box;
    //좌우 위아래 이동가능 방향
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static class Cell { //좌표
        int x;
        int y;
        int day;
        public Cell (int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        box = new int[M][N];

        //box 완성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                box[i][j] = Integer.parseInt(st.nextToken());
        }
        bfs();
    }

    //토마토 위치를 큐에 넣고 하나씩 빼가면서 방문함.
    static void bfs() {
        Queue<Cell> q = new LinkedList<Cell>();
        int day = 0;

        //add item to queue
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++){
                if (box[i][j] == 1) {//토마토가 있는 위치
                    q.offer(new Cell(i, j, 0)); //큐에 넣음
                }
            }
        }
        
        //remove item from queue, visit (count day), add item to queue
        while(!q.isEmpty()) {
            Cell cell = q.poll(); //익은 토마토 큐에서 삭제하고 cell에 저장
            day = cell.day; 

            for(int i = 0; i < 4; i++) { //cell의 상하좌우를 살핌
                int nx = cell.x + dx[i];
                int ny = cell.y + dy[i];
                if(nx >= 0 && nx < M && ny >= 0 && ny < N) { //좌표가 평면을 나가지 않도록 함
                    if (box[nx][ny] == 0) { //토마토가 익지 않은 경우
                        box[nx][ny] = 1;
                        q.add(new Cell(nx, ny, day + 1));
                    }
                }
            }
        }

        if(checkTomato()) {
            System.out.println(day);
        }
        else {
            System.out.println(-1);
        }
    }

    static boolean checkTomato() {
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(box[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
}