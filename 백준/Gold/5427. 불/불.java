import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        int[]y = {1, -1, 0, 0};
        int[]x = {0, 0, 1, -1};

        x:for(int repeat=0;repeat<input;repeat++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int column = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            Queue<int[]> fire = new LinkedList<>();
            Queue<int[]> man = new LinkedList<>();
            String[][] map = new String[row][column];
            int[][] visited = new int[row][column];
            for(int i=0;i<row;i++){
                String temp = br.readLine();
                for(int j=0;j<temp.length();j++){
                    map[i][j] = String.valueOf(temp.charAt(j));
                    if(map[i][j].equals("*")) fire.add(new int[]{i, j, 0});
                    if(map[i][j].equals("@")) {
                        man.add(new int[]{i, j, 0});
                        visited[i][j] = 1;
                    }
                }
            }
            while(!fire.isEmpty() || !man.isEmpty()){
                // 불 시작
                int fireSize = fire.size();
                for(int i=0;i<fireSize;i++){
                    int[] temp = fire.poll();
                    for(int j=0;j<4;j++){
                        int newY = temp[0] + y[j];
                        int newX = temp[1] + x[j];
                        if(0 <= newY && newY < row
                            && 0 <= newX && newX < column
                            && (map[newY][newX].equals(".") || map[newY][newX].equals("@"))){
                            map[newY][newX] = "*";
                            fire.add(new int[]{newY, newX, temp[2] + 1});
                        }
                    }
                }
                // 사람 시작
                int manSize = man.size();
                for(int i=0;i<manSize;i++){
                    int[] temp = man.poll();
                    if(temp[0] == 0 || temp[1] == 0
                    || temp[0] == row - 1 || temp[1] == column - 1){
                        System.out.println(temp[2] + 1);
                        continue x;
                    }
                    for(int j=0;j<4;j++){
                        int newY = temp[0] + y[j];
                        int newX = temp[1] + x[j];
                        if(0 <= newY && newY < row
                            && 0 <= newX && newX < column
                            && (map[newY][newX].equals(".") || map[newY][newX].equals("@"))
                        && visited[newY][newX] == 0){
                            man.add(new int[]{newY, newX, temp[2] + 1});
                            visited[newY][newX] = 1;
                        }
                    }
                }
            }
            System.out.println("IMPOSSIBLE");
        }
    }
}
