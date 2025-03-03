

import java.io.*;
import java.util.*;

public class Main {
    static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력값 읽기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        int[] number = new int[input];
        Set<List<Integer>> set = new HashSet<>();

        // 숫자 입력 받기
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < input; i++) {
            number[i] = Integer.parseInt(st2.nextToken());
        }

        // 숫자 정렬 (오름차순)
        Arrays.sort(number);
        List<Integer> list = new ArrayList<>();

        // DFS 호출
        for (int i = 0; i < input; i++) {
            dfs(length, number, list, i, set, bw);
        }

        // 출력 버퍼 비우기
        bw.flush();
        bw.close();
    }

    private static void dfs(int length, int[] number, List<Integer> list, int now, Set<List<Integer>> set, BufferedWriter bw) throws IOException {
        list.add(number[now]); // 현재 숫자를 리스트에 추가

        // 종료 조건: 리스트 길이가 length와 같을 때
        if (list.size() == length) {
            if (!set.contains(list)) {
                set.add(new ArrayList<>(list)); // 리스트의 복사본을 저장
                for (int i = 0; i < length; i++) {
                    bw.write(list.get(i) + " ");
                }
                bw.newLine(); // 줄바꿈
            }
            list.remove(list.size() - 1);
            return;
        }

        // 모든 원소에 대해 재귀 호출
        for (int i = 0; i < number.length; i++) {
            dfs(length, number, list, i, set, bw);
        }

        list.remove(list.size() - 1); // 백트래킹
    }
}
