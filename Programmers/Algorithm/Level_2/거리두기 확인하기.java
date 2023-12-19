import java.util.*;

class Solution {
    boolean check = false;
    boolean[][] visited;
    char[][] array;
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        // 하나의 대기실 단위로 거리두기 준수 여부를 검사한다.
        for(int i=0; i<places.length; i++){
            check = false;
            array = new char[5][5];
            for(int j=0; j<5; j++){
                array[j] = places[i][j].toCharArray();
            }
            
            for(int r=0; r<5; r++){
                for(int c=0; c<5; c++){
                    if(array[r][c] == 'P'){
                        // 미준수 인원이 발생한 경우 더이상의 검사를 중단한다
                        visited = new boolean[5][5];
                        bfs(r, c, places[i]);
                        if(check){
                            break;
                        }
                    }
                }
            }
            answer[i] = check ? 0 : 1;
        }
        return answer;
    }
    
    public void bfs(int r, int c, String[] p){
        int[][] d = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r,c});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            visited[cur[0]][cur[1]] = true;
            
            for(int i=0; i<d.length; i++){
                int nx = cur[0] + d[i][0];
                int ny = cur[1] + d[i][1];
                int distance = Math.abs(r - nx) + Math.abs(c - ny);
                
                if(distance <= 2 && nx>=0 && nx<5 && ny>=0 && ny<5 && !visited[nx][ny]){
                    if(p[nx].charAt(ny) == 'P'){
                        check = true;
                        return;
                    }
                    else if(p[nx].charAt(ny) == 'O'){
                        queue.offer(new int[]{nx, ny});
                    }
                    else if(p[nx].charAt(ny) == 'X'){
                        continue;
                    }
                }
            }
        }
    }
}