// #TC1. brown = 10 -> 최소 가로 길이 3 (루트), yellow = 2 -> 최소 세로 길이 1 (루트)
// [3,1]부터 정답이 나올때까지 완전 탐색을 진행한다.
// 위 방법으로는 경우의 수가 너무 많아 시간 초과가 발생하므로, 격자 수의 합에 대한 약수 조합을 구해야한다.

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // 카펫의 가로 길이 width, 카펫의 세로 길이 height
        int width = (int)Math.sqrt(brown);
        int height = (int)Math.sqrt(yellow);
        
        // 카펫의 가로 길이와 세로 길이를 곱했을때 일치해야하는 목표값
        int target = brown + yellow;
        
        // #TC1. brown + yellow -> [1,12], [2,6], [3,4], [4,3], [6,2], [12,1]
        // #TC2. brown + yellow -> [1,9], [3,3], [9,1]
        for(int i=1; i<=target; i++){
            if(target%i == 0){
                int w = i;
                int h = target/i;
                
                // 카펫의 가로 길이는 세로 길이와 같거나 더 길어야한다.
                if(w >= h){
                    // yellow = (세로 길이-2) * (가로 길이-2)
                    if(((w-2)*(h-2)) == yellow){
                        answer[0] = w;
                        answer[1] = h;
                        break;
                    }
                }
            }
        }
       
        return answer;
    }
}

/*
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // 카펫의 가로 길이 width, 카펫의 세로 길이 height
        int width = (int)Math.sqrt(brown);
        int height = (int)Math.sqrt(yellow);
        
        // 카펫의 가로 길이와 세로 길이를 곱했을때 일치해야하는 목표값
        int target = brown + yellow;
        
        // 반복문 내부에서 값을 변동해가며 일치값을 찾아내는 인자들
        int w = width;
        int h = height;
        
        OUT: while(true){
            // 갈색 격자와 노란색 격자의 최댓값을 곱했을때, int의 표현 범위를 초과한다.
            if(w*h == target){
                answer[0] = w;
                answer[1] = h;
                break;
            }        
            else{
                for(int i=h+1; i<=w; i++){
                    if(w*i == target){
                        answer[0] = w;
                        answer[1] = i;
                        
                        // 일치하는 값을 찾았을 경우, for문을 감싼 while문 전체를 탈출한다.
                        break OUT;    
                    }
                }
                
                // 가로 길이는 한칸 더 늘리고, 세로 길이는 최솟값으로 원상복구해준다.
                w = w+1;
            }
        }
        
        return answer;
    }
}
*/