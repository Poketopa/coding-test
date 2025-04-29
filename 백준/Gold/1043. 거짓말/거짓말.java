import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int people = Integer.parseInt(st.nextToken());
        int party = Integer.parseInt(st.nextToken());
        parent = new int[people + 1];
        for(int i=1;i<parent.length;i++){
            parent[i] = i;
        }

        // 진실을 처음부터 아는 사람 확인
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int truePeople = Integer.parseInt(st2.nextToken());
        for (int i = 0; i < truePeople; i++) {
            parent[Integer.parseInt(st2.nextToken())] = 0;
        }

        List<List<Integer>> list = new ArrayList<>();

        // 파티 확인
        for (int q = 0; q < party; q++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st3.nextToken());
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < temp; i++) {
                int partyMember = Integer.parseInt(st3.nextToken());
                tempList.add(partyMember);
            }
            list.add(tempList);
        }

        // 한번 돌면서 분류하기
        for(int i=0;i<list.size();i++){
            if(list.get(i).size() < 2){
                // 비교할 것 없으면 넘어감
                continue;
            }
            for(int j=1;j<list.get(i).size();j++){
                union(list.get(i).get(j), list.get(i).get(j-1));
            }
        }

        int count = 0;
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.get(i).size();j++){
                if(find(list.get(i).get(j)) == 0) {
                    break;
                }
                if(j == list.get(i).size()-1){
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if(rootA != rootB){
            if(rootA < rootB){
                parent[rootB] = rootA;
            }
            else{
                parent[rootA] = rootB;
            }
        }
    }

    public static int find(int a) {
        if(a == parent[a]) return a;
        else return parent[a] = find(parent[a]);
    }
}
