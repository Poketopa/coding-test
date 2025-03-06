

import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int column = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int[] y = new int[]{1, -1, 0, 0};
        int[] x = new int[]{0, 0, 1, -1};
        List<int[]> virus = new ArrayList<>();
        int[][] map = new int[column][row];
        int countZero = 0;
        for(int i=0;i<column;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0;j<row;j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
                if(map[i][j] == 2) virus.add(new int[]{i, j});
                if(map[i][j] == 0) countZero++;
            }
        }
        // 난수 발생
        List<Integer> list = new ArrayList<>();
        int[] number = new int[column * row];
        for(int i=0;i<number.length;i++) number[i] = i;
        for(int i=0;i<number.length;i++){
            if(map[i/row][i%row] != 0) continue;
            dfs(number, 3, list, i, column, row, virus, map, y, x);
        }
        System.out.println(countZero - min - 3);
    }

    private static void dfs(int[] number, int length, List<Integer> list, int now, int column, int row, List<int[]> virus, int[][] map, int[]y, int[]x){
        list.add(number[now]);
        if(list.size() == length){
            test(column, row, virus, y, x, map, list);
            list.remove(list.size()-1);
            return;
        }

        for(int i=now+1;i<number.length;i++){
            if(map[i/row][i%row] != 0) continue;
            dfs(number, 3, list, i, column, row, virus, map, y, x);
        }
        list.remove(list.size()-1);
    }

    private static void test(int column, int row, List<int[]> virus, int[] y, int[] x, int[][] map, List<Integer> list){
        for(int i=0;i<list.size();i++){
            map[list.get(i)/row][list.get(i)%row] = 1;
        }
        int[][] visited = new int[column][row];
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<virus.size();i++) queue.add(virus.get(i));
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            for(int i=0;i<4;i++){
                int newY = temp[0] + y[i];
                int newX = temp[1] + x[i];
                if(0<=newY && newY<column
                        && 0<=newX && newX<row
                        && map[newY][newX] == 0
                        && visited[newY][newX] == 0){
                    queue.add(new int[]{newY, newX});
                    count++;
                    visited[newY][newX] = 1;
                }
            }
        }
        for(int i=0;i<list.size();i++){
            map[list.get(i)/row][list.get(i)%row] = 0;
        }
        min = Math.min(min, count);
    }
}
