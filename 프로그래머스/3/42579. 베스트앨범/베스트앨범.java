import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 1, 해시맵 (문자열, 정수) 만들기 2, 해시맵(문자열, 정수리스트(인덱스))) 만들기
        HashMap<String, Integer> playSum = new HashMap<>();
        HashMap<String, List<Integer>> indexMap = new HashMap<>();

        for(int i=0;i<genres.length;i++){
            // 값이 없으면
            if(!playSum.containsKey(genres[i])){
                playSum.put(genres[i], 0);
                indexMap.put(genres[i], new ArrayList<>());
            }
            playSum.put(genres[i], playSum.get(genres[i]) + plays[i]);
            indexMap.get(genres[i]).add(i);
        }

        // 장르 이름 배열
        String[] music = playSum.keySet().toArray(new String[0]);
        // 총 재생수로 정렬
        Arrays.sort(music, (a, b)->{
            if(playSum.get(a)<playSum.get(b)) return 1;
            else if(playSum.get(a)>playSum.get(b)) return -1;
            else return 0;
        });
        for(int i=0;i<music.length;i++){
            Collections.sort(indexMap.get(music[i]), (a, b)->{
                if(plays[a]<plays[b]) return 1;
                else if(plays[a]>plays[b]) return -1;
                else return 0;
            });
        }
        List<Integer> answerList = new ArrayList<>();

        for(int i=0;i<music.length;i++){
            // 1개일 때
            if(indexMap.get(music[i]).size() == 1){
                answerList.add(indexMap.get(music[i]).get(0));
            }
            else{
                answerList.add(indexMap.get(music[i]).get(0));
                answerList.add(indexMap.get(music[i]).get(1));
            }
        }
        int[] answer = new int[answerList.size()];

        for(int i=0;i<answer.length;i++) answer[i] = answerList.get(i);
        return answer;
    }
}