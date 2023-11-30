import java.util.*;

// 알파벳 순서가 앞서는 경로대로 따라가다가 모든 도시를 방문할 수 없을 수 있다.
// 조합과 유사한 형식으로 DFS를 구현하여 '모든 도시를 방문하는' 경로를 탐색해야한다.
class Solution {
    // 경로의 알파벳 순서를 비교하기 위해 StringBuilder를 사용한다.
    static StringBuilder sb = new StringBuilder();
    // 경로별 방문 여부를 체크한다.
    static boolean[] visited;
    // 최종 경로를 찾아낼때까지의 비교를 위한 임시경로(I보다 뒤에 위치한 문자열로 초기화)
    static String route = "String";
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        sb.append("ICN ");
        dfs(0, "ICN", tickets);
        
        String[] answer = route.split(" ");
        return answer;
    }
    
    public void dfs(int count, String start, String[][] tickets){
        // 모든 도시를 방문한 경우, 해당 경로가 알파벳 순서가 빠른지 비교한다.
        if(count == tickets.length){
            // 이전 경로(route)가 현재 경로(sb)보다 이름순으로 더 느린 경우, 갱신한다.
            if(route.compareTo(sb.toString()) > 0){
                route = sb.toString();
            }
        }
        // 모든 도시를 방문하지 못한 경우, 다음 경로를 구성한다.
        else{
            for(int i=0; i<tickets.length; i++){
                // 아직 방문하지 않은 경로이고, 티켓의 출발지가 목표 출발지와 동일한 경우
                if(!visited[i] && start.equals(tickets[i][0])){
                    visited[i] = true;
                    sb.append(tickets[i][1] + " ");
                    dfs(count+1, tickets[i][1], tickets);
                    visited[i] = false;
                    sb.delete(sb.length()-4, sb.length());
                }
            }
        }
    }
}

/*
import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<String> route;
    public String[] solution(String[][] tickets) {
        String[] answer;
        visited = new boolean[tickets.length];
        route = new ArrayList<>();
        bfs(tickets);
        
        answer = new String[route.size()];
        for(int i=0; i<route.size(); i++){
            answer[i] = route.get(i);
        }

        return answer;
    }
    
    public void bfs(String[][] tickets){
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("ICN");
        route.add("ICN");
        
        while(!queue.isEmpty()){
            String depart = queue.poll();
            
            ArrayList<String> arriveList = new ArrayList<>();
            for(int i=0; i<tickets.length; i++){
                if(!visited[i] && tickets[i][0].equals(depart)){
                    arriveList.add(tickets[i][1]);
                }
            }
            Collections.sort(arriveList);
            
            // 마지막 도시에 도착하여 다음 경유지가 없는 경우
            if(arriveList.size() == 0){
                return;
            }
            String arrive = arriveList.get(0);
            for(int i=0; i<tickets.length; i++){
                if(!visited[i]){
                    if(tickets[i][0].equals(depart) && 
                      tickets[i][1].equals(arrive)){
                        queue.offer(arrive);
                        route.add(arrive);
                        visited[i] = true;
                        break;
                    }    
                }
            }
        }
    }
}
*/