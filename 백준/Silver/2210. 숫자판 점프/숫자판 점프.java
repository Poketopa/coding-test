import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] map = new int[5][5];
        int[] y = {1, -1, 0, 0};
        int[] x = {0, 0, 1, -1};
        for(int i=0;i<5;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        Set<String> set = new HashSet<>();
        Queue<Object[]> queue = new LinkedList<>();
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                queue.add(new Object[]{i, j, new String(String.valueOf(map[i][j]))});
                while(!queue.isEmpty()){
                    Object[] temp = queue.poll();
                    if(temp[2].toString().length() == 6){
                        set.add((String)temp[2]);
                        continue;
                    }
                    for(int k=0;k<4;k++){
                        int newY = (int)temp[0] + y[k];
                        int newX = (int)temp[1] + x[k];
                        if(0 <= newY && newY < 5
                        && 0 <= newX && newX < 5) {
                            queue.add(new Object[]{newY, newX, new String(temp[2] + String.valueOf(map[newY][newX]))});
                        }
                    }
                }
            }
        }
        System.out.print(set.size());
    }
}
