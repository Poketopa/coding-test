
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력용
        String line;
        while ((line = br.readLine()) != null) {  // EOF 처리
            int temp = Integer.parseInt(line);
            String[] arr = new String[(int) Math.pow(3, temp)];
            int length = (int)Math.pow(3, temp);
            Arrays.fill(arr, " ");
            dfs(arr, 0, arr.length - 1, length);
            for (String i : arr) bw.write(i); // 출력 변경
            bw.newLine(); // 개행
        }
        bw.flush(); // 출력 버퍼 비우기
    }

    private static void dfs(String[] arr, int start, int end, int length){
        length /= 3;
        if(start == end) {
            arr[start] = "-";
            return;
        }
        dfs(arr, start, start + length - 1, length);
        dfs(arr, end - length + 1, end, length);
    }
}