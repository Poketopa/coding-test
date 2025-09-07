import java.io.*;
import java.util.*;

public class Main {
    static long count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[input];
        for(int i=0;i<input;i++) num[i] = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        for(int i=0;i<input;i++){
            if(i==0) list.add(num[i]); // 첫번째는 무조건 넣음
            else if(list.get(list.size()-1) == num[i]) continue; // 같으면 무시
            else if(list.get(list.size()-1) > num[i]) list.add(num[i]); // 더 작으면 추가
            else if(list.get(list.size()-1) < num[i]){ // 이진탐색으로 새로운 곳으로 배치
                binarySearch(list, 0, list.size()-1, num[i]);
            }
        }
        System.out.print(input - list.size());
    }

    public static void binarySearch(List<Integer> list, int start, int end, int target){
        if(start >= end){
            list.set(start, target);
            return;
        }

        int middle = (start + end) / 2;

        if(list.get(middle) < target){ // 타깃이 더 크면 왼쪽 탐색
            binarySearch(list, start, middle, target);
        } else if (list.get(middle) > target) {
            binarySearch(list, middle + 1, end, target);
        }
    }
}


// 5 4 3 2 1 29 18
