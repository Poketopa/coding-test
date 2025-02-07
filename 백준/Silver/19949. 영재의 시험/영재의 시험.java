import java.io.*;
import java.util.*;

public class Main {
    static int[] answer = new int[10]; // 정답 저장
    static int count = 0; // 5점 이상 획득 경우의 수 카운트
    static int[] selected = new int[10]; // 영재가 찍은 답

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 10; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, -1, -1); // DFS 탐색 시작

        System.out.println(count);
    }

    // 🚀 DFS로 모든 찍기 방법을 탐색
    private static void dfs(int depth, int prev1, int prev2) {
        if (depth == 10) { // 모든 문제를 찍었을 때
            if (getScore() >= 5) count++; // 점수가 5점 이상이면 카운트 증가
            return;
        }

        // 🚀 1~5까지 찍기
        for (int i = 1; i <= 5; i++) {
            if (i == prev1 && i == prev2) continue; // 연속 3개 동일한 숫자 방지
            
            selected[depth] = i; // 답 선택
            dfs(depth + 1, prev2, i); // 다음 문제 탐색
        }
    }

    // 🚀 점수 계산
    private static int getScore() {
        int score = 0;
        for (int i = 0; i < 10; i++) {
            if (selected[i] == answer[i]) score++; // 정답과 비교하여 점수 계산
        }
        return score;
    }
}
