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

        int input = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<input;i++) {
            int temp = Integer.parseInt(st.nextToken());
            list.add(temp);
            set.add(temp);
            map.put(temp, i);
        }

        int[] score = new int[input];

        for(int i=0;i<input;i++){
            int scoreNow = 0;
            int original = list.get(i);
            int temp = original * 2;
            while(temp <= 1000000){
                if(set.contains(temp)){
                    scoreNow++;
                    score[map.get(temp)]--;
                }
                temp += original;
            }
            score[i]+=scoreNow;
        }

        for(int i : score){
            System.out.print(i + " ");
        }
    }
}
