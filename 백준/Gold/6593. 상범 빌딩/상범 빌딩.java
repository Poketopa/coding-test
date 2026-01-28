import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int[] x = {1, -1, 0, 0, 0, 0};
        int[] y = {0, 0, 1, -1, 0, 0};
        int[] z = {0, 0, 0, 0, 1, -1};

        x:while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int floor = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            int column = Integer.parseInt(st.nextToken());

            if(floor == 0 && row == 0 && column == 0) return;

            char[][][] map = new char[floor][row][column];
            int[][][] visited = new int[floor][row][column];

            int[] start = new int[3];

            for(int i=0;i<floor;i++){
                for(int j=0;j<row;j++){
                    String input = br.readLine();
                    for(int k=0;k<column;k++){
                        map[i][j][k] = input.charAt(k);
                        if(map[i][j][k] == 'S'){
                            start[0] = i;
                            start[1] = j;
                            start[2] = k;
                        }
                    }
                }
                br.readLine();
            }
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{start[0], start[1], start[2], 0});
            visited[start[0]][start[1]][start[2]] = 1;

            while(!queue.isEmpty()){
                int[] temp = queue.poll();
                for(int l=0;l<6;l++){
                    int newZ = temp[0] + z[l];
                    int newY = temp[1] + y[l];
                    int newX = temp[2] + x[l];

                    if(0 <= newZ && newZ < floor
                            && 0 <= newY && newY < row
                            && 0 <= newX && newX < column
                            && visited[newZ][newY][newX] == 0
                            && (map[newZ][newY][newX] == '.' || map[newZ][newY][newX] == 'E')){
                        if(map[newZ][newY][newX] == 'E'){
                            System.out.println("Escaped in " + (temp[3] + 1) + " minute(s).");
                            continue x;
                        }
                        queue.add(new int[]{newZ, newY, newX, temp[3] + 1});
                        visited[newZ][newY][newX] = 1;
                    }
                }
            }

            System.out.println("Trapped!");
            continue x;
        }
    }
}
