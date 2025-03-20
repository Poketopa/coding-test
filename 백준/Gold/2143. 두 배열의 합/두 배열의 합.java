
import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(br.readLine());
        int aLength = Integer.parseInt(br.readLine());
        int[] A = new int[aLength + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=aLength;i++) A[i] = Integer.parseInt(st.nextToken());
        int bLength = Integer.parseInt(br.readLine());
        int[] B = new int[bLength + 1];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=1;i<=bLength;i++) B[i] = Integer.parseInt(st2.nextToken());
        for(int i=1;i<=aLength;i++){
            A[i] += A[i-1];
        }
        for(int i=1;i<=bLength;i++){
            B[i] += B[i-1];
        }
        HashMap<Integer, Integer> aMap = new HashMap<>();
        HashMap<Integer, Integer> bMap = new HashMap<>();
        for(int i=0;i<aLength;i++){
            for(int j=i + 1;j<=aLength;j++){
                int temp = A[j] - A[i];
                aMap.put(temp, aMap.getOrDefault(temp, 0) + 1);
            }
        }
        for(int i=0;i<bLength;i++){
            for(int j=i + 1;j<=bLength;j++){
                int temp = B[j] - B[i];
                bMap.put(temp, bMap.getOrDefault(temp, 0) + 1);
            }
        }
        List<Integer> aList = new ArrayList<>(aMap.keySet());
        List<Integer> bList = new ArrayList<>(bMap.keySet());
        Collections.sort(aList);
        Collections.sort(bList, Collections.reverseOrder());

        int aIndex = 0;
        int bIndex = 0;
        long answer = 0;

        while(true){
            if(aIndex == aList.size() || bIndex == bList.size()) break;
            if(aList.get(aIndex) + bList.get(bIndex) > target){
                bIndex++;
            }
            else if(aList.get(aIndex) + bList.get(bIndex) < target){
                aIndex++;
            }
            else{
                answer += (long) aMap.get(aList.get(aIndex)) * bMap.get(bList.get(bIndex));
                aIndex++;
                bIndex++;
            }
        }
        System.out.println(answer);
    }
}
