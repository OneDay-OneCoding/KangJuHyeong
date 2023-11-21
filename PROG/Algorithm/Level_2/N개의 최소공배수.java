// #TC1. 2,6,8,14 -> 1,2,3,4,7이 약수로 들어오고, 모두 곱하면 LCM인 168이 나온다.
// #TC2. 1,2,3 -> 1,2,3을 모두 곱하면 6이 나온다.
// -> 2개의 숫자들끼리 묶어서 순차적으로 LCM을 구하면 될 것 같다.
// -> [2,6] = 2 * 1 * 3 = 6, [6,8] = 2 * 3 * 4 = 24, [24,14] = 2 * 12 * 7 = 168
import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        // 공약수들을 담을 리스트
        ArrayList<Integer> gcd = new ArrayList<>();
                
        // 첫번째 원소와 두번째 원소의 최소공배수를 구한 다음, array[i+1]에 저장한다.
        for(int i=0; i<arr.length-1; i++){
            int number = 2;
            gcd = new ArrayList<>();
            
            while(true){
                if(number > Math.min(arr[i], arr[i+1])){
                    break;
                }
                else{
                    // 두 원소간 공약수가 존재하는 경우
                    while((arr[i]%number == 0) && (arr[i+1]%number == 0)){
                        gcd.add(number);
                        arr[i] /= number;
                        arr[i+1] /= number;
                    }
                    number++;
                }
            }
            if(gcd.size() == 0){
                arr[i+1] = arr[i] * arr[i+1];
            }
            else{
                int lcm = 1;
                for(int j=0; j<gcd.size(); j++){
                    lcm *= gcd.get(j);
                }
                lcm *= arr[i];
                lcm *= arr[i+1];
                arr[i+1] = lcm;
                
            }
        }
        answer = arr[arr.length-1];
    
        return answer;
    }
}

/*
// 중복된 약수가 들어가는 것을 방지하기 위해 Set을 이용한다.
// 본인의 숫자를 포함해야하는지, 아닌지에 대한 여부는 어떻게 알 수 있을까?
// -> 1 이외에 다른 약수가 없는 소수인 경우 자신을 포함하면 될 것 같다.
// -> 1,2,4와 같이 소수의 제곱수(2*2 = 4)로 구성된 수의 경우 제대로 연산되지 않는다.

class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<arr.length; i++){
            int count = 1; // 약수의 개수
            int num = 1;
            
            while(true){
                if(arr[i] == 1 || arr[i] == 2){
                    set.add(arr[i]);
                    break;
                }
                else if(num > arr[i]){
                    // 소수인 경우
                    if(count == 2){
                        set.add(arr[i]);
                    }
                    break;
                }
                else{
                    if(arr[i]%num == 0){
                        if(num != arr[i]){
                            set.add(num);
                            count += 1;
                        }
                    }
                    num += 1;
                }
            }
        }
        
        Iterator iter = set.iterator();
        while(iter.hasNext()){
            answer *= (int)iter.next();
        }
        
        return answer;
    }
}
*/