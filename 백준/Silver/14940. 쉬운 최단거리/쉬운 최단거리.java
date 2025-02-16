import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // ✅ BufferedWriter 추가
        
        StringTokenizer input = new StringTokenizer(br.readLine());
        int column = Integer.parseInt(input.nextToken());
        int row = Integer.parseInt(input.nextToken());
        int[][] map = new int[column][row];
        int[] start = new int[2];
        int[][] visited = new int[column][row];

        // 방문 초기 값 -1
        for(int i = 0; i < column; i++) Arrays.fill(visited[i], -1);

        for(int i = 0; i < column; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < row; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) start = new int[]{i, j};
                if(map[i][j] == 0) visited[i][j] = 0;
            }
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start[0], start[1], 0));
        visited[start[0]][start[1]] = 0;
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i = 0; i < 4; i++){
                int newY = node.y + y[i];
                int newX = node.x + x[i];
                if(0 <= newY && 0 <= newX
                && newY < column && newX < row
                && map[newY][newX] != 0 && visited[newY][newX] == -1){
                    visited[newY][newX] = node.count + 1;
                    queue.add(new Node(newY, newX, node.count + 1));
                }
            }
        }

        // ✅ `BufferedWriter`를 사용하여 출력 최적화
        for(int i = 0; i < column; i++){
            for(int j = 0; j < row; j++){
                bw.write(visited[i][j] + " ");
            }
            bw.newLine(); // 줄 바꿈
        }

        // ✅ 출력 후 flush & close
        bw.flush();
        bw.close();
    }

    public static class Node {
        int y;
        int x;
        int count;

        public Node(int y, int x, int count){
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
}
