import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] bingo = new int[5][5];
        Map<Integer, int[]> map = new HashMap<>();

        for(int i=0;i<5;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                map.put(Integer.parseInt(st.nextToken()), new int[] {i, j});
            }
        }
        int count = 0;

        for(int i=0;i<5;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                count++;
                int temp = Integer.parseInt(st.nextToken());
                bingo[map.get(temp)[0]][map.get(temp)[1]] = 1;
                if(checkBingo(bingo)){
                    System.out.println(count);
                    return;
                }
            }
        }
    }
    public static boolean checkBingo(int[][] bingo){
        int count = 0;
        for(int i=0;i<5;i++){
            boolean flag = true;
            for(int j=0;j<5;j++){
                if(bingo[i][j] == 0) flag = false;
            }
            if(flag) count++;
        }

        for(int i=0;i<5;i++){
            boolean flag = true;
            for(int j=0;j<5;j++){
                if(bingo[j][i] == 0) flag = false;
            }
            if(flag) count++;
        }

        if(bingo[0][0] == 1 && bingo[1][1] == 1 && bingo[2][2] == 1 && bingo[3][3] == 1 && bingo[4][4] == 1) count++;
        if(bingo[0][4] == 1 && bingo[1][3] == 1 && bingo[2][2] == 1 && bingo[3][1] == 1 && bingo[4][0] == 1) count++;

        if(count >= 3) return true;
        else return false;
    }
}
