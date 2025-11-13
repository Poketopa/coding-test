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

        int input = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i=0;i<input;i++){
            String temp = br.readLine();
            List<Character> list = new ArrayList<>();
            for(int j=0;j<temp.length();j++){
                if(list.isEmpty()){
                    list.add(temp.charAt(j));
                    continue;
                }
                if(temp.charAt(j) == list.get(list.size()-1)){
                    list.remove(list.size()-1);
                } else {
                    list.add(temp.charAt(j));
                }
            }
            if(list.isEmpty()) count++;
        }
        System.out.print(count);
    }
}
