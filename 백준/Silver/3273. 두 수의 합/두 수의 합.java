import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        int[] number = new int[input];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<input;i++) number[i] = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(br.readLine());
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<input;i++){
            if(map.containsKey(target - number[i])){
                count += map.get(target - number[i]);
            }
            map.put(number[i], map.getOrDefault(number[i], 0) + 1);
        }
        System.out.print(count);
    }
}
