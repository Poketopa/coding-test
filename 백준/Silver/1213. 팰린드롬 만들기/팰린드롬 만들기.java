import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        String input = br.readLine();

        // 문자열을 문자 배열로 변환하여 각 문자를 저장
        String[] arr = new String[input.length()];
        for (int i = 0; i < input.length(); i++) {
            arr[i] = String.valueOf(input.charAt(i));
        }

        // 각 문자의 등장 횟수를 세기 위한 Map 사용
        Map<String, Integer> map = new HashMap<>();
        for (String i : arr) {
            // getOrDefault를 사용할 때는 기본값을 꼭 지정해야 함!
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // 등장 횟수가 홀수인 문자의 개수 세기
        Set<String> set = new HashSet<>(map.keySet());
        int count = 0;
        for (String i : set) {
            if (map.get(i) % 2 == 1) count++;
        }

        // 팰린드롬 불가능한 경우
        if (count > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        // 팰린드롬을 만들 수 있는 경우
        // 알파벳 정렬
        Arrays.sort(arr);

        // 앞부분을 구성할 문자열
        StringBuilder front = new StringBuilder();
        // 가운데 올 수 있는 문자 (홀수 개)
        String center = "";

        // 문자 사용 횟수 만큼 앞부분 구성
        Map<String, Integer> used = new HashMap<>();
        for (String ch : arr) {
            int freq = map.get(ch);
            if (used.getOrDefault(ch, 0) >= freq / 2) continue;

            front.append(ch);
            used.put(ch, used.getOrDefault(ch, 0) + 1);
        }

        // 가운데 문자 찾기
        for (String ch : set) {
            if (map.get(ch) % 2 == 1) {
                center = ch;
                break;
            }
        }

        // 전체 팰린드롬 구성
        StringBuilder back = new StringBuilder(front).reverse();
        System.out.println(front.toString() + center + back.toString());
    }
}
