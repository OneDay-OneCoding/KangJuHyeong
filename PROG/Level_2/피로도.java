// 순서에 따라 결과가 달라지므로, 순열을 이용하면 될 것 같다.
// 던전의 개수가 8개 이하이므로, 시간 복잡도도 문제 없을 것이다. (8!)

class Solution {
    static int[][] numbers; // 순열로 구성된 원소들을 담을 배열
    static boolean[] select; // 순열로 선택된 원소들을 식별하는 배열
    static int N, K; // 던전의 개수 N, 소모할 수 있는 피로도 K
    static int answer;
    public int solution(int k, int[][] dungeons) {
        answer = Integer.MIN_VALUE;
        numbers = new int[dungeons.length][dungeons[0].length];
        select = new boolean[dungeons.length];
        N = dungeons.length;
        K = k;
        
        perm(0, dungeons);
        return answer;
    }
    
    public void perm(int cnt, int[][] dungeons){
        // 순열이 모두 구성된 경우
        if(cnt == N){
            int k = K;
            int count = 0;
            
            for(int i=0; i<numbers.length; i++){
                if(k >= numbers[i][0]){
                    k -= numbers[i][1];
                    count += 1;
                }               
            }
            
            answer = Math.max(answer, count);
        }
        // 순열이 모두 구성되지 않은 경우
        else{
            for(int i=0; i<N; i++){
                if(!select[i]){
                    select[i] = true;
                    numbers[cnt] = dungeons[i];
                    perm(cnt+1, dungeons);
                    select[i] = false;
                }
            }
        }
    }
}