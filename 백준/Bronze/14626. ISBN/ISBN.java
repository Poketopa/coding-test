import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String temp = br.readLine();
        int sum = 0;
        int starIndex = -1;

        // 1. '*'를 제외한 나머지 숫자들의 가중치 합을 구함
        for (int i = 0; i < temp.length() - 1; i++) {
            char c = temp.charAt(i);
            if (c == '*') {
                starIndex = i; // '*'의 위치 저장
                continue;
            }
            
            int num = c - '0';
            // 짝수 인덱스(1, 3, 5...)는 *1, 홀수 인덱스(2, 4, 6...)는 *3
            if (i % 2 == 0) {
                sum += num;
            } else {
                sum += (num * 3);
            }
        }

        int target = temp.charAt(temp.length() - 1) - '0';
        int answer = 0;

        // 2. 0부터 9까지 대입하며 조건에 맞는 숫자 찾기
        for (int i = 0; i <= 9; i++) {
            int currentSum = sum;
            
            // '*' 위치의 가중치를 계산해서 더함
            if (starIndex % 2 == 0) {
                currentSum += i;
            } else {
                currentSum += (i * 3);
            }

            // 3. 체크 숫자 공식: (10 - (전체합 % 10)) % 10
            if ((10 - (currentSum % 10)) % 10 == target) {
                answer = i;
                break;
            }
        }

        System.out.print(answer);
    }
}