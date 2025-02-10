import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.valueOf(br.readLine());
        int[] arr = new int[input];
        int[] dp = new int[input];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for(int i=1;i<arr.length;i++){
            binarySearch(list, arr, arr[i]);
            // 끝보다 크면 추가

        }
        System.out.println(list.size());
    }

    private static void binarySearch(List<Integer> list, int[] arr, int target){
        if(target > list.get(list.size()-1)){
            list.add(target);
        }
        else{
            int start = 0;
            int end = list.size()-1;
            int mid = 0;
            // 이분탐색
            while(start<=end){
                mid = (start + end) / 2;
                if(target == list.get(mid)){
                    list.set(mid, target);
                    return;
                }
                else if(list.get(mid)<target){
                    start = mid + 1;
                }
                else if(list.get(mid)>target){
                    end = mid - 1;
                }
            }
            list.set(start, target);
        }
    }
}