
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 받는 기계 선언


        // br.readLine()으로 입력 받은 것을 공백 단위로 쪼개는 역할을 한다
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 쪼갠 데이터를 사용할 때는 st.nextToken()사용

        int number1 = Integer.parseInt(st.nextToken());
        // 이때 쪼갠 데이터(st.nextToken()) 또한 String형이기 때문에 Integer로 변환

        int number2 = Integer.parseInt(st.nextToken());


        if(number1 > number2) System.out.println(">");
        else if(number1 < number2) System.out.println("<");
        else System.out.println("==");
    }
}