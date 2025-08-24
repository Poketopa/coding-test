import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        set.add(num);
        list.add(num);

        while(true){
            int newNum = 0;
            while(num != 0){
                newNum += (int)Math.pow((num%10), P);
                num /= 10;
            }
            if(set.contains(newNum)){
                System.out.print(list.indexOf(newNum));
                break;
            }
            else{
                set.add(newNum);
                list.add(newNum);
                num = newNum;
            }
        }
    }
}
