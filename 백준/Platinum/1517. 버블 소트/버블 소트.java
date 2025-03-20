

import java.io.*;
import java.util.*;

public class Main {
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] number = new int[input];
        for(int i=0;i<input;i++) number[i] = Integer.parseInt(st.nextToken());
        int[] sortNumber = number.clone();
        Arrays.sort(sortNumber);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<input;i++){
            if(!map.containsKey(sortNumber[i])) map.put(sortNumber[i], i+1);
        }
        for(int i=0;i<input;i++) number[i] = map.get(number[i]);
        tree = new int[input * 4];
        long answer = 0;
        for(int i=input-1;i>=0;i--){
            answer += sumTree(1, 1, input, 1, number[i] - 1);
            updateTree(1, 1, input, number[i]);
        }
        System.out.println(answer);
    }

    private static void updateTree(int node, int start, int end, int index){
        if(end < index || start > index) return;
        if(start == end){
            tree[node]++;
            return;
        }
        int mid = (start + end) / 2;
        updateTree(node * 2, start, mid, index);
        updateTree(node * 2 + 1, mid + 1, end, index);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    private static long sumTree(int node, int start, int end, int left, int right){
        if(end < left || start > right) return 0;
        if(left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return sumTree(node * 2, start, mid, left, right) + sumTree(node * 2 + 1, mid + 1, end, left, right);
    }

}
