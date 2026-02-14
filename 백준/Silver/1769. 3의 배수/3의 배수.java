import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
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

        String input = br.readLine();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<input.length();i++){
            list.add(input.charAt(i) - '0');
        }

        int count = 0;

        while(list.size() != 1){
            count++;
            int sum = 0;
            for(int i : list) sum += i;
            list.clear();;
            while(sum != 0){
                list.add(sum % 10);
                sum /= 10;
            }
        }

        int answer = list.get(0);
        System.out.println(count);
        if(answer == 3 || answer == 6 || answer == 9){
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }
}
