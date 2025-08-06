import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        int top = -1;
        String answer = "";

        for(int i=0;i<input;i++){
            String temp = br.readLine();
            set.add(temp);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            top = Math.max(top, map.get(temp));
        }
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        for(String i : list){
            if(map.get(i) == top){
                System.out.print(i);
                return;
            }
        }
    }
}
