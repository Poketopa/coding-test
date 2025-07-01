import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int numberInput = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        int[] number = new int[numberInput];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<numberInput;i++){
            number[i] = Integer.parseInt(st.nextToken());
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<numberInput;i++){
            map.put(number[i], map.getOrDefault(number[i], 0) + 1);
        }
        int count = 0;
        for(int i=0;i<numberInput;i++){
            if(!map.containsKey(number[i])) continue;
            if(map.get(number[i]) == 0) continue;
            if(!map.containsKey(target-number[i])) continue;
            if(map.get(target-number[i]) == 0) continue;
            if(number[i] == target - number[i]){
                if(map.get(number[i]) <= 1) continue;
            }
            count++;
            map.put(number[i], map.get(number[i]) - 1);
            map.put(target - number[i], map.get(target - number[i])-1);
        }
        System.out.println(count);
    }
}