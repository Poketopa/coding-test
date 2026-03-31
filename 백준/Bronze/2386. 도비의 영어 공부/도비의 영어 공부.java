import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        List<Character> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        while(true){
            String input = br.readLine();
            Character a = input.charAt(0);
            if(a == '#'){
                break;
            }
            list.add(a);
            for(int i=1;i<input.length();i++){
                if(input.charAt(i) < a){
                    if(input.charAt(i) + ('a' - 'A') == a){
                        map.put(a, map.getOrDefault(a, 0) + 1);
                    }
                } else {
                    if(input.charAt(i) == a){
                        map.put(a, map.getOrDefault(a, 0) + 1);
                    }
                }
            }
        }
        for(Character a : list){
            System.out.println(a + " " + map.getOrDefault(a, 0));
        }
    }
}
