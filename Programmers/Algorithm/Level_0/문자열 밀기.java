class Solution {
    public int solution(String A, String B) {
        int answer = -1;
        for(int i=0; i<A.length(); i++){
            char[] originalArray = A.toCharArray();
            char[] slideArray = new char[A.length()];
            for(int j=0; j<A.length()-i; j++){
                slideArray[j+i] = originalArray[j];
            }
                                        
            for(int j=0; j<i; j++){
                slideArray[j] = originalArray[A.length()-i+j];
            }

            String slideString = new String(slideArray);
            if(slideString.equals(B)){
                answer = i;
                break;
            }
        }
        return answer;
    }
}