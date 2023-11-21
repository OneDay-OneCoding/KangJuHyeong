class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        // 왼쪽 위(-5,5)를 (0,0)으로 가정하고 오른쪽 아래(5,-5)를 (10,10)으로 가정한다.
        // 캐릭터는 (0,0)이 아닌 (5,5)에 위치한다고 가정한다.
        // 단순 2차원 배열로는 좌표평면을 표현하기 어렵다. 
        // (1,0)에서 (0,0)으로 오는것과 (-1,0)에서 (0,0)으로 오는 경로가 다르다.
        // [출발 x좌표][출발 y좌표][도착 x좌표][도착 y좌표]로 구성된 4차원 배열을 사용하자.
        int[][][][] map = new int[11][11][11][11];
        int x = 5;
        int y = 5;
        
        String[] direction = dirs.split("");
        for(int i=0; i<direction.length; i++){
            switch(direction[i]){
                case "U":
                    if(check(x-1,y)){
                        if(map[x][y][x-1][y] == 0){
                            map[x][y][x-1][y] = 1;
                            map[x-1][y][x][y] = 1;
                            answer += 1;
                        }
                        x -= 1;
                    }
                    break;
                case "D":
                    if(check(x+1,y)){
                        if(map[x][y][x+1][y] == 0){
                            map[x][y][x+1][y] = 1;
                            map[x+1][y][x][y] = 1;
                            answer += 1;
                        }
                        x += 1;
                    }
                    break;
                case "L":
                    if(check(x,y-1)){
                        if(map[x][y][x][y-1] == 0){
                            map[x][y][x][y-1] = 1;
                            map[x][y-1][x][y] = 1;
                            answer += 1;
                        }
                        y -= 1;
                    }
                    break;
                case "R":
                    if(check(x,y+1)){
                        if(map[x][y][x][y+1] == 0){
                            map[x][y][x][y+1] = 1;
                            map[x][y+1][x][y] = 1;
                            answer += 1;
                        }
                        y += 1;    
                    }
                    break;
            }
        }
        
        return answer;
    }
    
    boolean check(int dx, int dy){
        if(dx<0 || dx>10 || dy<0 || dy>10){
            return false;
        }
        else{
            return true;
        }
    }
}