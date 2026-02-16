import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int column = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());

        int[][] map = new int[row+2][column+2];
        for(int i=0;i<row;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0;j<column;j++){
                map[i+1][j+1] = Integer.parseInt(st2.nextToken());
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        map[0][0] = 2;

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int y = temp[0];
            int x = temp[1];

            try{
                if(y % 2 == 0){
                    if(y != 0 && x != 0 && map[y-1][x-1] == 0) {
                        map[y-1][x-1] = 2;
                        queue.add(new int[]{y-1, x-1});
                    }
                    if(y != 0 && map[y-1][x] == 0){
                        map[y-1][x] = 2;
                        queue.add(new int[]{y-1, x});
                    }
                    if(x != 0 && map[y][x-1] == 0){
                        map[y][x-1] = 2;
                        queue.add(new int[]{y, x-1});
                    }
                    if(x != map[0].length-1 && map[y][x+1] == 0){
                        map[y][x+1] = 2;
                        queue.add(new int[]{y, x+1});
                    }
                    if(y != map.length-1 && x != 0 && map[y+1][x-1] == 0) {
                        map[y+1][x-1] = 2;
                        queue.add(new int[]{y+1, x-1});
                    }
                    if(y != map.length-1 && map[y+1][x] == 0){
                        map[y+1][x] = 2;
                        queue.add(new int[]{y+1, x});
                    }
                } else {
                    if(y != 0 && map[y-1][x] == 0){
                        map[y-1][x] = 2;
                        queue.add(new int[]{y-1, x});
                    }
                    if(y != 0 && map[y-1][x+1] == 0){
                        map[y-1][x+1] = 2;
                        queue.add(new int[]{y-1, x+1});
                    }
                    if(x != 0 && map[y][x-1] == 0){
                        map[y][x-1] = 2;
                        queue.add(new int[]{y, x-1});
                    }
                    if(x != map[0].length-1 && map[y][x+1] == 0){
                        map[y][x+1] = 2;
                        queue.add(new int[]{y, x+1});
                    }
                    if(y != map.length-1 && map[y+1][x] == 0){
                        map[y+1][x] = 2;
                        queue.add(new int[]{y+1, x});
                    }
                    if(y != map.length-1 && map[y+1][x+1] == 0){
                        map[y+1][x+1] = 2;
                        queue.add(new int[]{y+1, x+1});
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e){
            }

        }

        int count = 0;

        for(int i=1;i<=row;i++){
            for(int j=1;j<=column;j++){
                if(map[i][j] == 1) count += countTwo(i, j, map);
            }
        }

        System.out.print(count);
    }

    public static int countTwo(int y, int x, int[][] map){
        int count = 0;
        if(y % 2 == 0){
            if(map[y-1][x-1] == 2) count++;
            if(map[y-1][x] == 2) count++;
            if(map[y][x-1] == 2) count++;
            if(map[y][x+1] == 2) count++;
            if(map[y+1][x-1] == 2) count++;
            if(map[y+1][x] == 2) count++;
        } else {
            if(map[y-1][x] == 2) count++;
            if(map[y-1][x+1] == 2) count++;
            if(map[y][x-1] == 2) count++;
            if(map[y][x+1] == 2) count++;
            if(map[y+1][x] == 2) count++;
            if(map[y+1][x+1] == 2) count++;
        }
        return count;
    }
}
