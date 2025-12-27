import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
        int friends = Integer.parseInt(st.nextToken());
        int fire = Integer.parseInt(st.nextToken());
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<friends;i++) list.add(Integer.parseInt(br.readLine()));
        sum += list.size();
        List<Integer> term = new ArrayList<>();
        for(int i=0;i<list.size()-1;i++) term.add(list.get(i + 1) - list.get(i) - 1);
        Collections.sort(term, Collections.reverseOrder());
        for(int i=-1 + fire;i<term.size();i++) sum += term.get(i);
        System.out.print(sum);
    }
}
