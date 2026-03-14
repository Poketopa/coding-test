import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String input = br.readLine();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<input.length();i++) {
            if(input.charAt(i) == 'Y') list.add(1);
            else list.add(0);
        }
        int count = 0;
        for(int i=0;i<input.length();i++){
            if(list.get(i) == 1){
                count++;
                for(int j=i;j<input.length();j+=(i + 1)){
                    if(list.get(j) == 1)  list.set(j, 0);
                    else list.set(j, 1);
                }
            }
        }
        System.out.print(count);
    }
}
