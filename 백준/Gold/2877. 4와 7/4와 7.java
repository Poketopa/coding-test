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
        StringBuilder answer = new StringBuilder("");
        int now = 0;
        int addNum = 2;

        while(!(now <= input) || !(input <= now + addNum)){
            now += addNum;
            addNum *= 2;
        }
        // addNum /= 2;

        // now + (addNum / 2)를 넘으면 7, 안넘으면 4
        // input -= addNum으로 다음 수 찾기
        // now -= addNum, addNum /= 2;
        while(addNum > 1){
            if(now + (addNum / 2) < input){
                answer.append(7);
                now += (addNum / 2);
            } else answer.append(4);
            addNum /= 2;

        }
        System.out.print(answer);
    }
}
