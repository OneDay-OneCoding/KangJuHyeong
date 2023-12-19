// 키패드의 숫자별 배열 위치
// 1 -> [0,0], * -> [3,0], # -> [3,2]
// 1 2 3
// 4 5 6
// 7 8 9
// * 0 #

import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[] leftPosition = new int[2]; // 왼쪽 엄지손가락의 현위치
        int[] rightPosition = new int[2]; // 오른쪽 엄지손가락의 현위치
        leftPosition[0] = 3; // 왼쪽 엄지손가락의 초기 x좌표 위치
        leftPosition[1] = 0; // 왼쪽 엄지손가락의 초기 y좌표 위치
        rightPosition[0] = 3; // 오른쪽 엄지손가락의 초기 x좌표 위치
        rightPosition[1] = 2; // 오른쪽 엄지손가락의 초기 y좌표 위치
        
        HashMap<Integer, Integer> numberPositionX = new HashMap<>(); // 숫자별 키패드 x좌표
        HashMap<Integer, Integer> numberPositionY = new HashMap<>(); // 숫자별 키패드 y좌표
        
        // 0 -> [3,1]
        numberPositionX.put(0, 3);
        numberPositionY.put(0, 1);
        
        int number = 1;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                numberPositionX.put(number, i);
                numberPositionY.put(number, j);
                number++;
            }
        }
        
        // 왼쪽 열과 오른쪽 열에 해당하는 숫자는 사용하는 엄지손가락이 정해져있지만
        // 가운데 열에 해당하는 숫자를 입력할 때는 왼손잡이인지 오른손잡이인지 판단한다.
        for(int i=0; i<numbers.length; i++){
            if(numbers[i]==1 || numbers[i]==4 || numbers[i]==7){
                leftPosition[0] = numberPositionX.get(numbers[i]);
                leftPosition[1] = numberPositionY.get(numbers[i]);
                answer += "L";
            }
            else if(numbers[i]==3 || numbers[i]==6 || numbers[i]==9){
                rightPosition[0] = numberPositionX.get(numbers[i]);
                rightPosition[1] = numberPositionY.get(numbers[i]);
                answer += "R";
            }
            else if(numbers[i]==2 || numbers[i]==5 || numbers[i]==8 || numbers[i]==0){
                int[] numberPosition = new int[2];
                numberPosition[0] = numberPositionX.get(numbers[i]);
                numberPosition[1] = numberPositionY.get(numbers[i]);

                int distanceLeft = distance(numberPosition[0], numberPosition[1], leftPosition[0], leftPosition[1]);
                int distanceRight = distance(numberPosition[0], numberPosition[1], rightPosition[0], rightPosition[1]);
                
                if(distanceLeft > distanceRight){
                    rightPosition[0] = numberPositionX.get(numbers[i]);
                    rightPosition[1] = numberPositionY.get(numbers[i]);
                    answer += "R";
                }
                else if(distanceLeft < distanceRight){
                    leftPosition[0] = numberPositionX.get(numbers[i]);
                    leftPosition[1] = numberPositionY.get(numbers[i]);
                    answer += "L";
                }
                else{
                    if(hand.equals("left")){
                        leftPosition[0] = numberPositionX.get(numbers[i]);
                        leftPosition[1] = numberPositionY.get(numbers[i]);
                        answer += "L";
                    }
                    else if(hand.equals("right")){
                        rightPosition[0] = numberPositionX.get(numbers[i]);
                        rightPosition[1] = numberPositionY.get(numbers[i]);
                        answer += "R";
                    }
                }
            }
        }
        
        return answer;
    }
    
    public int distance(int x1, int y1, int x2, int y2){
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }
}