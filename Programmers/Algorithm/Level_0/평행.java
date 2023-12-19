class Solution {
    public int solution(int[][] dots) {
        // 4개의 점에 대해서는 6개의 선분이 생성될 수 있다.
        // 각 선분의 기울기를 구한 다음, 기울기가 동일한 2개의 선분이 존재하는지 확인한다.
        // [(0,1),(2,3)], [(0,2),(1,3)], [(0,3),(1,2)]
        int answer = 0;
        double[] angle = new double[6];
        
        angle[0] = getAngle(dots[0][0], dots[0][1], dots[1][0], dots[1][1]);
        angle[1] = getAngle(dots[2][0], dots[2][1], dots[3][0], dots[3][1]);
        
        angle[2] = getAngle(dots[0][0], dots[0][1], dots[2][0], dots[2][1]);
        angle[3] = getAngle(dots[1][0], dots[1][1], dots[3][0], dots[3][1]);
        
        angle[4] = getAngle(dots[0][0], dots[0][1], dots[3][0], dots[3][1]);
        angle[5] = getAngle(dots[1][0], dots[1][1], dots[2][0], dots[2][1]);
        
        if(angle[0]==angle[1] || angle[2]==angle[3] || angle[4]==angle[5]){
            answer = 1;
        }
        
        return answer;
    }
    
    public double getAngle(int x1, int y1, int x2, int y2){
        return Math.abs((double)(y2-y1)/(x2-x1));
    }
}