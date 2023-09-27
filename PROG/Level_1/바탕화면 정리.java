class Solution {
    public int[] solution(String[] wallpaper) {
        // 최소 거리로 드래그를 하기 위해, 4가지 정보를 알아야한다.
        // (x축 최소값, y축 최소값), (x축 최대값, y축 최대값)
        // 1개의 파일은 4개의 좌표값을 가진다.
        int[] answer = new int[4];
        char[][] map = new char[wallpaper.length][wallpaper[0].length()];
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, 
        maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        
        for(int i=0; i<wallpaper.length; i++){
            char[] str = wallpaper[i].toCharArray();
            for(int j=0; j<wallpaper[i].length(); j++){
                map[i][j] = str[j];
            }
        }
        
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                if(map[i][j] == '#'){
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i+1);
                    maxY = Math.max(maxY, j+1);
                }
            }
        }
        
        answer[0] = minX;
        answer[1] = minY;
        answer[2] = maxX;
        answer[3] = maxY;
        
        return answer;
    }
}