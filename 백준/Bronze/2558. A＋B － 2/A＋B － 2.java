
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader라는 매서드(함수)에서 새로운 객체 생성 (br이라는 이름의 입력 함수를 만듦)
        // 쉽게 생각하면 br이라는 입력받는 기계를 만든거임
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // number1 int형 선언
        // br.readLine() : br이라는 기계로 한줄을 입력 받음
        // 이 때 br.readLine()은 String형이라서 int형으로 변환해야함
        // 그렇기 때문에 Integer.parseInt : 정수형으로 변환을 사용
        int number1 = Integer.parseInt(br.readLine());
        // 한줄 더
        int number2 = Integer.parseInt(br.readLine());

        System.out.println(number1 + number2);
    }
}