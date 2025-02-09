import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        // 1. visited 배열 만들기 (배추밭 똑같이 카피)
        // 2. 2중포문으로 하나씩 돌면서 1이면 bfs로 모든 영역 visited = 0, count++
        int xx[] = new int[]{1, -1, 0, 0};
        int yy[] = new int[]{0, 0, 1, -1};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.valueOf(br.readLine());
        
        for(int repeat = 0;repeat<testCase;repeat++){
            int worm = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.valueOf(st.nextToken()); int n = Integer.valueOf(st.nextToken()); int howManyKimchi = Integer.valueOf(st.nextToken());
            int[][] kimchiFarm = new int[n][m];
            for(int i=0;i<howManyKimchi;i++){
                StringTokenizer kim = new StringTokenizer(br.readLine());
                int x = Integer.valueOf(kim.nextToken());
                int y = Integer.valueOf(kim.nextToken());
                kimchiFarm[y][x] = 1;
            }
            Queue<int[]> queue = new LinkedList<>();
            // 2중포문 시작
            for(int i=0;i<kimchiFarm.length;i++){
                for(int j=0;j<kimchiFarm[0].length;j++){
                    // 배추 발견
                    if(kimchiFarm[i][j] == 1){
                        worm++;
                        queue.add(new int[]{i, j});
                        kimchiFarm[i][j] = 0;
                        while(!queue.isEmpty()){
                            int[] temp = queue.poll();
                            for(int k=0;k<4;k++){
                                int newY = temp[0] + yy[k];
                                int newX = temp[1] + xx[k];
                                if(0<=newY && newY <kimchiFarm.length
                                  &&0<=newX && newX < kimchiFarm[0].length
                                  && kimchiFarm[newY][newX] == 1){
                                    kimchiFarm[newY][newX] = 0;
                                    queue.add(new int[]{newY, newX});
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(worm);
        }
    }
}