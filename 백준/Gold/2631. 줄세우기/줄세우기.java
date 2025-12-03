import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        int[] number = new int[input];
        for(int i=0;i<input;i++) number[i] = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        for(int i=0;i<input;i++){
            if(list.isEmpty()) {
                list.add(number[i]);
                continue;
            }
            if(list.get(list.size()-1) < number[i]){
                list.add(number[i]);
            }
            else binarySearch(number[i], list, 0, list.size()-1);
        }
        System.out.print(input - list.size());
    }
    public static void binarySearch(int number, List<Integer> list, int start, int end){
        if(start >= end){
            list.set(end, number);
            return;
        }
        int mid = (start + end) / 2;
        if(list.get(mid) <= number){
            binarySearch(number, list, mid + 1, end);
        }
        else if(list.get(mid) > number){
            binarySearch(number, list, start, mid);
        }
    }
}
