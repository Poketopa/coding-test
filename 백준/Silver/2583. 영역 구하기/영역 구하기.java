import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        int input = Integer.parseInt(st.nextToken());

        int[][] map = new int[row][column];
        for(int i=0;i<input;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int downX = Integer.parseInt(st2.nextToken());
            int downY = Integer.parseInt(st2.nextToken());
            int upX = Integer.parseInt(st2.nextToken());
            int upY = Integer.parseInt(st2.nextToken());
            for(int j=downY;j<upY;j++){
                for(int k=downX;k<upX;k++){
                    map[j][k] = 1;
                }
            }
        }

        int count = 0;
        int[] y = new int[]{1, -1, 0, 0};
        int[] x = new int[]{0, 0, 1, -1};
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(map[i][j] == 1) continue;
                count++;
                int sum = 1;
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i, j});
                map[i][j] = 1;
                while(!queue.isEmpty()){
                    int[] temp = queue.poll();
                    for(int k=0;k<4;k++){
                        int newY = temp[0] + y[k];
                        int newX = temp[1] + x[k];
                        if(0 <= newY && newY < row
                        && 0 <= newX && newX < column
                        && map[newY][newX] == 0) {
                            queue.add(new int[]{newY, newX});
                            map[newY][newX] = 1;
                            sum+=1;
                        }
                    }
                }
                list.add(sum);
            }
        }
        Collections.sort(list);

        System.out.println(count);
        for(int i : list){
            System.out.print(i + " ");
        }
    }
}
