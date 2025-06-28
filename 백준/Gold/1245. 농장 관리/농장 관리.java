import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        int[][] map = new int[row][column];
        int[][] visited = new int[row][column];
        for(int i=0;i<row;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0;j<column;j++){
                map[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        int count = 0;
        int[] y = {0, 1, -1};
        int[] x = {0, 1, -1};
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(visited[i][j] == 1) continue;
                // 주변에서 가장 높은가?
                if(check(map, i, j)){
                    boolean flag = false;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{map[i][j], i, j});
                    while(!queue.isEmpty()){
                        int[] temp = queue.poll();
                        if(!check(map, temp[1], temp[2])) flag = true;
                        visited[temp[1]][temp[2]] = 1;
                        for(int k=0;k<3;k++){
                            for(int l=0;l<3;l++){
                                if(y[k] == 0 && x[l] == 0) continue;
                                int newY = temp[1] + y[k];
                                int newX = temp[2] + x[l];
                                if(0<=newY && newY < map.length
                                && 0<=newX && newX < map[0].length){
                                    if(map[newY][newX] == temp[0] && visited[newY][newX] == 0) {
                                        queue.add(new int[]{map[newY][newX], newY, newX});
                                    }
                                }
                            }
                        }
                    }
                    if(!flag) count++;
                }
            }
        }
        System.out.println(count);

    }
    public static boolean check(int[][] map, int row, int column){
        int[] y = {1, 0, -1};
        int[] x = {1, 0, -1};
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(y[i] == 0 && x[j] == 0) continue;
                int nowY = row + y[i];
                int nowX = column + x[j];
                if(0<=nowY && nowY < map.length
                && 0<=nowX && nowX < map[0].length){
                    if(map[nowY][nowX] > map[row][column]) return false;
                }
            }
        }
        return true;
    }
}