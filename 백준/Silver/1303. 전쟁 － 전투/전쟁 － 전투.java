import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int column = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());

        int[][] map = new int[row][column];
        for(int i=0;i<row;i++){
            String temp = br.readLine();
            for(int j=0;j<column;j++){
                char a = temp.charAt(j);
                if(a == 'W') map[i][j] = 1;
                else map[i][j] = 2;
            }
        }

        int[] y = new int[]{1, -1, 0, 0};
        int[] x = new int[]{0, 0 ,1, -1};

        int sumA = 0;
        int sumB = 0;
        int[][] visited = new int[row][column];
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(visited[i][j] == 1) continue;

                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i, j});
                visited[i][j] = 1;
                int now = map[i][j];
                int count = 0;

                while(!queue.isEmpty()){
                    count++;
                    int[] temp = queue.poll();
                    for(int k=0;k<4;k++){
                        int newY = temp[0] + y[k];
                        int newX = temp[1] + x[k];

                        if(0 <= newY && newY < row
                        && 0 <= newX && newX < column
                        && map[newY][newX] == now
                        && visited[newY][newX] == 0){
                            queue.add(new int[]{newY, newX});
                            visited[newY][newX] = 1;
                        }
                    }
                }

                if(now == 1) sumA += count * count;
                else sumB += count * count;
            }
        }
        System.out.print(sumA + " " + sumB);
    }
}
