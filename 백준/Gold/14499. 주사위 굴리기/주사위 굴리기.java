import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        int nowY = Integer.parseInt(st.nextToken());
        int nowX = Integer.parseInt(st.nextToken());
        int command = Integer.parseInt(st.nextToken());

        int[][] map = new int[row][column];
        for(int i=0;i<row;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0;j<column;j++){
                map[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        int[] dice = new int[7];
        // 1: bottom
        // 2: 위
        // 3: 오른쪽
        // 4: 왼쪽
        // 5: 아래
        // 6: top

        StringTokenizer st3 = new StringTokenizer(br.readLine());
        int length = st3.countTokens();
        for(int i=0;i<length;i++){
            int move = Integer.parseInt(st3.nextToken());
            try{
                getMoveY(row, nowY, move);
                getMoveX(column, nowX, move);
            } catch(IndexOutOfBoundsException e){
                continue;
            }
            nowY += getMoveY(row, nowY, move);
            nowX += getMoveX(column, nowX, move);
            move(move, dice);
            if(map[nowY][nowX]  == 0) map[nowY][nowX] = dice[1];
            else {
                dice[1] = map[nowY][nowX];
                map[nowY][nowX] = 0;
            }

            System.out.println(dice[6]);
        }
    }

    public static int getMoveY(int length, int now, int move){
        if(move == 1) return 0;
        if(move == 2) return 0;
        if(move == 3){
            if(now == 0) {
                throw new IndexOutOfBoundsException();
            }
            return -1;
        }
        if(now == length - 1){
            throw new IndexOutOfBoundsException();
        }
        return 1;
    }

    public static int getMoveX(int length, int now, int move){
        if(move == 1){
            if(now == length - 1){
                throw new IndexOutOfBoundsException();
            }
            return 1;
        }
        if(move == 2){
            if(now == 0){
                throw new IndexOutOfBoundsException();
            }
            return -1;
        }
        return 0;
    }

    public static void move(int move, int[] dice){
        if(move == 1){
            int temp = dice[6];
            dice[6] = dice[4];
            dice[4] = dice[1];
            dice[1] = dice[3];
            dice[3] = temp;
        }
        if(move == 2){
            int temp = dice[6];
            dice[6] = dice[3];
            dice[3] = dice[1];
            dice[1] = dice[4];
            dice[4] = temp;
        }
        if(move == 3){
            int temp = dice[6];
            dice[6] = dice[5];
            dice[5] = dice[1];
            dice[1] = dice[2];
            dice[2] = temp;
        }
        if(move == 4){
            int temp = dice[6];
            dice[6] = dice[2];
            dice[2] = dice[1];
            dice[1] = dice[5];
            dice[5] = temp;
        }
    }
}
