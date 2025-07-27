import java.io.*;
import java.util.*;

public class Main {
    static boolean[] even = new boolean[1000001];
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        int[] ball = new int[3];
        ball[0] = 1;
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            swap(a ,b, ball);
        }
        for(int i=0;i<3;i++){
            if(ball[i] == 1) System.out.print(i + 1);
        }
    }
    public static void swap(int a, int b, int[] ball){
        int temp = ball[a-1];
        ball[a-1] = ball[b-1];
        ball[b-1] = temp;
    }
}
