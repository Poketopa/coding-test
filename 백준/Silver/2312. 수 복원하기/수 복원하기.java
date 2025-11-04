import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        int[] number = new int[input];
        for(int i=0;i<input;i++) number[i] = Integer.parseInt(br.readLine());
        for(int i=0;i<input;i++){
            Map<Integer, Integer> map = new HashMap<>();
            while(number[i] != 1){
                for(int j=2;j<=number[i];j++){
                    if(number[i] % j == 0){
                        map.put(j, map.getOrDefault(j, 0) + 1);
                        number[i] /= j;
                        break;
                    }
                }
            }
            List<Integer> list = new ArrayList<>(map.keySet());
            Collections.sort(list);
            for(int j=0;j<list.size();j++){
                System.out.println(list.get(j) + " " + map.get(list.get(j)));
            }
        }
    }
}







