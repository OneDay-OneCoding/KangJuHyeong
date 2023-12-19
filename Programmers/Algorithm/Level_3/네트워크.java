import java.util.*;

class Solution {
    static boolean[] visited;
    static int answer;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        bfs(n, computers);
        
        return answer;
    }
    
    public void bfs(int n, int[][] computers){
        Queue<Integer> queue = new ArrayDeque<>();
        
        // 첫 번째 정점부터 마지막 정점까지 네트워크 연결 여부를 확인한다.
        for(int i=0; i<n; i++){
            if(!visited[i]){
                queue.offer(i);
                visited[i] = true;
                
                while(!queue.isEmpty()){
                    int cur = queue.poll();    
                    
                    for(int j=0; j<n; j++){
                        if(cur != j){
                            if(!visited[j] && computers[cur][j] == 1){
                                queue.offer(j);
                                visited[j] = true;
                            }
                        }
                    }
                }
                answer += 1;
            }
        }
    }
}