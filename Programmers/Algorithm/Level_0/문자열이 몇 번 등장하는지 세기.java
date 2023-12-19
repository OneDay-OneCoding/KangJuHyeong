class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        char[] array = myString.toCharArray();
        char[] compare = pat.toCharArray();
        for(int i=0; i<=(array.length-compare.length); i++){
            boolean check = true;
            int index = 0;
            for(int j=i; j<i+compare.length; j++){
              if(array[j]==compare[index++]) {
                  continue;
              } 
              else{
                  check = false;
              }
            }
            if(check){
                answer++;
            }
        }
        return answer;
    }
}