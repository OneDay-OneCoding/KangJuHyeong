// 4 7
// 1 4 5 7
// 1 2 3 4 5 6 7 8

// 4 -> 2 -> 1
// 7 -> 3 -> 2

// 4 -> 2 -> 1
// 8 -> 4 -> 2

// 1 -> 1
// 4 -> 2

// 5 -> 3
// 7 -> 4

// 1 -> 1 -> 1
// 7 -> 4 -> 2

// 6 -> 3
// 7 -> 4

class Solution{
    public int solution(int n, int a, int b){
        int answer = 1;
        
        while(true){
            if((a==b+1) || (a==b-1)) {
                // a와 b가 서로 1차이가 나더라도, 같은 대진표에 있어야 경기가 성립된다.
                // a = 6, b = 7인 경우 경기가 성립되지 않는다. (a = 5, b = 6 이어야 성립)
                if(a%2 == 0 && b == a-1){
                    break;
                }
                else if(b%2 == 0 && a == b-1){
                    break;    
                }
                else{
                    if(a%2 == 0){
                        a /= 2;
                    }
                    else{
                        a /= 2;
                        a += 1;
                    }

                    if(b%2 == 0){
                        b /= 2;
                    }
                    else{
                        b /= 2;
                        b += 1;
                    }
                    answer += 1;
                }
            }
            else{
                if(a%2 == 0){
                    a /= 2;
                }
                else{
                    a /= 2;
                    a += 1;
                }
                
                if(b%2 == 0){
                    b /= 2;
                }
                else{
                    b /= 2;
                    b += 1;
                }
                answer += 1;
            }
        }
        
        return answer;
    }
}