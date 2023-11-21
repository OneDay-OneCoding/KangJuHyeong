class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        // split("")은 String을 한 문자 단위로 쪼개준다.
        String[] array = dartResult.split("");
        
        // 3번의 기회에서 각 기회별 획득한 점수를 저장한다.
        int[] score = new int[3];
        
        int index = -1;
        for(int i=0; i<array.length; i++){
            if(array[i].matches("[0-9]")){
                index++;
                
                // 두 자리수 숫자가 허용되는건 10밖에 없다.
                if(array[i].equals("1")){
                    if(array[i+1].equals("0")){
                        score[index] = 10;
                        i++;
                    }
                    else{
                        score[index] = 1;
                    }
                }
                else{
                    score[index] = Integer.parseInt(array[i]);
                }
            }
            else{
                switch(array[i]){
                    case "S":
                        break;
                    case "D":
                        score[index] = (int) Math.pow(score[index], 2);
                        break;
                    case "T":
                        score[index] = (int) Math.pow(score[index], 3);
                        break;
                    case "*":
                        // 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다.
                        // 스타상의 효과는 다른 스타상, 아차상의 효과와 중첩될 수 있다.
                        score[index] *= 2;
                        if(index > 0){
                            score[index-1] *= 2;
                        }
                        break;
                    case "#":
                        score[index] *= -1;
                        break;
                }
            }
        }
        
        for(int i=0; i<score.length; i++){
            answer += score[i];
        }
        
        return answer;
    }
}