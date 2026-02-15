import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static String[] words;
    static int[] pointers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int input = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<input;i++) list.add(Integer.parseInt(br.readLine()));

        int num = a;
        boolean flag = false;

        for(int i : list){
            if(Math.abs(num - b) > Math.abs(i - b)){
                num = i;
                flag = true;
            }
        }
        
        int answer = Math.abs(num - b);
        if(flag) answer++;
        System.out.print(answer);
    }
}
