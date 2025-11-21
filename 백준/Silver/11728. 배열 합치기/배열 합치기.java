import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isPrime = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int fir = Integer.parseInt(st.nextToken());
        int sec = Integer.parseInt(st.nextToken());
        int[] first = new int[fir];
        int[] second = new int[sec];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for(int i=0;i<fir;i++) first[i] = Integer.parseInt(st2.nextToken());
        for(int i=0;i<sec;i++) second[i] = Integer.parseInt(st3.nextToken());
        int index1 =0;
        int index2 =0;
        StringBuilder sb = new StringBuilder("");
        while(true){
            if(index1 == fir && index2 == sec) break;
            if(index1 == fir){
                sb.append(second[index2]);
                index2++;
            }
            else if(index2 == sec){
                sb.append(first[index1]);
                index1++;
            }
            else if(first[index1] < second[index2]){
                sb.append(first[index1]);
                index1++;
            }
            else{
                sb.append(second[index2]);
                index2++;
            }
            sb.append(" ");
        }
        System.out.print(sb.toString());
    }
}
