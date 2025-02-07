import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int strowNum = Integer.valueOf(br.readLine());
        Integer[] strow = new Integer[strowNum];
        for(int i=0;i<strowNum;i++){
            strow[i] = Integer.valueOf(br.readLine());
        }
        Arrays.sort(strow, Collections.reverseOrder());
        int max = -1;
        for(int i=0;i<strowNum-2;i++){
            if(strow[i]<strow[i+1]+strow[i+2]){
                max = strow[i]+strow[i+1]+strow[i+2];
                break;
            }
        }
        if(max == -1) System.out.println("-1");
        else System.out.println(max);

    }
}