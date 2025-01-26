import java.util.*;
import java.math.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        // 가능한 조합들이 저장되는 map
        // 1. 각각 orders를 돌면서 dfs 실행
        // 2. dfs를 통해 만들어진 문자열들을 각 orders로 확인 (map에 있는지 없는지)
        Map<String, Integer> map = new HashMap<>();


        for(int i=0;i<orders.length;i++){
            String[] str = orders[i].split("");
            List<String> list = new ArrayList<>();
            for(int j=0;j<orders[i].length();j++){
                // dfs
                dfs(orders, map, j, list, str, i);
            }

        }
        List<String> result = new ArrayList<>();

        for(int length : course){
            int max = 0;
            for(String i : map.keySet()){
                if(length == i.length()){
                    if(map.get(i)>max){
                        max = map.get(i);
                    }
                }
            }
            for(String i : map.keySet()){
                if(length == i.length() && map.get(i) == max){
                    result.add(i);
                }
            }
        }
        Collections.sort(result);
        String[] answer = new String[result.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = result.get(i);
        }
        return answer;
    }

    private void dfs(String[] orders, Map<String, Integer> map, int nowIndex, List<String> list, String[] str, int whereAmI){
        list.add(str[nowIndex]);

        // 크기 2 이상일 때 다른 것들과 비교
        if(list.size()>1){
            // 리스트의 문자열 만들기
            String[] tempArr = new String[list.size()];
            for(int i=0;i<list.size();i++) tempArr[i] = list.get(i);
            Arrays.sort(tempArr);
            String temp = String.join("", tempArr);
            int length = temp.length();
            int count = 0;
            if(!map.containsKey(temp)) {
                for(int i=0;i<orders.length;i++){
                    if(i == whereAmI) continue;
                    String replaceStr = orders[i];
                    for(int j=0;j<temp.length();j++){
                        replaceStr = replaceStr.replace(String.valueOf(temp.charAt(j)), "");
                    }
                    // 포함되어있으면
                    if(orders[i].length()-replaceStr.length() == length){
                        count++;
                    }
                }
                if(count>0)map.put(temp, count);
            }
        }
        for(int i=nowIndex+1;i<str.length;i++){
            dfs(orders, map, i, list, str, whereAmI);
        }
        list.remove(list.size()-1);
    }
}
