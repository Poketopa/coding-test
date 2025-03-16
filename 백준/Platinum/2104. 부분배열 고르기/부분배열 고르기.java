
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr, minTree;
    static long[] sumTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        arr[0] = Integer.MAX_VALUE; // 최소값 비교를 위해 0번 인덱스 사용
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sumTree = new long[n * 4];
        minTree = new int[n * 4];

        // 세그먼트 트리 초기화
        buildSumTree(1, 1, n);
        buildMinTree(1, 1, n);

        // 최대 점수 계산 및 출력
        System.out.println(findMaxScore(1, n));
    }

    /** ✅ 최대 점수 찾기 (분할 정복) */
    private static long findMaxScore(int start, int end){
        if(start > end) return 0;

        int minIndex = queryMin(1, 1, n, start, end);
        long sumNum = querySum(1, 1, n, start, end);
        long area = arr[minIndex] * sumNum;

        if(start < minIndex){
            area = Math.max(area, findMaxScore(start, minIndex - 1));
        }
        if(minIndex < end){
            area = Math.max(area, findMaxScore(minIndex + 1, end));
        }

        return area;
    }

    /** ✅ 특정 구간의 최소값 위치를 찾는 함수 */
    private static int queryMin(int node, int start, int end, int left, int right){
        if(start > right || end < left) return -1; // ✅ 범위를 벗어난 경우 -1 반환
        if(left <= start && end <= right) return minTree[node];

        int mid = (start + end) / 2;
        int leftMin = queryMin(node * 2, start, mid, left, right);
        int rightMin = queryMin(node * 2 + 1, mid + 1, end, left, right);

        return getMinIndex(leftMin, rightMin);
    }

    /** ✅ 특정 구간의 합을 구하는 함수 */
    private static long querySum(int node, int start, int end, int left, int right){
        if(start > right || end < left) return 0;
        if(left <= start && end <= right) return sumTree[node];

        int mid = (start + end) / 2;
        return querySum(node * 2, start, mid, left, right)
                + querySum(node * 2 + 1, mid + 1, end, left, right);
    }

    /** ✅ 세그먼트 트리 초기화 (구간 합) */
    private static long buildSumTree(int node, int start, int end){
        if(start == end){
            return sumTree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        return sumTree[node] = buildSumTree(node * 2, start, mid)
                + buildSumTree(node * 2 + 1, mid + 1, end);
    }

    /** ✅ 세그먼트 트리 초기화 (구간 최소값 위치) */
    private static int buildMinTree(int node, int start, int end){
        if(start == end) return minTree[node] = start; // ✅ sumTree가 아닌 minTree에 저장

        int mid = (start + end) / 2;
        int leftMin = buildMinTree(node * 2, start, mid);
        int rightMin = buildMinTree(node * 2 + 1, mid + 1, end);
        return minTree[node] = getMinIndex(leftMin, rightMin);
    }

    /** ✅ 최소값의 인덱스를 반환하는 함수 */
    private static int getMinIndex(int leftMin, int rightMin){
        if(leftMin == -1) return rightMin; // ✅ -1이면 다른 인덱스를 반환
        if(rightMin == -1) return leftMin; // ✅ -1이면 다른 인덱스를 반환

        if(arr[leftMin] < arr[rightMin]) return leftMin;
        else if(arr[leftMin] > arr[rightMin]) return rightMin;
        else return Math.min(leftMin, rightMin); // ✅ 값이 같으면 작은 인덱스 반환
    }
}




