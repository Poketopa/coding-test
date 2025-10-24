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

        int input = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<input;i++){
            String str = br.readLine();
            String[] arr = str.split("\\.");
            map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for(String i : list){
            System.out.println(i + " " + map.get(i));
        }
    }
}






