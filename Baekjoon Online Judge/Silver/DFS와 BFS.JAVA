import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, V; // 정점의 개수 N, 간선의 개수 M, 시작 정점의 번호 V
    static StringBuilder sb = new StringBuilder();
    static int[][] matrix; // 정점간 간선 연결 여부를 나타내는 배열
    static boolean[] visited; // 정점의 방문 여부를 나타내는 배열
    
	public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	V = Integer.parseInt(st.nextToken());
    	
    	//  정점의 번호가 1부터 시작하므로, 공간을 추가로 확보해준다.
    	matrix = new int[N+1][N+1];
    	visited = new boolean[N+1];
    	
    	for(int i=0; i<M; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
    		int from = Integer.parseInt(st.nextToken());
    		int to = Integer.parseInt(st.nextToken());
    		
    		// 입력으로 주어지는 간선은 양방향이다.
    		matrix[from][to] = matrix[to][from] = 1;
    	}
    	
    	dfs(V);
    	sb.append("\n");
    	bfs();
    	
    	System.out.println(sb);
    }
	
	static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		visited = new boolean[N+1];
		visited[V] = true;
		queue.offer(V);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			sb.append(cur + " ");
			
			for(int i=1; i<=N; i++) {
				// 방문한적 없는 정점이고, 정점 간 연결이 되어있는 경우
				if(!visited[i] && matrix[cur][i] == 1) {
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
	}
	
	static void dfs(int cur) {
		sb.append(cur + " ");
		visited[cur] = true;
		
		for(int i=1; i<=N; i++) {
			if(!visited[i] && matrix[cur][i] == 1) {
				dfs(i);
			}
		}
	}
}