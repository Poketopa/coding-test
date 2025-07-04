import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        String input = br.readLine();
        Map<Character, Integer> map = new HashMap<>();
        for(char i = 'a';i<='z';i++){
            map.put(i, 0);
        }
        for(int i=0;i<input.length();i++){
            map.put(input.charAt(i), map.get(input.charAt(i)) + 1);
        }
        for(char i = 'a';i<='z';i++){
            System.out.print(map.get(i)+" ");
        }
    }
}