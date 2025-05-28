import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int need = Integer.parseInt(st.nextToken());
        int input = Integer.parseInt(st.nextToken());
        int[] one = new int[input];
        int[] six = new int[input];
        for(int i=0;i<input;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            six[i] = Integer.parseInt(st2.nextToken());
            one[i] = Integer.parseInt(st2.nextToken());
        }
        for(int i=0;i<input;i++){
            if(one[i] * 6 < six[i]) six[i] = one[i] * 6;
        }
        int sum = 0;
        Arrays.sort(six);
        Arrays.sort(one);
        while(need >= 6){
            sum += six[0];
            need -= 6;
        }
        if(need > 0){
            sum += Math.min(one[0] * need, six[0]);
        }
        System.out.println(sum);
    }
}
