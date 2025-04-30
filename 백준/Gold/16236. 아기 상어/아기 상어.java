import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int[][] visited = new int[n][n];
        int[] babyShark = new int[2];
        int[] y = {1, -1, 0, 0};
        int[] x = {0, 0, 1, -1};
        int answer = 0;
        int sharkSize = 2;
        int count = 0; // 몇마리를 먹었는지
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 9){
                    babyShark[0] = i;
                    babyShark[1] = j;
                    map[i][j] = 0;
                }
                else{
                    map[i][j] = temp;
                }

            }
        }
        while(true){
            queue.clear();
            // 도착하면 최단경로 저장, 최단 경로 중 가장 위, 왼쪽 위치를 골라야함.
            // 잡아먹고 나서는 babyShark 갱신, 이전 위치 값 0으로 변경
            int minDistance = Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                Arrays.fill(visited[i], 0);
            }

            // 최단거리 물고기들, y,x 저장
            List<int[]> list = new ArrayList<>();
            queue.add(new int[]{babyShark[0], babyShark[1], 0});
            visited[babyShark[0]][babyShark[1]] = 1;
            while(!queue.isEmpty()){
                int[] temp = queue. poll();

                // 먹이 찾음
                // 최단거리를 갱신하고 컨티뉴
                if(map[temp[0]][temp[1]] != 0
                        && map[temp[0]][temp[1]] < sharkSize){
                    if(temp[2] <= minDistance) {
                        minDistance = temp[2];
                        list.add(new int[]{temp[0], temp[1], temp[2]});
                    }
                }

                for(int i=0;i<4;i++){
                    int newY = temp[0] + y[i];
                    int newX = temp[1] + x[i];
                    if(0 <= newY && newY < n
                            && 0 <= newX && newX < n
                            && map[newY][newX] <= sharkSize
                            && visited[newY][newX] == 0){
                        queue.add(new int[]{newY, newX, temp[2] + 1});
                        visited[newY][newX] = 1;
                    }
                }
            }
            if(list.isEmpty()){
                break;
            }
            Collections.sort(list, (a, b)->{
                if (a[2] != b[2]) return a[2] - b[2];
                if (a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            });
            answer += list.get(0)[2];
            // 물고기 먹고 자리 바꾸기
            map[list.get(0)[0]][list.get(0)[1]] = 0;
            babyShark[0] = list.get(0)[0];
            babyShark[1] = list.get(0)[1];
            count++;
            if(count == sharkSize){
                count = 0;
                sharkSize++;
            }
        }
        System.out.println(answer);
    }
}
