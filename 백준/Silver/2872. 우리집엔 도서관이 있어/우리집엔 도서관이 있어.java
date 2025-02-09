import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int testCase = Integer.valueOf(br.readLine());
        int[] book = new int[testCase];
        int count = 0;
        for(int i=0;i<testCase;i++){
            book[i] = (Integer.valueOf(br.readLine()));
        }
        int[] index = new int[testCase+1];
        for(int i = 0;i<book.length;i++){
            index[book[i]] = i;
        }
        int topIndex = -1;
        //   1 3 4 2 book
        // 0 0 3 1 2
        for(int i = testCase-1;i>0;i--){
            if(index[i]> index[i+1]){
                count++;
                index[i] = topIndex;
                topIndex--;
            }
        }
        System.out.println(count);
    }
}