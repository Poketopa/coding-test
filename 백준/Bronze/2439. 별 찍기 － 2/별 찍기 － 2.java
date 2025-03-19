
import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());

        for(int i=input-1;i>=0;i--){
            for(int j=0;j<i;j++){
                System.out.print(" ");
            }
            for(int k=i;k<input;k++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
