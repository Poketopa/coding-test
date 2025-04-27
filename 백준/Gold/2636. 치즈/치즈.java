import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int column = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int[][] map = new int[column][row];
        int time = 1;
        int[] prevCheese = new int[2];
        Set<int[]> set = new HashSet<>();
        for(int i=0;i<column;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0;j<row;j++){
                int temp = Integer.parseInt(st2.nextToken());
                map[i][j] = temp;
                if(temp == 1) set.add(new int[]{i, j});
            }
        }
        int gas = 2;
        Queue<int[]> queue = new LinkedList<>();
        int[] y = {0, 0, 1, -1};
        int[] x = {1, -1, 0, 0};

        while(true){
            int cheeseCount = 0;
            // 왼쪽 위부터 BFS 시행,
            queue.add(new int[]{0, 0});
            int[][] visited = new int[column][row];
            for(int i=0;i<visited.length;i++) Arrays.fill(visited[i], 0);
            while(!queue.isEmpty()){
                int[] temp = queue.poll();
                map[temp[0]][temp[1]] = gas;
                for(int i=0;i<4;i++){
                    int newY = temp[0] + y[i];
                    int newX = temp[1] + x[i];
                    if(0 <= newY && newY < map.length
                            && 0 <= newX && newX < map[0].length
                            && map[newY][newX] != 1
                            && visited[newY][newX] == 0){
                        visited[newY][newX] = 1;
                        queue.add(new int[]{newY, newX});
                    }
                }
            }
            List<int[]> list = new ArrayList<>(set);
            cheeseCount =  list.size();
            for(int j = 0;j<list.size();j++){
                int[] temp = list.get(j);
                for(int i=0;i<4;i++) {
                    int newY = temp[0] + y[i];
                    int newX = temp[1] + x[i];
                    if (0 <= newY && newY < map.length
                            && 0 <= newX && newX < map[0].length
                            && map[newY][newX] == gas) {
                        set.remove(temp);
                        map[temp[0]][temp[1]] = 0;
                        break;
                    }
                }
            }
            if(set.isEmpty()){
                System.out.println(time);
                System.out.println(cheeseCount);
                return;
            }
            time++;
            gas++;
        }

    }
}