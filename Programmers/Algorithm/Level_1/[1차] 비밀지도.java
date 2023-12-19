class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i<n; i++){
            answer[i] = "";
        }
        
        String[] binaryOne = new String[n];
        String[] binaryTwo = new String[n];
        
        for(int i=0; i<arr1.length; i++){
            String binary = Integer.toString(arr1[i], 2);
            while(true){
                if(binary.length() == n){
                    break;
                }
                else{
                    binary = "0" + binary;
                }
            }
            binaryOne[i] = binary;
        }
        
        for(int i=0; i<arr2.length; i++){
            String binary = Integer.toString(arr2[i], 2);
            while(true){
                if(binary.length() == n){
                    break;
                }
                else{
                    binary = "0" + binary;
                }
            }
            binaryTwo[i] = binary;
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(binaryOne[i].charAt(j) == '1' || 
                   binaryTwo[i].charAt(j) == '1'){
                    answer[i] += "#";
                }
                else{
                    answer[i] += " ";
                }
            }
        }
        
        return answer;
    }
}