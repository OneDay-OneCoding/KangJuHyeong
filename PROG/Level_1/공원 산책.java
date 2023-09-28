class Solution {
    static int[] answer;
    static char[][] map;
    public int[] solution(String[] park, String[] routes) {
        answer = new int[2]; // 이동을 마친 로봇 강아지의 최종 좌표
        map = new char[park.length][park[0].length()];
        
        // String으로 주어진 공원 정보를 char[] 형태로 쪼개어 저장하고 시작 좌표를 알아낸다.
        for(int i=0; i<park.length; i++){
            char[] m = park[i].toCharArray();
            for(int j=0; j<m.length; j++){
                map[i][j] = m[j];
                if(m[j] == 'S'){
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        
        for(int i=0; i<routes.length; i++){
            String direction = routes[i].substring(0,1); // 방향
            int move = Integer.parseInt(routes[i].substring(2,3)); // 이동횟수
            
            switch(direction){
                case "N": // 북쪽
                    if(check(direction, move)){
                        answer[0] -= move; 
                    }
                    break;
                case "S": // 남쪽
                    if(check(direction, move)){
                        answer[0] += move; 
                    }
                    break;
                case "W": // 서쪽
                    if(check(direction, move)){
                        answer[1] -= move; 
                    }
                    break;
                case "E": // 동쪽
                    if(check(direction, move)){
                        answer[1] += move; 
                    }
                    break;
            }
        }
        
        return answer;
    }
    
    public boolean check(String d, int m){
        switch(d){
            case "N": // 북쪽
                if(answer[0]-m < 0){
                    return false;
                }
                else{
                    for(int i=answer[0]; i>=answer[0]-m; i--){
                        if(map[i][answer[1]] == 'X'){
                            return false;
                        }
                    }
                }
                return true;
            case "S": // 남쪽
                if(answer[0]+m > map.length-1){
                    return false;
                }
                else{
                    for(int i=answer[0]; i<=answer[0]+m; i++){
                        if(map[i][answer[1]] == 'X'){
                            return false;
                        }
                    }
                }
                return true;
            case "W": // 서쪽
                if(answer[1]-m < 0){
                    return false;
                }
                else{
                    for(int i=answer[1]; i>=answer[1]-m; i--){
                        if(map[answer[0]][i] == 'X'){
                            return false;
                        }
                    }
                }
                return true;
            case "E": // 동쪽
                if(answer[1]+m > map[0].length-1){
                    return false;
                }
                else{
                    for(int i=answer[1]; i<=answer[1]+m; i++){
                        if(map[answer[0]][i] == 'X'){
                            return false;
                        }
                    }
                }
                return true;
        }
        
        return true;
    }
}