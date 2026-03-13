import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<input;i++){
            String temp = br.readLine();
            int mul = 1;
            for(int j=temp.length()-1;j>=0;j--){
                map.put(temp.charAt(j), map.getOrDefault(temp.charAt(j), 0) + mul);
                mul *= 10;
            }
        }
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a ,b) -> {
            return map.get(b) - map.get(a);
        });
        int mul = 9;
        int sum = 0;
        for(char i : list){
            sum += map.get(i) * mul;
            mul--;
        }
        System.out.print(sum);
    }
}
