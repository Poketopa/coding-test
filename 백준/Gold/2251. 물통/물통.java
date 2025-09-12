import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int A;
	static int B;
	static int C;

	static Set<List> set = new HashSet<>();
	static Queue<int[]> queue = new LinkedList<>();
	static Set<Integer> answer = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		queue.add(new int[] {0, 0, C});
		answer.add(C);

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			int nowA = temp[0];
			int nowB = temp[1];
			int nowC = temp[2];
			// A -> C  시작, 중간 끝
			pour(nowA, nowC, nowB, C, 0, 2);
			// A -> B
			pour(nowA, nowB, nowC, B, 0, 1);
			// B -> A
			pour(nowB, nowA, nowC, A, 1, 0);
			// B -> C
			pour(nowB, nowC, nowA, C, 1, 2);
			// C -> A
			pour(nowC, nowA, nowB, A, 2, 0);
			// C -> B
			pour(nowC, nowB, nowA, B, 2, 1);
		}
		List<Integer> list = new ArrayList<>(answer);
		Collections.sort(list);
		for(int i : list) System.out.print(i + " ");
	}

	public static void pour(int from, int to, int etc, int originTo, int indexFrom, int indexTo){
		if (to < originTo && from != 0) {
			// 꽉 차면 조금 부음
			if (from > originTo - to) {
				from -= (originTo - to);
				to = originTo;
			} else {
				to += from;
				from = 0;
			}
			int[] temp = new int[3];
			temp[indexFrom] = from;
			temp[indexTo] = to;
			temp[3-(indexFrom + indexTo)] = etc;
			List<Integer> key = Arrays.asList(temp[0], temp[1], temp[2]);

			if (set.add(key)) {        // 처음 보는 상태일 때만 큐에 추가
				queue.add(temp);
				if(temp[0] == 0) answer.add(temp[2]);
			}
		}
	}
}
