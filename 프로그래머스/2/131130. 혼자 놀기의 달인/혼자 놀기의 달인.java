class Solution {
            static int max = Integer.MIN_VALUE;
            public int solution(int[] cards) {

                for(int i=0;i<cards.length;i++){
                    int[] visited = new int[cards.length];
                    int count = 0;
                    int now = i;
                    while(true){
                        visited[now] = 1;
                        count++;
                        now = cards[now] - 1;
                        if(visited[now] == 1) break;
                    }
                    if(count == cards.length){
                        return 0;
                    }
                    for(int j=0;j<cards.length;j++){
                        if(visited[j] == 1) continue;
                        int[] visited2 = new int[cards.length];
                        int count2 = 0;
                        int now2 = j;
                        while(true){
                            visited2[now2] = 1;
                            count2++;
                            now2 = cards[now2] - 1;
                            if(visited2[now2] == 1) break;
                        }
                        max = Math.max(max, count * count2);
                    }
                    
                }
                return max;
            }
        }