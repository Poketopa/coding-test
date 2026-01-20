import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] map = new int[501][501];
        int[][][] visited = new int[501][501][2]; // 갔던 곳인지, 생명 몇 깎이는지
        // 위험 - 1
        // 죽음 - 2

        int danger = Integer.parseInt(br.readLine());
        for (int i = 0; i < danger; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int x1 = Math.min(a, c);
            int x2 = Math.max(a, c);
            int y1 = Math.min(b, d);
            int y2 = Math.max(b, d);

            for (int j = y1; j <= y2; j++) {
                for (int k = x1; k <= x2; k++) {
                    map[j][k] = 1;
                }
            }
        }

        int death = Integer.parseInt(br.readLine());
        for (int i = 0; i < death; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int x1 = Math.min(a, c);
            int x2 = Math.max(a, c);
            int y1 = Math.min(b, d);
            int y2 = Math.max(b, d);

            for (int j = y1; j <= y2; j++) {
                for (int k = x1; k <= x2; k++) {
                    map[j][k] = 2;
                }
            }
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]); // y, x, 생명
        queue.add(new int[]{0, 0, 0});

        int[] y = new int[]{0, 0, 1, -1};
        int[] x = new int[]{1, -1, 0, 0};

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int nowY = temp[0];
            int nowX = temp[1];

            for(int i=0;i<4;i++){
                int newY = nowY + y[i];
                int newX = nowX + x[i];
                if(0 <= newY && newY <= 500
                && 0 <= newX && newX <= 500){
                    if(map[newY][newX] == 2) continue;
                    if(visited[newY][newX][0] == 1 && visited[newY][newX][1] <= temp[2]) continue;

                    // 안간 곳일 때
                    if(visited[newY][newX][0] == 0){
                        if(map[newY][newX] == 1){
                            queue.add(new int[]{newY, newX, temp[2] + 1});
                            visited[newY][newX][0] = 1;
                            visited[newY][newX][1] = temp[2] + 1;
                            continue;
                        }
                        queue.add(new int[]{newY, newX, temp[2]});
                        visited[newY][newX][0] = 1;
                        visited[newY][newX][1] = temp[2];
                    }
                    // 가본 곳일 때
                    else{
                        if(map[newY][newX] == 1){
                            if(temp[2] + 1 < visited[newY][newX][1]){
                                queue.add(new int[]{newY, newX, temp[2] + 1});
                                visited[newY][newX][1] = temp[2] + 1;
                            }
                        } else{
                            if(temp[2] < visited[newY][newX][1]){
                                queue.add(new int[]{newY, newX, temp[2]});
                                visited[newY][newX][1] = temp[2];
                            }
                        }
                    }
                }
            }
        }

        if(visited[500][500][0] == 1){
            System.out.print(visited[500][500][1]);
        } else{
            System.out.print("-1");
        }
    }
}
