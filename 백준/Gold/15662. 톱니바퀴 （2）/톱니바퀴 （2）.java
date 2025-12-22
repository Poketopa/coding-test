import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        int[][] gear = new int[input][8];
        for(int i=0;i<input;i++){
            String[] temp = br.readLine().split("");
            for(int j=0;j<8;j++){
                gear[i][j] = Integer.parseInt(temp[j]);
            }
        }
        int action = Integer.parseInt(br.readLine());
        for(int i=0;i<action;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken()); // 1: 시계방향 / 2: 반시계방향
            if(direction == -1 ) direction = 2;
            turnGear(number - 1, direction, gear);
        }
        int count = 0;
        for(int i=0;i<input;i++) if(gear[i][0] == 1) count++;
        System.out.print(count);
    }

    public static void turnGear(int index, int direction, int[][] gear){
        boolean leftFlag = false;
        boolean rightFlag = false;
        if(index != 0 && gear[index][6] != gear[index -1][2]) leftFlag = true;
        if(index != gear.length-1 && gear[index][2] != gear[index + 1][6]) rightFlag = true;

        if(direction == 1){
            int temp = gear[index][7];
            for(int i=7;i>=1;i--) gear[index][i] = gear[index][i-1];
            gear[index][0] = temp;
        } else{
            int temp = gear[index][0];
            for(int i=0;i<7;i++) gear[index][i] = gear[index][i+1];
            gear[index][7] = temp;
        }
        if(direction == 1 && leftFlag){
            left(index - 1, 2, gear);
        }
        else if(direction == 2 && leftFlag){
            left(index - 1, 1, gear);
        }
        if(direction == 1 && rightFlag){
            right(index + 1, 2, gear);
        }
        else if(direction == 2 && rightFlag){
            right(index + 1, 1, gear);
        }
    }

    public static void left(int index, int direction, int[][] gear){
        boolean turningFlag = false;
        if(index != 0 && gear[index][6] != gear[index -1][2]) turningFlag = true;

        if(direction == 1){
            int temp = gear[index][7];
            for(int i=7;i>=1;i--) gear[index][i] = gear[index][i-1];
            gear[index][0] = temp;
        } else{
            int temp = gear[index][0];
            for(int i=0;i<7;i++) gear[index][i] = gear[index][i+1];
            gear[index][7] = temp;
        }


        if(direction == 1 && turningFlag){
            left(index - 1, 2, gear);
        }
        else if(direction == 2 && turningFlag){
            left(index - 1, 1, gear);
        }
    }

    public static void right(int index, int direction, int[][] gear){
        boolean turningFlag = false;
        if(index != gear.length-1 && gear[index][2] != gear[index + 1][6]) turningFlag = true;

        if(direction == 1){
            int temp = gear[index][7];
            for(int i=7;i>=1;i--) gear[index][i] = gear[index][i-1];
            gear[index][0] = temp;
        } else{
            int temp = gear[index][0];
            for(int i=0;i<7;i++) gear[index][i] = gear[index][i+1];
            gear[index][7] = temp;
        }


        if(direction == 1 && turningFlag){
            right(index + 1, 2, gear);
        }
        else if(direction == 2 && turningFlag){
            right(index + 1, 1, gear);
        }
    }
}
