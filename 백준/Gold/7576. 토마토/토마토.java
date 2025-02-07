import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.valueOf(st.nextToken());
        int column = Integer.valueOf(st.nextToken());
        int[][] tomato = new int[column][row];
        int howManyTomato = 0;
        List<int[]> whereIsTomato = new ArrayList<>();
        for(int i=0;i<column;i++){
            StringTokenizer toma = new StringTokenizer(br.readLine());
            for(int j=0;j<row;j++){
                tomato[i][j] = Integer.valueOf(toma.nextToken());
                if(tomato[i][j] == 1) {
                    whereIsTomato.add(new int[]{i,j});
                    tomato[i][j] = 0;
                }
                if(tomato[i][j] != -1) howManyTomato++;
            }
        }
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};
        int tomatoCount = 0;
        int date = 0;
        int dateMax = -1;
        // 토마토 좌표
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<whereIsTomato.size();i++){
            queue.add(new int[]{whereIsTomato.get(i)[0], whereIsTomato.get(i)[1], date});
        }

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            if(tomato[temp[0]][temp[1]] == 1) continue;
            tomato[temp[0]][temp[1]] = 1;
            if(temp[2] > dateMax) dateMax = temp[2];
            tomatoCount++;

            for(int i=0;i<4;i++){
                int nextY = temp[0] + y[i];
                int nextX = temp[1] + x[i];
                if(0<=nextY && nextY<tomato.length && 0<=nextX & nextX<tomato[0].length && tomato[nextY][nextX] == 0){
                    queue.add(new int[]{nextY, nextX, temp[2]+1});
                }
            }

        }
        if(tomatoCount == howManyTomato) System.out.println(dateMax);
        else System.out.println("-1");
    }
}