import java.util.*;
import java.math.*;

class Solution {
    public String solution(String p) {
        // $ "()))((()
        // 1. u(더 이상 분리 불가한 균형) v(나머지)
        // 2. u가 올바르므로 v에 대해서 재귀
        // $ "))((()"
        // 1. u = "))((" 각 방향 개수가 같아야한다
        // 2. v = "()" 나머지
        // $ u가 올바르지 않기 때문에 새로운 문자열 만든다
        // 1. 첫번째 문자 "("
        // 2. v에 대해서 재귀적으로 수행한다
        // 3. u의 앞뒤 문자 제거 ")("
        // 4. 방향 뒤집기 "()
        // 5. 더하기 "()(())()

        return start(p);
    }

    private String start(String p){
        if(p.length()==0) return "";
        // 균형잡힌 괄호 문자열 찾기
        String[] uv = findBalance(p);
        String u = uv[0];
        String v = uv[1];
        String answer = "";

        // u가 올바른 괄호인지 확인
        if(uIsRight(u)){
            // 올바르면 다시 v 재귀
            answer += u;
            v = start(v);
            return (u+v);
        }
        else{
            // 올바르지 않을 때
            String temp = "(";
            temp += start(v);
            temp += ")";
            // u의 첫, 마지막 문자 제거, 나머지 뒤집음
            String newU = "";
            for(int i=0;i<u.length();i++){
                if(i == 0 || i == u.length()-1) continue;
                if(u.charAt(i)=='('){
                    newU += ")";
                }
                else newU += "(";
            }
            temp += newU;
            answer += temp;
            return answer;
        }
    }

    // 균현잡힌 괄호 문자열 u, v
    private String[] findBalance(String str){
        String u = "";
        String v = "";
        int countLeft = 0;
        int countRight = 0;
        int index = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '(') countLeft++;
            else countRight++;
            if(countLeft == countRight){
                index = i;
                break;
            }
        }
        for(int i=0;i<=index;i++) u += String.valueOf(str.charAt(i));
        if(index != str.length()) for(int i=index+1;i<str.length();i++) v += String.valueOf(str.charAt(i));
        return new String[]{u, v};
    }

    private boolean uIsRight(String str){
        int left = 0;
        int right = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='(') left++;
            else right++;
            // 올바르지 않음
            if(left<right) return false;
        }
        return true;
    }
}