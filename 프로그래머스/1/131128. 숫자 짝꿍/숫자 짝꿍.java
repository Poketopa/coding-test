import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        // X와 Y를 한글자씩 나누어 오름차순 한다
        String[] str1 = X.split("");
        String[] str2 = Y.split("");
        Arrays.sort(str1);
        Arrays.sort(str2);
        List<String> list = new ArrayList<>();
        // str2에서 활용하는 인덱스
        int index = 0;
        // str1 인덱스 0부터 비교한다 만약 크다면 바로 스킵
        for(int i=0;i<str1.length;i++){
            while(true){
                // 같으면 리스트에 넣는다
                // 더 작으면 다음 인덱스를 찾는다
                if(index==str2.length){
                    break;
                }
                if(str1[i].equals(str2[index])){
                    list.add(str1[i]);
                    index++;
                    break;
                }
                else if(str1[i].compareTo(str2[index])<0){
                    break;
                }
                else{
                    index++;
                }
            }
            // 끝까지 하면 반복문 종료
            if(index==str2.length){
                break;
            }
        }
        if(list.isEmpty()){
            return "-1";
        }
        Collections.sort(list, Collections.reverseOrder());
        if(list.get(0).equals("0")){
            return "0";
        }
        else{
            String answer = String.join("",list);
            return answer;
        }
    }
}