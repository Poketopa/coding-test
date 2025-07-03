import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, Integer> valueMap = new HashMap<>();
        Map<String, Integer> mulMap = new HashMap<>();
        valueMap.put("black" , 0);
        mulMap.put("black", 1);
        valueMap.put("brown" , 1);
        mulMap.put("brown", 10);
        valueMap.put("red" , 2);
        mulMap.put("red", 100);
        valueMap.put("orange" , 3);
        mulMap.put("orange", 1000);
        valueMap.put("yellow" , 4);
        mulMap.put("yellow", 10000);
        valueMap.put("green" , 5);
        mulMap.put("green", 100000);
        valueMap.put("blue" , 6);
        mulMap.put("blue", 1000000);
        valueMap.put("violet" , 7);
        mulMap.put("violet", 10000000);
        valueMap.put("grey" , 8);
        mulMap.put("grey", 100000000);
        valueMap.put("white" , 9);
        mulMap.put("white", 1000000000);
        String first = br.readLine();
        String second = br.readLine();
        String third = br.readLine();
        long answer = 0;
        answer += valueMap.get(first) * 10;
        answer += valueMap.get(second);
        answer *= mulMap.get(third);
        System.out.println(answer);
    }
}