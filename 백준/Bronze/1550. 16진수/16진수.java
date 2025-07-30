import java.io.*;
import java.util.*;

public class Main {
    static boolean[] even = new boolean[1000001];
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int temp = 1;
        
        String[] arr = br.readLine().split("");
        int sum = 0;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i].equals("A")) sum += temp * 10;
            else if(arr[i].equals("B")) sum += temp * 11;
            else if(arr[i].equals("C")) sum += temp * 12;
            else if(arr[i].equals("D")) sum += temp * 13;
            else if(arr[i].equals("E")) sum += temp * 14;
            else if(arr[i].equals("F")) sum += temp * 15;
            else{
                sum += temp * Integer.parseInt(arr[i]);
            }
            temp *= 16;
        }
        System.out.println(sum);
    }
}
