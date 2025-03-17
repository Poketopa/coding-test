

import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] oddTree;
    static int[] evenTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        arr = new int[input + 1];
        oddTree = new int[input * 4];
        evenTree = new int[input * 4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= input; i++) arr[i] = Integer.parseInt(st.nextToken());

        buildOddTree(1, 1, input);
        buildEvenTree(1, 1, input);

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());
            if(a == 1){
                changeTree(1, 1, input, b, c);
            }
            else if(a == 2){
                bw.write(sumEvenTree(1, 1, input, b, c) + "\n");
            }
            else{
                bw.write(sumOddTree(1, 1, input, b, c) + "\n");
            }
        }

        bw.flush(); // ✅ 출력 버퍼 비우기
        bw.close();
    }
    private static int sumEvenTree(int node, int start, int end, int left, int right) {
        if (end < left || start > right) return 0; // 범위를 벗어난 경우
        if (left <= start && end <= right) return evenTree[node];

        int mid = (start + end) / 2;

        return sumEvenTree(node * 2, start, mid, left, right) + sumEvenTree(node * 2 + 1, mid + 1, end, left, right);
    }

    private static int sumOddTree(int node, int start, int end, int left, int right) {
        if (end < left || start > right) return 0; // 범위를 벗어난 경우
        if (left <= start && end <= right) return oddTree[node];

        int mid = (start + end) / 2;

        return sumOddTree(node * 2, start, mid, left, right) + sumOddTree(node * 2 + 1, mid + 1, end, left, right);
    }

    private static int buildOddTree(int node, int start, int end){
        if(start == end){
            if(arr[start] %2 == 1) oddTree[node] = 1;
            else oddTree[node] = 0;
            return oddTree[node];
        }
        int mid = (start + end) / 2;
        oddTree[node] = buildOddTree(node * 2, start, mid) + buildOddTree(node * 2 + 1, mid+1, end);
        return oddTree[node];
    }

    private static int buildEvenTree(int node, int start, int end){
        if(start == end){
            if(arr[start] %2 == 0) evenTree[node] = 1;
            else evenTree[node] = 0;
            return evenTree[node];
        }
        int mid = (start + end) / 2;
        evenTree[node] = buildEvenTree(node * 2, start, mid) + buildEvenTree(node * 2 + 1, mid+1, end);
        return evenTree[node];
    }

    private static void changeTree(int node, int start, int end, int index, int newNum) {
        if (start > index || end < index) return;

        if (start == end) {
            arr[index] = newNum;
            if(newNum % 2 == 1){
                oddTree[node] = 1;
                evenTree[node] = 0;
            }
            else{
                oddTree[node] = 0;
                evenTree[node] = 1;
            }
            return;
        }
        int mid = (start + end) / 2;

        changeTree(node * 2, start, mid, index, newNum);
        changeTree(node*2 + 1, mid + 1, end, index, newNum);

        oddTree[node] = oddTree[node * 2] + oddTree[node * 2 + 1];
        evenTree[node] = evenTree[node * 2] + evenTree[node * 2 + 1];
        return;
    }
}
