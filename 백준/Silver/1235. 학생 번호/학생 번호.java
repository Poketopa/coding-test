import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1) BufferedReader로 입력 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 2) 첫 줄: 학생 수
        int N = Integer.parseInt(br.readLine());

        // 3) 학생 번호들을 문자열 배열로 저장
        String[] numbers = new String[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = br.readLine();
        }

        // 4) 학생 번호 길이 (모두 같음)
        int length = numbers[0].length();

        // 5) 뒤에서부터 1자리씩 확인해서 최소 k 찾기
        int answer = 1;
        for (int k = 1; k <= length; k++) {
            Set<String> set = new HashSet<>();

            // 모든 번호에서 뒤 k자리 추출 후 Set에 저장
            for (String num : numbers) {
                String suffix = num.substring(length - k);
                set.add(suffix);
            }

            // Set 크기가 N이면 중복 없음! 답 찾음
            if (set.size() == N) {
                answer = k;
                break;
            }
        }

        System.out.println(answer);
    }
}