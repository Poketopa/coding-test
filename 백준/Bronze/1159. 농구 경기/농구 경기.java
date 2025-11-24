import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isPrime = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Character, Integer> map = new HashMap<>();
        int input = Integer.parseInt(br.readLine());
        for(char i = 'a';i<='z';i++) map.put(i, 0);
        for(int i=0;i<input;i++){
            String name = br.readLine();
            map.put(name.charAt(0), map.get(name.charAt(0)) + 1);
        }
        String answer = "";
        for(char i = 'a';i<='z';i++) if(map.get(i) >= 5) answer += i;
        if(answer.equals("")) System.out.print("PREDAJA");
        else System.out.print(answer);
    }
}
