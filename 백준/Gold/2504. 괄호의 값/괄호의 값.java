import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String input = br.readLine();
        if(check(input)) {
            System.out.print("0");
            return;
        }
        List list = new ArrayList<>();
        for(int i=0;i<input.length();i++) list.add(String.valueOf(input.charAt(i)));
        while(true){
            if(list.size() == 1) break;
            // () -> 2 [] -> 3 변환
            for(int i=0;i<list.size()-1;i++){
                if(i >= list.size()) break;
                if(list.size() > 1 &&list.get(i) instanceof String && list.get(i+1) instanceof String){
                    if(list.size() > 1 &&list.get(i).equals("(") && list.get(i+1).equals(")")){
                        list.set(i, (Integer)2);
                        list.remove(i + 1);
                    }
                    else if(list.size() > 1 &&list.get(i).equals("[") && list.get(i+1).equals("]")){
                        list.set(i, (Integer)3);
                        list.remove(i + 1);
                    }
                }
            }
            // 붙어있는 숫자 덧셈
            int j = 0;
            while (j < list.size() - 1) {
                if (list.get(j) instanceof Integer && list.get(j+1) instanceof Integer) {
                    // 두 요소가 모두 숫자면 합치고 i를 증가시키지 않음
                    // (다음 while 루프에서 현재 i를 다시 검사해야 함)
                    list.set(j, (Integer)((int)list.get(j) + (int)list.get(j + 1)));
                    list.remove(j + 1);
                } else {
                    // 숫자가 아니거나, 다음 요소가 숫자가 아니면 i를 증가
                    j++;
                }
            }
            // 숫자면 오른쪽 왼쪽 확인 후 곱셈
            if(list.size() > 1){
                for(int i=1;i<list.size()-1;i++){
                    if(i >= list.size()) break;
                    if(list.size() > 1 &&list.get(i) instanceof Integer){
                        if(list.get(i-1).equals("(") && list.get(i+1).equals(")")){
                            list.set(i, (Integer)list.get(i) * 2);
                            list.remove(i+1);
                            list.remove(i-1);
                        }
                        else if(list.get(i-1).equals("[") && list.get(i+1).equals("]")){
                            list.set(i, (Integer)list.get(i) * 3);
                            list.remove(i+1);
                            list.remove(i-1);
                        }
                    }
                }
            }
        }
        System.out.print(list.get(0));
    }

    public static boolean check(String input){
        String[] arr = input.split("");
        Stack<String> stack = new Stack<>();
        for(int i=0;i<input.length();i++){
            if(arr[i].equals(")")){
                if(stack.isEmpty()) return true;
                else if(stack.peek().equals("(")){
                    stack.pop();
                }
                else return true;
            } else if(arr[i].equals("]")){
                if(stack.isEmpty()) return true;
                else if(stack.peek().equals("[")){
                    stack.pop();
                }
                else return true;
            } else {
                stack.add(arr[i]);
            }
        }
        if(stack.isEmpty()) return false;
        else return true;

    }
}






