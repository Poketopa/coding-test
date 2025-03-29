
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력 형식을 BufferedWriter로 변경
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int input = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        
        // 첫 번째 줄과 두 번째 줄을 각각 토크나이저로 분리
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        
        int[] num1 = new int[input];
        int[] num2 = new int[input];
        
        // num1, num2 배열 초기화
        for(int i = 0; i < input; i++){
            num1[i] = Integer.parseInt(st.nextToken());
            num2[i] = Integer.parseInt(st2.nextToken());
        }

        // num1이 0인 경우에만 num2 값을 큐에 삽입 (역순으로)
        for(int i = num1.length - 1; i >= 0; i--){
            if(num1[i] == 0) queue.add(num2[i]);
        }

        int input2 = Integer.parseInt(br.readLine());
        StringTokenizer st3 = new StringTokenizer(br.readLine());

        // 입력값을 큐에 넣고 동시에 poll 하여 출력
        for(int i = 0; i < input2; i++){
            queue.add(Integer.parseInt(st3.nextToken()));
            // BufferedWriter를 사용한 출력
            bw.write(queue.poll() + " ");
        }

        // 버퍼를 비우고 닫아줌
        bw.flush();
        bw.close();
    }
}
