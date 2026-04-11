import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] list;
    static int[] ans; // 각 컴퓨터별 해킹 가능 마릿수 저장
    static int[] visited; // int형으로 선언하여 매번 new 생성 방지
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());


        StringTokenizer st = new StringTokenizer(br.readLine());
        int apple1 = Integer.parseInt(st.nextToken());
        int orange1 = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int apple2 = Integer.parseInt(st2.nextToken());
        int orange2 = Integer.parseInt(st2.nextToken());

        System.out.print((int)Math.min(apple1 + orange2, apple2 + orange1) );
    }
}
