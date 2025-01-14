import java.util.*;

class Solution {
    public int[] solution(String msg) {
        // 1. A~Z 알파벳 - 숫자 매핑
        // 2.

        List<Integer> answerList = new ArrayList<>();
        // 맵 생성
        HashMap<String, Integer> map = new HashMap<>();
        int count = 1;
        for (char i = 'A'; i <= 'Z'; i++) {
            map.put(String.valueOf(i), count);
            count++;
        }

        int nowIndex = 0;
        x:
        while(true){
            for(int i=nowIndex;i<msg.length();i++){
                String temp1 = "";
                String temp2 = "";
                for(int j=nowIndex;j<=i;j++){
                    temp1 = temp2;
                    temp2 += String.valueOf(msg.charAt(j));
                }
                // 키를 가지고 있지 않다면
                if(!map.containsKey(temp2)){
                    // 1. 해당 문자열 추가하기
                    // 2. 이전 배열 정답 배열에 넣기
                    // 3. 인덱스 변경
                    map.put(temp2, count);
                    count++;
                    answerList.add(map.get(temp1));
                    nowIndex = i;
                    // 마지막 글자이면
                    if(i==msg.length()-1){
                        answerList.add(map.get(String.valueOf(msg.charAt(i))));
                        break x;
                    }
                    break;
                }
                else{
                    if(i==msg.length()-1){
                        answerList.add(map.get(temp2));
                        break x;
                    }
                }
            }
        }

        int[] answer = new int[answerList.size()];
        for(int i=0;i<answerList.size();i++) answer[i] = answerList.get(i);
        return answer;
    }
}