import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        int unitRow = Integer.parseInt(st.nextToken());
        int unitColumn = Integer.parseInt(st.nextToken());
        int obstacle = Integer.parseInt(st.nextToken());

        int[][] map = new int[row][column];
        for(int i=0;i<obstacle;i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st2.nextToken()) - 1;
            int x = Integer.parseInt(st2.nextToken()) - 1;
            map[y][x]  = 1;
        }
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        StringTokenizer st4 = new StringTokenizer(br.readLine());

        int startY = Integer.parseInt(st3.nextToken()) - 1;
        int startX = Integer.parseInt(st3.nextToken()) - 1;
        int endY = Integer.parseInt(st4.nextToken()) - 1;
        int endX = Integer.parseInt(st4.nextToken()) - 1;

        int[][] visited = new int[row][column];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startY, startX, 0});
        visited[startY][startX] = 1;

        int[] y = new int[]{1, -1, 0, 0};
        int[] x = new int[]{0, 0, 1, -1};

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            if(temp[0] == endY && temp[1] == endX){
                System.out.print(temp[2]);
                return;
            }
            for(int i=0;i<4;i++){
                int newY = temp[0] + y[i];
                int newX = temp[1] + x[i];


                try{
                    check(map, visited, newY, newX, unitRow, unitColumn);
                } catch (ArrayIndexOutOfBoundsException e){
                    continue;
                }

                queue.add(new int[]{newY, newX, temp[2] + 1});
                visited[newY][newX] = 1;
            }
        }
        System.out.print("-1");
    }
    public static void check(int[][] map, int[][] visited, int y, int x, int unitRow, int unitColumn){
        if(visited[y][x] == 1) throw new ArrayIndexOutOfBoundsException();
        for(int i=y;i<y + unitRow;i++){
            for(int j=x;j<x+unitColumn;j++){
                if(map[i][j] == 1){
                    throw new ArrayIndexOutOfBoundsException();
                }
            }
        }

    }
}
