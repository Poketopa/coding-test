import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        int[][] dices = new int[input][6];

        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<6;j++) dices[i][j] = Integer.parseInt(st.nextToken());
        }

        map.put(0, 5);
        map.put(1, 3);
        map.put(2, 4);
        map.put(3, 1);
        map.put(4, 2);
        map.put(5, 0);

        int max = Integer.MIN_VALUE;

        for(int i=0;i<6;i++){
            int sum = 0;
            sum += nextDice(dices[0][i], dices, 0, dices[0][map.get(i)]);
            // 1. 주사위 아래에 적힌 숫자
            // 2. 주사위 배열
            // 3. 현재 몇번째 주사위인지
            // 4. 주사위 위에 적힌 숫자
            max = Math.max(sum, max);
        }

        System.out.print(max);
    }

    public static int nextDice(int downNumber, int[][] dices, int nowIndex, int upNumber){
        int nowSum = 0;
        if((upNumber == 6 && downNumber == 5) || (upNumber == 5 && downNumber == 6)) nowSum += 4;
        else if(upNumber == 6 || downNumber == 6) nowSum += 5;
        else nowSum += 6;

        if(nowIndex == dices.length - 1) return nowSum;
        else {
            int nextDownNumberIndex = 0;
            for(int i=0;i<6;i++){
                if(dices[nowIndex + 1][i] == upNumber) nextDownNumberIndex = i;
            }
            int nextDownNumber = dices[nowIndex + 1][nextDownNumberIndex];
            int nextUpNumber = dices[nowIndex + 1][map.get(nextDownNumberIndex)];
            return nowSum + nextDice(nextDownNumber, dices, nowIndex + 1, nextUpNumber);
        }
    }
}
