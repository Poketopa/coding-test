import java.util.*;
import java.math.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        // 이름 - 인덱스 map만들기
        // 사람마다 선물을 준 2차원 배열 생성
        // 이를 통해 1차원 배열 선물지수 배열을 만든다
        
        // 이름 - 인덱스 만듦
        HashMap<String, Integer> nameIndexMap = new HashMap<>();
        for(int i=0;i<friends.length;i++) nameIndexMap.put(friends[i], i);
        
        // 2차원 배열 생성
        int[][] gift = new int[friends.length][friends.length];
        for(int i=0;i<gifts.length;i++){
            String[] whoGifted = gifts[i].split(" ");
            gift[nameIndexMap.get(whoGifted[0])][nameIndexMap.get(whoGifted[1])] += 1;
        }
        
        // 선물지수 배열 생성
        int[] giftIndex = new int[friends.length];
        for(int i=0;i<giftIndex.length;i++){
            int give = 0;
            int take = 0;
            for(int j=0;j<friends.length;j++){
                give += gift[i][j];
                take += gift[j][i];
            }
            giftIndex[i] = give - take;
        }
        
        int[] answer = new int[friends.length];
        
        for(int i=0;i<friends.length-1;i++){
            for(int j=i+1;j<friends.length;j++){
                if(gift[i][j] > gift[j][i]){
                    answer[i]++;
                }
                else if(gift[i][j] < gift[j][i]){
                    answer[j]++;
                }
                // 같을 떄
                else{
                    if(giftIndex[i]>giftIndex[j]){
                        answer[i]++;
                    }
                    else if(giftIndex[i]<giftIndex[j]){
                        answer[j]++;
                    }
                    else continue;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i : answer) if(max<i) max = i;
        return max;
    }
}