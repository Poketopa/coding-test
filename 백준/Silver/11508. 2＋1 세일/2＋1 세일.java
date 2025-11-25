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
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<input;i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        int sum = 0;
        int count = 0;
        while(!list.isEmpty()){
            count++;
            if(count % 3 == 0) {
                list.remove(list.size()-1);
                continue;
            }
            sum += list.get(list.size()-1);
            list.remove(list.size()-1);
        }
        System.out.print(sum);
    }
}
