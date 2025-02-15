

import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        int column = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        String[][] map = new String[column][row];
        for(int i=0;i<column;i++){
            map[i] = br.readLine().split("");
        }
        int[] start = new int[2];
        x:
        for(int i=0;i<column;i++){
            for(int j=0;j<row;j++){
                if(map[i][j].equals("I")){
                    start[0] = i;
                    start[1] = j;
                    break x;
                }
            }
        }
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};
        int[][] visited = new int[column][row];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = 1;

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            for(int i=0;i<4;i++){
                int newY = temp[0] + y[i];
                int newX = temp[1] + x[i];
                if(0<=newY && 0<=newX
                && newY<column && newX<row
                && (map[newY][newX].equals("O") || map[newY][newX].equals("P"))
                && visited[newY][newX] == 0){
                    if(map[newY][newX].equals("P")) count++;
                    visited[newY][newX] = 1;
                    queue.add(new int[]{newY, newX});
                }
            }
        }
        if(count == 0) System.out.println("TT");
        else System.out.println(count);
    }
}