
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input1 = Integer.valueOf(br.readLine());
        int[] number1 = new int[input1];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i=0;i<input1;i++)number1[i] = Integer.valueOf(st1.nextToken());
        int input2 = Integer.valueOf(br.readLine());
        int[] number2 = new int[input2];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<input2;i++)number2[i] = Integer.valueOf(st2.nextToken());

        Arrays.sort(number1);

        for(int i=0;i<number2.length;i++){
            if(binarySearch(number1, number2[i])){
                System.out.println("1");
            }
            else{
                System.out.println("0");
            }
        }


    }

    private static boolean binarySearch(int[] number, int target){
        int start = 0;
        int end = number.length-1;
        while(start<=end){
            int mid = (start + end) / 2;
            if(number[mid] == target) return true;
            else if(number[mid] < target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return false;
    }
}