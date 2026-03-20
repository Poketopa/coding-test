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

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        for(int i=0;i<4;i++) list1.add(Integer.parseInt(br.readLine()));
        for(int i=0;i<2;i++) list2.add(Integer.parseInt(br.readLine()));
        
        Collections.sort(list1, Collections.reverseOrder());
        Collections.sort(list2, Collections.reverseOrder());
        int sum = 0;
        for(int i=0;i<3;i++) sum += list1.get(i);
        sum += list2.get(0);
        System.out.print(sum);
    }
}
