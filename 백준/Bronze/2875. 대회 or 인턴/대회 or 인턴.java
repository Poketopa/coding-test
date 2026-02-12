import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static String[] words;
    static int[] pointers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int woman = Integer.parseInt(st.nextToken());
        int man = Integer.parseInt(st.nextToken());
        int intern = Integer.parseInt(st.nextToken());

        int team = 0;

        if(woman > 2 * man){ // 여자 포화
            intern -= (woman - (2 * man));
            woman = man * 2;
        } else if(woman < 2 * man){ // 남자 포화
            intern -= (man - (woman / 2));
            man = woman / 2;
        }

        team += man;

        if(intern <= 0){
            System.out.print(team);
            return;
        }

        System.out.print(team - ((intern + 2) / 3));
    }
}
