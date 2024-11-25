import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        char[] name = new char[strings.length];
        for(int i=0;i<strings.length;i++){
            map.putIfAbsent(strings[i].charAt(n), new ArrayList<>());
            map.get(strings[i].charAt(n)).add(i);
            name[i] = strings[i].charAt(n);
        }
        // 인덱스 기준으로 정렬
        Arrays.sort(name);
        for(Character key : map.keySet()){
            for(int i=map.get(key).size();i>0;i--){
                for(int j=0;j<i-1;j++){
                    if(strings[map.get(key).get(j)].compareTo(strings[map.get(key).get(j+1)])>0){
                        int swap = map.get(key).get(j);
                        map.get(key).set(j,map.get(key).get(j+1));
                        map.get(key).set(j+1, swap);
                    }
                }
            }
        }
        String[] answer = new String[strings.length];
        for(int i=0;i<answer.length;i++){
            answer[i] = strings[map.get(name[i]).get(0)];
            map.get(name[i]).remove(0);
        }
        return answer;
    }
}