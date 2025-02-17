
import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[][] map = new int[input][input];
        for(int i=0;i<input;i++){
            String temp = br.readLine();
            for(int j=0;j<input;j++){
                map[i][j] = Integer.valueOf(temp.charAt(j)-'0');
            }
        }
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<input;i++){
            for(int j=0;j<input;j++){
                if(map[i][j] == 1){
                    Queue<int[]> queue = new LinkedList<>();
                    int count = 1;
                    queue.add(new int[]{i, j});
                    map[i][j] = 0;
                    while(!queue.isEmpty()){
                        int[] temp = queue.poll();
                        for(int k=0;k<4;k++){
                            int newY = temp[0]+y[k];
                            int newX = temp[1]+x[k];
                            if(0<=newY&&0<=newX
                            && newY<input&&newX<input
                            && map[newY][newX] == 1){
                                map[newY][newX] = 0;
                                count++;
                                queue.add(new int[]{newY, newX});
                            }
                        }
                    }
                    list.add(count);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }
}