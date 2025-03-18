

import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int column = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int[][] map = new int[column][row];
        int[][] clone = new int[column][row];
        for(int i=0;i<column;i++){
            String str = br.readLine();
            for(int j=0;j<row;j++) {
                map[i][j] = str.charAt(j) - '0';
                clone[i][j] = map[i][j];
            }
        }
        int[] y = new int[]{1, -1, 0, 0};
        int[] x = new int[]{0, 0, 1, -1};
        Queue<int[]> queue = new LinkedList<>();
        HashMap<Integer, Integer> hash = new HashMap<>();
        int[][] visited = new int[column][row];
        int count = 2;
        for(int i=0;i<column;i++){
            for(int j=0;j<row;j++){
                if(clone[i][j] == 0){
                    int many = 0;
                    queue.add(new int[]{i, j});
                    visited[i][j] = 1;
                    while(!queue.isEmpty()){
                        int[] temp = queue.poll();
                        many++;
                        clone[temp[0]][temp[1]] = count;
                        for(int k=0;k<4;k++){
                            int newY = temp[0] + y[k];
                            int newX = temp[1] + x[k];
                            if(0<=newY && newY<column
                             &&0<=newX && newX<row
                             &&clone[newY][newX] == 0
                             &&visited[newY][newX] == 0){
                                visited[newY][newX] = 1;
                                queue.add(new int[]{newY, newX});
                            }
                        }
                    }
                    hash.put(count, many);
                    count++;

                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int i=0;i<column;i++){
            for(int j=0;j<row;j++){
                if(map[i][j] == 1){
                    set.clear();
                    for(int k=0;k<4;k++){
                        int newY = i + y[k];
                        int newX = j + x[k];
                        if(0<=newY && newY<column
                         &&0<=newX && newX<row
                         &&map[newY][newX] == 0){
                            set.add(clone[newY][newX]);
                        }
                    }
                    for(int k : set){
                        map[i][j] += hash.getOrDefault(k, 0);
                    }
                    map[i][j] %= 10;
                }
            }
        }




        for (int i = 0; i < column; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < row; j++) {
                sb.append(map[i][j]); // 한 줄을 먼저 만든 후
            }
            bw.write(sb.toString()); // 한 번에 출력
            bw.newLine();
        }
        bw.flush(); // 출력 버퍼 비우기
        bw.close(); // BufferedWriter 닫기
    }
}
