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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        List<Integer> number = new ArrayList<>();
        Map<Integer, Integer> whenAppears = new HashMap<>();
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int count = 1;
        for(int i=0;i<N;i++) {
            int temp = Integer.parseInt(st2.nextToken());
            number.add(temp);
            if(!whenAppears.containsKey(temp)){
                whenAppears.put(temp, count);
                count++;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : number) map.put(i, map.getOrDefault(i, 0) + 1);
        Collections.sort(number, (a, b) -> {
            if(map.get(a).equals(map.get(b))){
                return Integer.compare(whenAppears.get(a),whenAppears.get(b));
            }
            else return Integer.compare(map.get(b), map.get(a));
        });
        for(int i : number) System.out.print(i + " ");
    }
}






