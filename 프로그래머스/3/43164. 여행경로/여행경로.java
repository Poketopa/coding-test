import java.util.*;

class Solution {
    static int flag = 0;
    public String[] solution(String[][] tickets) {
        int count = 0;
        List<String> answer = new ArrayList<>();
        answer.add("ICN");
        int[] visited = new int[tickets.length];
        String start = "ICN";
        dfs(start, tickets, visited, count, answer);
        String[] newAnswer = answer.toArray(new String[0]);
        return newAnswer;
    }

    private void dfs(String departure, String[][] tickets, int[] visited, int count, List<String> answer){
        if(flag == 1) return;
        int indexCount = 0;
        // 알파벳 순으로 탐험해야한다
        // 리스트를 만들어서 정렬
        List<String[]> arrivalList = new ArrayList<>();
        for(int i=0;i<tickets.length;i++){
            if(visited[i] == 1) {
                indexCount++;
                continue;
            }
            if(tickets[i][0].equals(departure)){
                arrivalList.add(new String[]{tickets[i][1], String.valueOf(i)});
            }
        }
        if(indexCount == tickets.length&&count == tickets.length){
            flag = 1;
            return;
        }
        // 정렬
        Collections.sort(arrivalList, (a, b)->{
            return a[0].compareTo(b[0]);
        });

        for(int i=0;i<arrivalList.size();i++){
            visited[Integer.valueOf(arrivalList.get(i)[1])] = 1;
            answer.add(arrivalList.get(i)[0]);
            dfs(arrivalList.get(i)[0], tickets, visited, count+1, answer);
            if(flag==0){
                visited[Integer.valueOf(arrivalList.get(i)[1])] = 0;
                answer.remove(answer.size()-1);
            }
            else{
                return;
            }
        }
    }
}