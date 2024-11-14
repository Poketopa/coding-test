import java.util.*;

class Solution {
    
    public String[] solution(String[] players, String[] callings) {
        int index=0;
        String swap = ""; 
        
        // 해시 만든다
        HashMap<String, Integer> indexMap = new HashMap<>();
        for(int i=0;i<players.length;i++){
            indexMap.put(players[i],i);
        }
        
        //callings 돌면서 바꾸기
        for(String name : callings){
            int nowIndex = indexMap.get(name);
            if(nowIndex>0){
                swap = players[nowIndex];
                if(indexMap.containsKey(players[nowIndex-1])){
                    indexMap.put(players[nowIndex-1], nowIndex);
                }
                players[nowIndex] = players[nowIndex-1];
                players[nowIndex-1] = swap;
                indexMap.put(name, nowIndex-1);
            }
            
        }
        
        
        return players;
    }
}