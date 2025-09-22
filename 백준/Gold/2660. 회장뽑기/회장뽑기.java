import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());

		int input = Integer.parseInt(br.readLine());
		List<Integer>[] user = new List[input + 1];
		for(int i=0;i<user.length;i++) user[i] = new ArrayList<>();
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a==-1) break;
			user[a].add(b);
			user[b].add(a);
		}
		int min = Integer.MAX_VALUE;
		int[] distance = new int[input + 1];
		// 1부터 큐에 넣어서 확인해야함
		// visited로 확인, count로 학생 수가 완성되면 그 때 몇 번째 탐색인지 저장
		// 이 때 탐색의 최소값을 저장해놓는다.
		for(int i=1;i<=input;i++){
			Queue<int[]> queue = new LinkedList<>();
			int[] visited = new int[input + 1];
			int count = 1;
			queue.add(new int[]{i, 0});
			visited[i] = 1;
			x:while(!queue.isEmpty()){
				int[] temp = queue.poll();
				for(int j=0;j<user[temp[0]].size();j++){
					if(visited[user[temp[0]].get(j)] == 1) continue;
					visited[user[temp[0]].get(j)] = 1;
					count++;
					if(count == input){ // 다 찾음
						min = Math.min(min, temp[1] + 1);
						distance[i] = temp[1] + 1;
						break x;
					}
					queue.add(new int[]{user[temp[0]].get(j), temp[1] + 1});
				}
			}
		}
		int answerCount = 0;
		for(int i : distance) if(i == min) answerCount++;
		System.out.println(min + " " + answerCount);
		for(int i=1;i<=input;i++){
			if(distance[i] == min) System.out.print(i + " ");
		}
	}
}
