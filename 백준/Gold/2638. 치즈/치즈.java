
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int column = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int[][] map = new int[column][row];
        int[][] delete = new int[column][row];
        for(int i=0;i<column;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0;j<row;j++) map[i][j] = Integer.parseInt(st2.nextToken());
        }
        int[] y = new int[]{1, -1, 0, 0};
        int[] x = new int[]{0, 0, 1, -1};
        Queue<int[]> cheese = new LinkedList<>();
        Queue<int[]> queue = new LinkedList<>();
        int answer = 0;
        x :while(true){
            for(int i=0;i<column;i++) Arrays.fill(delete[i], 0);
            queue.add(new int[]{0, 0});
            delete[0][0] = 1;
            while(!queue.isEmpty()){
                int[]temp = queue.poll();
                for(int i=0;i<4;i++){
                    int newY = temp[0] + y[i];
                    int newX = temp[1] + x[i];
                    if(0<=newY && newY<column
                     &&0<=newX && newX<row
                     &&map[newY][newX] == 0
                     &&delete[newY][newX] == 0) {
                        delete[newY][newX] = 1;
                        queue.add(new int[]{newY, newX});
                    }
                }
            }


            boolean flag = true;
            for(int i=0;i<column;i++){
                for(int j=0;j<row;j++){
                    if(map[i][j] == 1){
                        flag = false;
                        int count = 0;
                        for(int k=0;k<4;k++){
                            int newY = i + y[k];
                            int newX = j + x[k];
                            if(0<=newY && newY<column
                             &&0<=newX && newX<row
                             &&delete[newY][newX] == 1) count++;
                        }
                        if(count > 1) cheese.add(new int[]{i, j});
                    }
                }
            }
            if(flag) break x;
            while(!cheese.isEmpty()){
                int[] temp = cheese.poll();
                map[temp[0]][temp[1]] = 0;
            }
            answer++;
        }
        System.out.println(answer);
    }
}