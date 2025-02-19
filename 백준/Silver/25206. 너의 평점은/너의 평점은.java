import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double gradeSum = 0;
        double resultSum = 0;

        // 20줄 입력 고정
        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            double grade = Double.parseDouble(st.nextToken()); // ✅ 학점은 double로 변환
            String result = st.nextToken();

            // P 과목 제외
            if (result.equals("P")) continue; // ✅ "P" 과목 제외

            // 성적에 따라 점수 계산
            switch (result) {
                case "A+": resultSum += grade * 4.5; break;
                case "A0": resultSum += grade * 4.0; break;
                case "B+": resultSum += grade * 3.5; break;
                case "B0": resultSum += grade * 3.0; break;
                case "C+": resultSum += grade * 2.5; break;
                case "C0": resultSum += grade * 2.0; break;
                case "D+": resultSum += grade * 1.5; break;
                case "D0": resultSum += grade * 1.0; break;
                case "F": resultSum += grade * 0.0; break;
            }

            // ✅ "P" 과목이 아니라면 학점 총합에 포함
            gradeSum += grade;
        }

        // 전공평점 출력
        System.out.printf("%.6f\n", resultSum / gradeSum);
    }
}
