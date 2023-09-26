import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        // N : 스테이지 수
        // stages.length : 사용자 수
        int[] answer = new int[N];
        int[] arrival = new int[N+2];
        int[] fail = new int[N+2];
        double[] rate = new double[N+2];
        Stage[] stage = new Stage[N];
        
        for(int i=0; i<stages.length; i++){
            fail[stages[i]]++;
        }
        
        // 스테이지가 1번부터 있으므로, 인덱스 1번부터 시작한다.
        for(int i=1; i<arrival.length-1; i++){
            for(int j=i; j<fail.length; j++){
                arrival[i] += fail[j];
                try{
                    // 0을 0으로 나눴을때, rate[i]=1이 되는 문제해결
                    if(arrival[i]==0 && fail[i]==0){
                        rate[i] = 0;
                    }
                    else{
                        rate[i] = (double)fail[i]/arrival[i]; 
                    }
                } catch(ArithmeticException e){
                    continue;
                }
            }
        }
        for(int i=0; i<N; i++){
            stage[i] = new Stage(i+1, rate[i+1]);
        }
        Arrays.sort(stage);
        
        for(int i=0; i<answer.length; i++){
            answer[i] = stage[i].number;
        }

        return answer;
    }
}

class Stage implements Comparable<Stage>{
    int number; // 스테이지 번호
    double rate; // 해당 스테이지의 실패율
    
    public Stage(int n, double r){
        number = n;
        rate = r;
    }
    
    @Override
    public int compareTo(Stage s){
        if(Double.compare(this.rate,s.rate) == 0){
            return this.number - s.number;   
        }
        return Double.compare(s.rate, this.rate);
    }
}