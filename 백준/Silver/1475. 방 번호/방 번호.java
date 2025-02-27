
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<9;i++) map.put(i, 0);
        // 9는 배제
        while(input > 0){
            int temp = input % 10;
            if(temp == 9){
                map.put(6, map.get(6)+1);
            }
            else map.put(temp, map.get(temp)+1);
            input /= 10;
        }
        map.put(6, (map.get(6) +1)/2);
        int max = -1;

        for(int i=0;i<9;i++){
            if(max < map.get(i)) {
                max = map.get(i);
            }
        }

        System.out.println(max);
    }
}
