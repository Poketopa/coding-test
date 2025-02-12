import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.valueOf(br.readLine());
        String[] arr = new String[input];
        for(int i=0;i<input;i++){
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, (a,b)->{
           if(a.length()<b.length()) return -1;
           else if(a.length()>b.length()) return 1;
           else{
               return a.compareTo(b);
           }
        });
        for(int i=0;i<arr.length;i++){
            if(i>0 && arr[i].equals(arr[i-1])){
                continue;
            }
            System.out.println(arr[i]);
        }
        
    }
}