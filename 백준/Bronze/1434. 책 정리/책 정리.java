import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringTokenizer st3 = new StringTokenizer(br.readLine());

        int[] box = new int[a];
        int[] book = new int[b];

        int sum = 0;

        for(int i=0;i<a;i++){
            box[i] = Integer.parseInt(st2.nextToken());
        }
        for(int i=0;i<b;i++) book[i] = Integer.parseInt(st3.nextToken());

        int index = 0;

        for(int i=0;i<b;i++){
            while(box[index] < book[i]){
                sum += box[index];
                index++;
            }
            box[index] -= book[i];
        }

        for(int i=index;i<a;i++) sum += box[i];



        System.out.print(sum);

    }
}






