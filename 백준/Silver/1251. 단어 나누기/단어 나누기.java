
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        String input = br.readLine();
        String min = "";
        String now = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        for(int i=0;i<input.length()-2;i++){
            for(int j=i+1;j<input.length()-1;j++){
                min = "";
                for(int k = i;k>=0;k--){
                    min+=input.charAt(k);
                }
                for(int k= j;k>=i + 1;k--){
                    min += input.charAt(k);
                }
                for(int k=input.length()-1;k>=j + 1;k--){
                    min += input.charAt(k);
                }
                if(min.compareTo(now)<0){
                    now = min;
                }
            }
        }
        System.out.println(now);
    }
}