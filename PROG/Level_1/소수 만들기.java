class Solution {
    static int[] numbers;
    static int answer = 0;
    static int N = 3;
    public int solution(int[] nums) {
        numbers = new int[N];
        comb(0,0,nums);
       
        return answer;
    }
    
    public void comb(int cnt, int index, int[] nums){
        if(cnt == N){
            int sum = 0;
            for(int i=0; i<N; i++){
                sum += numbers[i];
            }
            for(int i=2; i*i<=sum; i++){
                if(sum%i == 0){
                    return;
                }
            }
            answer++;
        }
        else{
            for(int i=index; i<nums.length; i++){
                numbers[cnt] = nums[i];
                comb(cnt+1, i+1, nums);
            }
        }
    }
}