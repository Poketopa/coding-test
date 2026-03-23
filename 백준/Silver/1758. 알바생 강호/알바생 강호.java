import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();
        int input = Integer.parseInt(br.readLine());
        for(int i=0;i<input;i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list, Collections.reverseOrder());
        long sum = 0;
        for(int i=0;i<input;i++){
            if(list.get(i) - i <= 0) continue;
            sum += list.get(i) - i;
        }
        System.out.print(sum);
    }
}
