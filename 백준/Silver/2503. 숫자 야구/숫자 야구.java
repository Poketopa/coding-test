import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        // 가능한 세 자리 숫자를 모두 Set에 저장
        Set<Integer> set = new HashSet<>();
        for(int i = 111; i <= 999; i++) {
            set.add(i);
        }

        // input(질문) 수 만큼 반복
        for(int i = 0; i < input; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int say = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            int num1 = say / 100;
            int num2 = (say / 10) % 10;
            int num3 = say % 10;

            // 안전하게 Set을 수정하기 위해 Iterator 사용
            Iterator<Integer> it = set.iterator();
            while(it.hasNext()) {
                int num = it.next();

                int tempNum1 = num / 100;
                int tempNum2 = (num / 10) % 10;
                int tempNum3 = num % 10;

                // 각 숫자 중복되거나 0 포함된 경우 제거
                if(tempNum1 == tempNum2 || tempNum2 == tempNum3 || tempNum1 == tempNum3 ||
                        tempNum1 == 0 || tempNum2 == 0 || tempNum3 == 0) {
                    it.remove();
                    continue;
                }

                int tempStrike = 0;
                int tempBall = 0;

                // 자리와 숫자가 같은 경우 스트라이크
                if(tempNum1 == num1) tempStrike++;
                else if(tempNum1 == num2 || tempNum1 == num3) tempBall++;

                if(tempNum2 == num2) tempStrike++;
                else if(tempNum2 == num1 || tempNum2 == num3) tempBall++;

                if(tempNum3 == num3) tempStrike++;
                else if(tempNum3 == num1 || tempNum3 == num2) tempBall++;

                // 조건에 맞지 않으면 제거
                if(tempStrike != strike || tempBall != ball) {
                    it.remove();
                }
            }
        }

        // 남아 있는 가능한 숫자의 개수 출력
        System.out.println(set.size());
    }
}
